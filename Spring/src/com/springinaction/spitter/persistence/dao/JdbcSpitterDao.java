package com.springinaction.spitter.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.springinaction.spitter.persistence.Spitter;

public class JdbcSpitterDao extends SimpleJdbcDaoSupport implements SpitterDao {
	private static final String SQL_INSERT_SPITTER = 
			"insert into spitter (username, password, fullname) values (:username, :password, :fullname)";
	
	private static final String SQL_SELECT_SPITTER_BY_ID =
			"select spitter_id, username, password, fullname from spitter where spitter_id = ?";
	
	/*
	private static final String SQL_UPDATE_SPITTER = 
			"update spitter set username = ?, password = ?, fullname = ? where spitter_id = ?";
	*/
	
	public JdbcSpitterDao() {
	}

	public void addSpitter(Spitter spitter) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username",spitter.getUsername());
		params.put("password",spitter.getPassword());
		params.put("fullname",spitter.getFullName());
		
		getSimpleJdbcTemplate().update(SQL_INSERT_SPITTER,params);

		//TODO how to query last inserted id
		//spitter.setId(queryForIdentity());
	}
	
	public Spitter getSpitterById(long id) {
		return getSimpleJdbcTemplate().queryForObject(SQL_SELECT_SPITTER_BY_ID,
				new RowMapper<Spitter>() {
					public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
						Spitter spitter=new Spitter();
						spitter.setId(rs.getLong(1));
						spitter.setUsername(rs.getString(2));
						spitter.setPassword(rs.getString(3));
						spitter.setFullName(rs.getString(4));
						return spitter;
					}
				},
				id
			);
	}
	
	
	public void saveSpitter(Spitter spitter) {
		//TODO implement
	}
}
