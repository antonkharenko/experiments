package com.springinaction.spitter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springinaction.spitter.persistence.Spitter;
import com.springinaction.spitter.persistence.dao.SpitterDAO;

public class SpitterTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/springinaction/spitter/spitter.xml");
		SpitterDAO spitterDao = (SpitterDAO) ctx.getBean("spitterDao");
		
		//spitterDao.addSpitter(new Spitter("abot", "umbrella", "Anton Kharenko"));
		
		Spitter firstSpitter = spitterDao.getSpitterById(1);
		System.out.println(firstSpitter);
	}
}
