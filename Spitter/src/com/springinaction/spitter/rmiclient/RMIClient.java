package com.springinaction.spitter.rmiclient;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springinaction.spitter.persistence.Spittle;
import com.springinaction.spitter.services.SpitterService;

public class RMIClient {
	public static void main(String args[]) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("rmi-client.xml");
		
		SpitterService spitterService = (SpitterService) ctx.getBean("spitterService");
		
		List<Spittle> recentSpittles = spitterService.getRecentSpittles(10);
		for (Spittle spittle : recentSpittles) {
			System.out.println(spittle);
		}
	}
}
