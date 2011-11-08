package com.springinaction.spitter;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springinaction.spitter.persistence.Spitter;
import com.springinaction.spitter.persistence.Spittle;
import com.springinaction.spitter.services.SpitterService;

public class SpitterServiceTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spitter.xml");
		SpitterService spitterService = (SpitterService) ctx.getBean("spitterService");
		//insertTestData(spitterService);		
		
		Spitter firstSpitter = spitterService.getSpitterById(1);
		System.out.println("First spitter: " + firstSpitter);
		
		Spitter abotSpitter = spitterService.getSpitterByName("abot");
		System.out.println("Abot spitter: " + abotSpitter);
		
		List<Spittle> abotSpittles = spitterService.getSpittlesForSpitter("abot");
		System.out.println("Abot's spittles:");
		for (Spittle spittle : abotSpittles) {
			System.out.println(spittle.getText());
		}
	}
	
	private static void insertTestData(SpitterService spitterService) {
		Spitter testSpitter1 = new Spitter("abot", "password1", "Anton Kharenko");
		Spitter testSpitter2 = new Spitter("mosya", "password2", "Victoria");
		spitterService.saveSpitter(testSpitter1);
		spitterService.saveSpitter(testSpitter2);
		Spittle testSpittle1 = new Spittle(testSpitter1, "Today is the day!", new Timestamp(111, 9, 8, 8, 30, 00, 00));
		Spittle testSpittle2 = new Spittle(testSpitter2, "I want some sweets :(", new Timestamp(111, 9, 8, 19, 05, 00, 00));
		Spittle testSpittle3 = new Spittle(testSpitter1, "I will visit Austria this winter", new Timestamp(111, 9, 8, 19, 30, 00, 00));
		spitterService.saveSpittle(testSpittle1);
		spitterService.saveSpittle(testSpittle2);
		spitterService.saveSpittle(testSpittle3);
	}
}
