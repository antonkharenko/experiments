package org.hibernate.auction.model;

public class Bid {
	private Long id;
	private Item item;
	private Long amount;
	
	public Bid() {}
	
	public Bid(Long amount) {
		this.amount = amount;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Bid [id=" + id + ", item=" + item + ", amount=" + amount + "]";
	}
}
