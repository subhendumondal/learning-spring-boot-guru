package com.guru.jpa.repository;

import com.guru.jpa.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends CrudRepository<Author, Long> {
}
