package org.hibernate.auction.model;

import java.util.HashSet;
import java.util.Set;

public class Group extends Entity {
	private String name;
	private Set<Participiant> participiants = new HashSet<Participiant>(); 

	public Group() {
		super();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Set<Participiant> getParticipiants_() {
		return participiants;
	}

	private void setParticipiants_(Set<Participiant> participiants_) {
		this.participiants = participiants_;
	}

	public Set<Participiant> getParticipiants() {
		return getParticipiants_();
	}

	public void setParticipiants(Set<Participiant> participiants) {
		setParticipiants_(participiants);
		if (participiants != null) {
			for (Participiant participiant : participiants) {
				participiant.setGroup(this);
			}
		}
	}
	
	public void addParticipiants(Participiant participiant) {
		getParticipiants_().add(participiant);
		participiant.setGroup(this);
	}
}
