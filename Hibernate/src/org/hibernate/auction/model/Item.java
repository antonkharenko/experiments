package org.hibernate.auction.model;

import java.util.HashSet;
import java.util.Set;

public class Item {
	private Long id;
	private String name;
	private String description;
	private Long initialPrice;

	private Set bids = new HashSet();

	public Item() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(Long initialPrice) {
		this.initialPrice = initialPrice;
	}

	public void setBids(Set bids) {
		this.bids = bids;
	}

	public Set getBids() {
		return bids;
	}

	public void addBid(Bid bid) {
		bid.setItem(this);
		bids.add(bid);
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description="
				+ description + ", initialPrice=" + initialPrice + "]";
	}
}
