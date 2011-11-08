package com.springinaction.spitter.persistence.dao;

import java.util.List;

import org.hibernate.Query;

class HibernateUtils {
	@SuppressWarnings("unchecked")
	public static <T> List<T> listAndCast(Query query) {
	    return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T uniqueResultAndCast(Query query) {
	    return (T) query.uniqueResult();
	}
}
