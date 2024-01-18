package com.Jacob.BookClub.repositores;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Jacob.BookClub.models.Book;

@Repository
//creats a find all method for books
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();

	
	
	List<Book> findByTitleContaining(String title);
	
	

}
