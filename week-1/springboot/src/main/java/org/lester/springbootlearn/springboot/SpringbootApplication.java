package org.lester.springbootlearn.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {

    @Qualifier("apple")
    @Autowired
    Apple apple1;

    @Qualifier("apple")
    @Autowired
    Apple apple2;

    @Autowired
    DBService dbService;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("Hello Spring Boot!");
//        apple1.eatApple();
//        apple2.eatApple();
//        System.exit(0);
        System.out.println(dbService.getData());
    }
}
