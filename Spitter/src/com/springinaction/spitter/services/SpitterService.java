package com.springinaction.spitter.services;

import org.springframework.transaction.annotation.Transactional;

import com.springinaction.spitter.persistence.Spitter;

@Transactional
public interface SpitterService {
	public void addSpitter(Spitter spitter);
	public Spitter getSpitterById(long id);
}
