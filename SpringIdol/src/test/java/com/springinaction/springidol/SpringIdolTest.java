package com.springinaction.springidol;

import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIdolTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol.xml");
		
		String[] performers = {"duke", "poeticDuke", "kenny", "hank"};
		
		System.out.println("Performance started...");
		for (int performerIndex = 0; performerIndex < performers.length; performerIndex++) {
			println();
			println("Performer #" + performerIndex + ": " + performers[performerIndex]);
			Performer performer = (Performer) ctx.getBean(performers[performerIndex]);
			performer.perform();
		}
		
		println();
		println("Magician performance:");
		Magician magician = (Magician) ctx.getBean("merlin");
		Thinker volunteer = (Thinker) ctx.getBean("johnDoe");
		volunteer.thinkOfSomething("queen of heart");
		println("Magician said that volunteer's thoughts was: " + magician.getThoughts());
		println("Volunteer said that his thoughts was: " + volunteer.getThoughts());
		
		println();
		println("Choose a winner:");
		int winnerIndex = new Random().nextInt(performers.length);
		println("The winner is " + performers[winnerIndex]);
		Contestant winner = (Contestant) ctx.getBean(performers[winnerIndex]);
		println("Winners speach: ");
		winner.receiveAward(); 
	}
	
	private static void println() {
		System.out.println();
	}
	
	private static void println(String msg) {
		System.out.println(msg);
	}
}
