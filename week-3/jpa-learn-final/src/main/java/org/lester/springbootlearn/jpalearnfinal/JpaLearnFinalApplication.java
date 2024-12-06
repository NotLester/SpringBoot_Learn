package org.lester.springbootlearn.jpalearnfinal;

import org.lester.springbootlearn.jpalearnfinal.entities.Author;
import org.lester.springbootlearn.jpalearnfinal.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaLearnFinalApplication {
    private final AuthorRepository authorRepository;

    public JpaLearnFinalApplication(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaLearnFinalApplication.class, args);
    }

    public void run(String... args) throws Exception {
        Author author = Author.builder()
                .firstName("Lester")
                .lastName("Lewis")
                .age(21)
                .email("lester@gmail.com")
                .build();

        Author savedAuthor = authorRepository.save(author);
        System.out.println("Saved Author: " + savedAuthor);
    }
}
