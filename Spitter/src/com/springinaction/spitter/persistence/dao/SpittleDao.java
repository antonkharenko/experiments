package com.springinaction.spitter.persistence.dao;

import java.util.List;

import com.springinaction.spitter.persistence.Spittle;

public interface SpittleDao {
	
	public void saveSpittle(Spittle spittle);
	
	public List<Spittle> getSpittlesForSpitter(String username);
	
	public List<Spittle> getRecentSpittles(int maxCount);
}
