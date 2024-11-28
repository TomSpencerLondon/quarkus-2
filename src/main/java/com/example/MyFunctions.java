package com.example;

import io.quarkus.funqy.Funq;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;

public class MyFunctions {

    @Inject
    GreetingService gService;

    @Funq
    public String greeting(String name) {
        return gService.greeting(name);
    }

    @Funq
    public String funqyHello() {

        return "hello funqy";
    }

}
