package com.bookstore.service;


import java.util.List;


import com.bookstore.domain.Books;

public interface BookService {
	List<Books> findAll ();
	
	Books getOne(Long id);
}
