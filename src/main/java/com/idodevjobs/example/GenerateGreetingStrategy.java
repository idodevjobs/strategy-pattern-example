package com.idodevjobs.example;

public interface GenerateGreetingStrategy {
    public String generateGreeting(String message);
}

class GenerateGreetingForMen implements GenerateGreetingStrategy {
    public String generateGreeting(String message) {
        return "Mr."+message;
    }
}

class GenerateGreetingForWomen implements GenerateGreetingStrategy {
    public String generateGreeting(String message) {
        return "Ms."+message;
    }
}