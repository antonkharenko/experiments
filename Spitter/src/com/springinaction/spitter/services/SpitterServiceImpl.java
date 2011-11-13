package com.springinaction.spitter.services;

import java.util.List;

import com.springinaction.spitter.persistence.Spitter;
import com.springinaction.spitter.persistence.Spittle;
import com.springinaction.spitter.persistence.dao.SpitterDao;
import com.springinaction.spitter.persistence.dao.SpittleDao;

public class SpitterServiceImpl implements SpitterService {
	
	private SpitterDao spitterDao;
	private SpittleDao spittleDao;
	
	public void setSpitterDao(SpitterDao spitterDao) {
		this.spitterDao = spitterDao;
	}
	
	public void setSpittleDao(SpittleDao spittleDao) {
		this.spittleDao = spittleDao;
	}

	@Override
	public void saveSpitter(Spitter spitter){
		spitterDao.saveSpitter(spitter);
	}
	
	@Override
	public Spitter getSpitterById(long id) {
		return spitterDao.getSpitterById(id);
	}
	
	@Override
	public Spitter getSpitterByName(String username) {
		return spitterDao.getSpitterByName(username);
	}
	
	@Override
	public List<Spittle> getSpittlesForSpitter(String username) {
		return spittleDao.getSpittlesForSpitter(username);
	}
	
	@Override
	public List<Spittle> getRecentSpittles(int maxCount) {
		return spittleDao.getRecentSpittles(maxCount);
	}

	@Override
	public void saveSpittle(Spittle spittle) {
		spittleDao.saveSpittle(spittle);
	}

	@Override
	public void deleteSpittle(long id) {
		spittleDao.deleteSpittle(id);
	}
	
	@Override
	public Spittle getSpittleById(long id) {
		return spittleDao.getSpittleById(id);
	}
	
	@Override
	public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
		return spittleDao.getSpittlesForSpitter(spitter);
	}
}
