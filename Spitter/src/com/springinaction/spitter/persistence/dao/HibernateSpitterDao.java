package com.springinaction.spitter.persistence.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springinaction.spitter.persistence.Spitter;

@Repository("spitterDao")
public class HibernateSpitterDao implements SpitterDao {
	private SessionFactory sessionFactory;

	@Autowired
	public HibernateSpitterDao(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addSpitter(Spitter spitter) {
		currentSession().save(spitter);
	}

	public Spitter getSpitterById(long id) {
		return (Spitter) currentSession().get(Spitter.class, id);
	}

	public void saveSpitter(Spitter spitter) {
		currentSession().update(spitter);
	}
}