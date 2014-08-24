package com.idodevjobs.example;

import java.util.HashMap;
import java.util.Map;

public class StrategyPatternExample {
	
	private Map<String, GenerateGreetingStrategy> strategyMap;
	private String gender;
	private String message;
	
	public StrategyPatternExample()  {
		strategyMap = new HashMap<>();
		strategyMap.put("Men", new GenerateGreetingForMen());
		strategyMap.put("Women", new GenerateGreetingForWomen());
	}
	
	public StrategyPatternExample(String gender, String message) {
		this();
		this.gender = gender;
		this.message = message;
	}
	
	public static void main(String[] args) {
		StrategyPatternExample strategyPatternExample1 = new StrategyPatternExample("Men", "Jack, Good morning !!");
		StrategyPatternExample strategyPatternExample2 = new StrategyPatternExample("Women", "Laura, Good afternoon !!");
		System.out.println(strategyPatternExample1.generateGreetingUsingSwitchCase());
		System.out.println(strategyPatternExample2.generateGreetingUsingSwitchCase());
		System.out.println(strategyPatternExample1.generateGreetingUsingStrategy());
		System.out.println(strategyPatternExample2.generateGreetingUsingStrategy());
	}
	
	private String generateGreetingUsingSwitchCase() {
		switch (gender) {
			case "Men":
				return "Mr."+message;
			case "Women":
				return "Ms."+message;
			default:
				return message;
		}
	}
	
	private String generateGreetingUsingStrategy() {
		return strategyMap.get(gender).generateGreeting(message);
	}
}
