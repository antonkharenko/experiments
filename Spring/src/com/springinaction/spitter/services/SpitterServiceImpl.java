package com.springinaction.spitter.services;

import com.springinaction.spitter.persistence.Spitter;
import com.springinaction.spitter.persistence.dao.SpitterDao;

public class SpitterServiceImpl implements SpitterService {
	private SpitterDao spitterDao;
	
	public void setSpitterDao(SpitterDao spitterDao) {
		this.spitterDao = spitterDao;
	}

	public void addSpitter(Spitter spitter){
		spitterDao.addSpitter(spitter);
	}
	
	public Spitter getSpitterById(long id) {
		return spitterDao.getSpitterById(id);
	}
}
