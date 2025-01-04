package com.shadhini.java.tryouts.osgi.book.reader.internal;

import com.shadhini.java.tryouts.osgi.book.provider.BookProvider;

import java.util.logging.Logger;

public class ReaderDataHolder {
    private static final Logger LOGGGER = Logger.getLogger(ReaderDataHolder.class.getName());
    private static ReaderDataHolder instance = new ReaderDataHolder();
    private BookProvider bookProvider;

    private ReaderDataHolder(){}

    public static ReaderDataHolder getInstance(){
        return instance;
    }

    public BookProvider getBookProvider(){
        return bookProvider;
    }

    public void setBookProvider(BookProvider bookProvider){
        this.bookProvider = bookProvider;
    }
}
