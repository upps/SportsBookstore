package com.bookstore.repository;

import com.bookstore.domain.Books;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Books, Long>{

}
