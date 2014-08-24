package com.idodevjobs.example;

import ch.lambdaj.function.closure.Switcher;

public class StrategyPatternGoogleGuavaSwitcherExample {

    private Gender gender;
    private String message;
    private Switcher<GenerateGreetingStrategy> generateGreetingStrategySwitcher;

    public StrategyPatternGoogleGuavaSwitcherExample (Gender gender, String message) {
        this.gender = gender;
        this.message = message;

        generateGreetingStrategySwitcher = new Switcher<>();
        generateGreetingStrategySwitcher.addCase(Gender.MALE, new GenerateGreetingForMen());
        generateGreetingStrategySwitcher.addCase(Gender.FEMALE, new GenerateGreetingForWomen());
        generateGreetingStrategySwitcher.setDefault(new GenerateGreetingForWomen());
    }

    public static void main(String args[]) {
        StrategyPatternGoogleGuavaSwitcherExample strategyPatternGoogleGuavaSwitcherExample1 = new StrategyPatternGoogleGuavaSwitcherExample(Gender.MALE, "Jack, Good morning !!");
        StrategyPatternGoogleGuavaSwitcherExample StrategyPatternGoogleGuavaSwitcherExample2 = new StrategyPatternGoogleGuavaSwitcherExample(Gender.FEMALE, "Laura, Good afternoon !!");
        System.out.println(strategyPatternGoogleGuavaSwitcherExample1.generateGreeting());
        System.out.println(StrategyPatternGoogleGuavaSwitcherExample2.generateGreeting());
    }

    private String generateGreeting() {
        return generateGreetingStrategySwitcher.exec(gender).generateGreeting(message);
    }
}

enum Gender {
    MALE, FEMALE
}
