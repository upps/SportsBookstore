package com.bookstore.service.implementaion;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Books;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.BookService;

@Service
public class BookServiceImplementation implements BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public List<Books> findAll() {
		return (List<Books>) bookRepository.findAll();
	}

	public Books getOne(Long id) {
		return bookRepository.getOne(id);
	}
}
