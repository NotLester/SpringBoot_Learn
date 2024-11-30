package org.lester.springbootlearn.springboot;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Apple {
    void eatApple() {
        System.out.println("Eating apple...");
    }


    @PostConstruct
    void callThisAfterAppleIsCreated() {
        System.out.println("This Apple is created.");
    }

    @PreDestroy
    void callThisBeforeAppleIsDestroyed() {
        System.out.println("This Apple is destroyed.");
    }
}
