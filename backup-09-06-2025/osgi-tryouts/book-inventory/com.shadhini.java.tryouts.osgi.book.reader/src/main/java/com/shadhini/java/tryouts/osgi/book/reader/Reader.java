package com.shadhini.java.tryouts.osgi.book.reader;

import com.shadhini.java.tryouts.osgi.book.reader.internal.ReaderDataHolder;

public class Reader {

    public void getBookCreated(String bookName, String authorName,String ISBN){
        ReaderDataHolder.getInstance().getBookProvider().createBook(bookName, authorName, ISBN);
    }
}
