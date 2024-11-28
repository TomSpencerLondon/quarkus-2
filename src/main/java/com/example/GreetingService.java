package com.example;


import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public String greeting(String name) {
        return "Welcome to build Serverless Java with Quarkus on Azure Functions, " + name;
    }

}
