package com.idodevjobs.example;

import ch.lambdaj.function.closure.Switcher;

public class StrategyPatternLambdajSwitcherExample {

    private Gender gender;
    private String message;
    private Switcher<GenerateGreetingStrategy> generateGreetingStrategySwitcher;

    public StrategyPatternLambdajSwitcherExample(Gender gender, String message) {
        this.gender = gender;
        this.message = message;

        generateGreetingStrategySwitcher = new Switcher<>();
        generateGreetingStrategySwitcher.addCase(Gender.MALE, new GenerateGreetingForMen());
        generateGreetingStrategySwitcher.addCase(Gender.FEMALE, new GenerateGreetingForWomen());
        generateGreetingStrategySwitcher.setDefault(new GenerateGreetingForWomen());
    }

    public static void main(String args[]) {
        StrategyPatternLambdajSwitcherExample strategyPatternLambdajSwitcherExample1 = new StrategyPatternLambdajSwitcherExample(Gender.MALE, "Jack, Good morning !!");
        StrategyPatternLambdajSwitcherExample strategyPatternLambdajSwitcherExample2 = new StrategyPatternLambdajSwitcherExample(Gender.FEMALE, "Laura, Good afternoon !!");
        System.out.println(strategyPatternLambdajSwitcherExample1.generateGreeting());
        System.out.println(strategyPatternLambdajSwitcherExample2.generateGreeting());
    }

    private String generateGreeting() {
        return generateGreetingStrategySwitcher.exec(gender).generateGreeting(message);
    }
}

enum Gender {
    MALE, FEMALE
}
