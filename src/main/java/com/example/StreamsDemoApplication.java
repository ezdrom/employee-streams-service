package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot application class
 */
@SpringBootApplication
public class StreamsDemoApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(StreamsDemoApplication.class, args);
        System.out.println("🚀 Streams Demo Microservice started!");
        System.out.println("📖 Try these endpoints:");
        System.out.println("   GET http://localhost:8080/api/users/all");
        System.out.println("   GET http://localhost:8080/api/users/active");
        System.out.println("   GET http://localhost:8080/api/users/names");
        System.out.println("   GET http://localhost:8080/api/users/top3-earners");
    }
}