package com.example.library.models;

import java.io.Serializable;

public class BooksDes implements Serializable {
    private int imageBook;
    private String textBooksHeading;
    private String textBookDesc;

    public BooksDes(int imageBook, String textBooksHeading, String textBookDesc) {
        this.imageBook = imageBook;
        this.textBooksHeading = textBooksHeading;
        this.textBookDesc = textBookDesc;
    }

    public int getImageBook() {
        return imageBook;
    }

    public void setImageBook(int imageBook) {
        this.imageBook = imageBook;
    }

    public String getTextBooksHeading() {
        return textBooksHeading;
    }

    public void setTextBooksHeading(String textBooksHeading) {
        this.textBooksHeading = textBooksHeading;
    }

    public String getTextBookDesc() {
        return textBookDesc;
    }

    public void setTextBookDesc(String textBookDesc) {
        this.textBookDesc = textBookDesc;
    }
}
