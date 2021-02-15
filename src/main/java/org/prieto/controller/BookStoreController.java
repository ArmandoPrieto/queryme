package org.prieto.controller;

import org.prieto.domain.Book;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.prieto.service.BookstoreService;

import javax.inject.Inject;

@Controller("/store")
public class BookStoreController {

    @Inject
    BookstoreService bookstoreService;

    @Get("/book")
    public Book getBook(){
        return bookstoreService.createBook("Cien anos de soledad", "123");
    }



}