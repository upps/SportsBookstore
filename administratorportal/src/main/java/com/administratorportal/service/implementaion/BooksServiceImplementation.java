package com.administratorportal.service.implementaion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administratorportal.domain.Books;
import com.administratorportal.repository.BooksRepository;
import com.administratorportal.service.BooksService;


@Service
public class BooksServiceImplementation implements BooksService {
	@Autowired
	private BooksRepository booksRepository;
	
	public Books save(Books books) {
		return booksRepository.save(books);
	}
	public List<Books> findAll() {
		return (List<Books>) booksRepository.findAll();
	}
	
	public Books getOne(Long id) {
		return booksRepository.getOne(id);
	}
}
