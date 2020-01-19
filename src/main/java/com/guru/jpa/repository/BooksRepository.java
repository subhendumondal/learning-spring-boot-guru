package com.guru.jpa.repository;

import com.guru.jpa.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends CrudRepository<Book, Long> {
}
