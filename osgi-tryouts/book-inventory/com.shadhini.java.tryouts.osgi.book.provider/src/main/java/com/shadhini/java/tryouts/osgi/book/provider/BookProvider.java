package com.shadhini.java.tryouts.osgi.book.provider;

import com.shadhini.java.tryouts.osgi.book.provider.model.Book;

import java.util.List;

public interface BookProvider {
    void createBook(String bookName, String authorName, String ISBN);

    List<Book> listBooks();
}
