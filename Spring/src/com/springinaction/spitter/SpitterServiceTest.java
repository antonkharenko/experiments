package com.springinaction.spitter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springinaction.spitter.persistence.Spitter;
import com.springinaction.spitter.services.SpitterService;

public class SpitterServiceTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/springinaction/spitter/spitter.xml");
		
		SpitterService spitterService = (SpitterService) ctx.getBean("spitterService");
		//spitterService.addSpitter(new Spitter("abot", "umbrella", "Anton Kharenko"));
		
		Spitter firstSpitter = spitterService.getSpitterById(1);
		System.out.println("First spitter: " + firstSpitter);
	}
}
