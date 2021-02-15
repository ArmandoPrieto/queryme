package org.prieto.service;

import org.prieto.domain.Book;
import org.prieto.repository.BookRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;

public class BookstoreService {

    @Inject
    BookRepository bookRepository;

    @Transactional
    public Book createBook(String title, String isbn){
       return bookRepository.save(new Book(title, isbn));
    }

    @Transactional
    public void getBook(){

    }

    @Transactional
    public void removeBook(){

    }
    
}
