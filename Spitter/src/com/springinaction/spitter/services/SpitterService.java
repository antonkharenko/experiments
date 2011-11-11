package com.springinaction.spitter.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.springinaction.spitter.persistence.Spitter;
import com.springinaction.spitter.persistence.Spittle;

@Transactional
public interface SpitterService {
	
	public void saveSpitter(Spitter spitter);
	
	public Spitter getSpitterById(long id);
	
	public Spitter getSpitterByName(String username);
	
	public void saveSpittle(Spittle spittle);
	
	public List<Spittle> getSpittlesForSpitter(String username);
	
	public List<Spittle> getRecentSpittles(int maxCount);
	
	/*
	//TODO consider adding to Spitter service such methods
	void startFollowing(Spitter follower,Spitter followee);
	List<Spittle> getSpittlesForSpitter(Spitter spitter);
	Spittle getSpittleById(long id);
	void deleteSpittle(long id);
	List<Spitter> getAllSpitters();
	*/
}
