package com.springinaction.spitter.persistence.dao;

import com.springinaction.spitter.persistence.Spitter;

public interface SpitterDao {
	
	public Spitter getSpitterById(long id);
	
	public void saveSpitter(Spitter spitter);
	
	public Spitter getSpitterByName(String username);
}
