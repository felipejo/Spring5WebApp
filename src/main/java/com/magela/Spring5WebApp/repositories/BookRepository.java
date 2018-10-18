package com.magela.Spring5WebApp.repositories;

import com.magela.Spring5WebApp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
