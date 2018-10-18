package com.magela.Spring5WebApp.repositories;

import com.magela.Spring5WebApp.model.Author;
import org.springframework.data.repository.CrudRepository;


public interface AuthorRepository extends CrudRepository<Author, Long> {

}
