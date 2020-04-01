package com.administratorportal.service;

import java.util.List;

import com.administratorportal.domain.Books;

public interface BooksService {

	Books save(Books books);
	
	List<Books> findAll();

	Books getOne(Long id);
}
