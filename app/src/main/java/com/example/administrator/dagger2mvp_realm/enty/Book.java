package com.example.administrator.dagger2mvp_realm.enty;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Book extends RealmObject {

    @PrimaryKey
    private int id;

    private String isbn;
    private String title;
    private Author author;
    private Publisher publisher;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(final String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(final Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(final Publisher publisher) {
        this.publisher = publisher;
    }

    public String getDetails() {
        StringBuilder details = new StringBuilder();
        details.append(getAuthorFullName());
        details.append(" | ");
        details.append(getPublisher().getName());
        return details.toString();
    }

    public String getAuthorFullName() {
        return String.format("%s %s", getAuthor().getName(), getAuthor().getLastname());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", publisher=" + publisher +
                '}';
    }
}
