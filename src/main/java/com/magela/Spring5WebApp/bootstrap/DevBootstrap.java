package com.magela.Spring5WebApp.bootstrap;

import com.magela.Spring5WebApp.model.Author;
import com.magela.Spring5WebApp.model.Book;
import com.magela.Spring5WebApp.model.Publisher;
import com.magela.Spring5WebApp.repositories.AuthorRepository;
import com.magela.Spring5WebApp.repositories.BookRepository;
import com.magela.Spring5WebApp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository,
                        BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher leya = new Publisher("Leya", "Rua Leya 14");

        Author author = new Author("Eric", "Test");
        Book ddd = new Book("DDD", "1234" ,leya);
        author.getBooks().add(ddd);
        ddd.getAuthors().add(author);

        publisherRepository.save(leya);

        authorRepository.save(author);
        bookRepository.save(ddd);

        Author author1 = new Author("Edu", "Sphor");
        Book apocalipse = new Book("Batalha do Apocalipse", "1111", leya);
        author1.getBooks().add(apocalipse);

        authorRepository.save(author1);
        bookRepository.save(apocalipse);
    }
}
