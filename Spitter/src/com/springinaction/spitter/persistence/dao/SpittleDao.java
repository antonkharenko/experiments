package com.springinaction.spitter.persistence.dao;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.springinaction.spitter.persistence.Spittle;

public interface SpittleDao {
	
	@Secured("ROLE_SPITTER")
	public void saveSpittle(Spittle spittle);
	
	public List<Spittle> getSpittlesForSpitter(String username);
	
	public List<Spittle> getRecentSpittles(int maxCount);
}
