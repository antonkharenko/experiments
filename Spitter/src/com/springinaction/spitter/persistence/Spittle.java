package com.springinaction.spitter.persistence;

import java.sql.Timestamp;

public class Spittle {
	private Long id;
	private Spitter spitter;
	private String text;
	private Timestamp when;
	
	public Spittle() {
	}
	
	public Spittle(Spitter spitter, String text, Timestamp when) {
		this.spitter = spitter;
		this.text = text;
		this.when = when;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Spitter getSpitter() {
		return spitter;
	}

	public void setSpitter(Spitter spitter) {
		this.spitter = spitter;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getWhen() {
		return when;
	}

	public void setWhen(Timestamp when) {
		this.when = when;
	}

	@Override
	public String toString() {
		return "Spittle [id=" + id + ", spitter=" + spitter + ", text=" + text
				+ ", when=" + when + "]";
	}
}
