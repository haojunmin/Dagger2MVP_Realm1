package com.example.administrator.dagger2mvp_realm.enty;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Book extends RealmObject {


    private String isbn;
    private String title;
    // private Author author;
    // private Publisher publisher;


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


    public String getDetails() {
        StringBuilder details = new StringBuilder();

        details.append(" | ");
        return details.toString();
    }


    @Override
    public String toString() {
        return "Book{" +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
