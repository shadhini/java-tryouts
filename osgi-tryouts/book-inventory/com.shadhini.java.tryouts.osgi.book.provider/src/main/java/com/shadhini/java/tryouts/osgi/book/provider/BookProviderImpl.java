package com.shadhini.java.tryouts.osgi.book.provider;

import com.shadhini.java.tryouts.osgi.book.provider.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BookProviderImpl implements BookProvider {

    private static final Logger LOGGER = Logger.getLogger(BookProviderImpl.class.getName());
    private static volatile  BookProviderImpl bookProvider;
    private  static List<Book> books = new ArrayList<Book>();

    private BookProviderImpl(){

    }

    // use singleton design patten to create a single instance
    public static BookProviderImpl getInstance(){
        if(bookProvider==null){
            synchronized (BookProviderImpl.class){
                if(bookProvider == null){
                    bookProvider = new BookProviderImpl();
                }
            }
        }
        return bookProvider;
    }

    public void createBook(String bookName, String authorName, String ISBN){
        Book book = new Book(bookName, authorName, ISBN);
        LOGGER.info("Created a Book: "+book.getBookName());
    }

    public List<Book> listBooks(){
        return books;
    }
}
