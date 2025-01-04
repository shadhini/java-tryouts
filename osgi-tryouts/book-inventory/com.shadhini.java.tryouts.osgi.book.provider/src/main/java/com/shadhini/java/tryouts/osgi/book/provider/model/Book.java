package com.shadhini.java.tryouts.osgi.book.provider.model;

public class Book {
    private String bookName;
    private String authorName;
    private String ISBN;

    public Book(){}

    public Book(String bookName, String authorName, String ISBN){
        this.bookName = bookName;
        this.authorName = authorName;
        this.ISBN = ISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
