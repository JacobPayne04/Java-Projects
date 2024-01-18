package com.Jacob.BookClub.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Jacob.BookClub.models.Book;
import com.Jacob.BookClub.repositores.BookRepository;

@Service
public class BookService {
    
	// CONNECTS SERVERS TO THE REPOSITORY
    private final BookRepository bookRepo;

    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }
    
    // get all
    public List<Book> getAll(){
        return (List<Book>)bookRepo.findAll();
    }
    
    // create one
    public Book create(Book book) {
        return bookRepo.save(book);
    }
    
    // get one by id
    public Book getOne(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        return optionalBook.isPresent() ? optionalBook.get() : null;
    }

    
    // edit
    public Book edit(Book book) {
        return bookRepo.save(book);
    }
    
    // delete by id
    public void Delete(Long id) {
        bookRepo.deleteById(id);
    }
}