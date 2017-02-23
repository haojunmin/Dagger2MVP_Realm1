package com.example.administrator.dagger2mvp_realm.db;

import com.example.administrator.dagger2mvp_realm.enty.Author;
import com.example.administrator.dagger2mvp_realm.enty.Book;
import com.example.administrator.dagger2mvp_realm.enty.Publisher;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Administrator on 2017/2/23.
 */

public class RealmService {
    private Realm mRealm;

    public RealmService() {
        mRealm = Realm.getDefaultInstance();
    }

    public RealmResults<Book> getAllBooks() {
        return mRealm.where(Book.class).findAll();
    }

    public void addBookAsync(final String title,
                             final String author, final String isbn, final String publisher) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Book book = mRealm.createObject(Book.class);
                book.setId(realm.where(Book.class).findAll().size());
                book.setTitle(title);
                book.setAuthor(createOrGetAuthor(author, book, realm));
                book.setPublisher(createOrGetPublisher(publisher, book, realm));
                book.setIsbn(isbn);
            }
        });
    }

    private Publisher createOrGetPublisher(final String publisher, final Book book, final Realm realm) {
        Publisher foundPublisher = getPublisher(publisher, realm);
        if (foundPublisher == null) {
            foundPublisher = addPublisher(publisher, realm);
        }
        foundPublisher.getBooks().add(book);
        return foundPublisher;
    }

    private Publisher addPublisher(final String publisherName, final Realm realm) {
        Publisher publisher = realm.createObject(Publisher.class);
        publisher.setId(realm.where(Publisher.class).findAll().size());
        publisher.setName(publisherName);
        return publisher;
    }

    private Author createOrGetAuthor(final String author, final Book book, final Realm realm) {
        String[] authorName = splitAuthorName(author);
        Author foundAuthor = getAuthor(authorName, realm);
        if (foundAuthor == null) {
            foundAuthor = addAuthor(authorName, realm);
        }
        foundAuthor.getBooks().add(book);
        return foundAuthor;
    }

    private Author addAuthor(final String[] authorName, final Realm realm) {
        Author author = realm.createObject(Author.class);
        author.setId((int) realm.where(Author.class).findAll().size());
        author.setName(authorName[0]);
        author.setLastname(authorName[1]);
        return author;
    }

    private String[] splitAuthorName(final String author) {
        return author.split(" ");
    }

    private Author getAuthor(final String[] authorName, final Realm realm) {
        return realm.where(Author.class).equalTo("name", authorName[0]).equalTo("lastname", authorName[1]).findFirst();
    }

    private Publisher getPublisher(final String publisher, final Realm realm) {
        return realm.where(Publisher.class).equalTo("name", publisher).findFirst();
    }

    public interface OnTransactionCallback {
        void onRealmSucess();

        void onRealmErroe(Exception e);
    }
}
