package com.administratorportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.administratorportal.domain.Books;

public interface BooksRepository extends JpaRepository<Books, Long> {

}
