package org.hibernate.auction;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.auction.model.Address;
import org.hibernate.auction.model.Bid;
import org.hibernate.auction.model.Category;
import org.hibernate.auction.model.Group;
import org.hibernate.auction.model.Item;
import org.hibernate.auction.model.Participiant;
import org.hibernate.auction.model.User;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Expression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBusinessKeyPerformance {
	private final static Logger logger = LoggerFactory
			.getLogger(AuctionTest.class);

	private static SessionFactory sessionFactory;
	private static String groupName = "Focus group";
	private static String[] participiantNames = { "Kert", "Rando", "Fillip",
			"Kiril", "Aleksandr", "Ivan", "Computers" };
	private static Long groupId;
	private static String newParticipiantName = "Anton";

	public static void main(String[] args) {
		initializeSessionFactory();
		clearDatabase();
		fillDatabase();
		addParticipiant();
	}

	private static void initializeSessionFactory() {
		print("Initializing session factory...");
		sessionFactory = new Configuration().configure(
				"/hibernate_auction.cfg.xml").buildSessionFactory();
	}

	private static void clearDatabase() {
		print("Clearing database...");
		Session session = sessionFactory.openSession();
		Transaction newTx = session.beginTransaction();
		List<Group> groups = session.createQuery("from Group").list();
		for (Group group : groups) {
			session.delete(group);
		}
		newTx.commit();
		session.close();
	}

	private static void fillDatabase() {
		print("Fill database...");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Group group = new Group();
		group.setName(groupName);
		for (String participiantName : participiantNames) {
			Participiant participiant = new Participiant();
			participiant.setName(participiantName);
			group.addParticipiants(participiant);
		}
		session.save(group);
		tx.commit();
		session.close();
		
		groupId = group.getId();
	}
	
	private static void addParticipiant() {
		print("Add participiant...");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Participiant participiant = new Participiant();
		participiant.setName(newParticipiantName);
		
		Group group = (Group) session.get(Group.class, groupId);
		group.addParticipiants(participiant);
		
		session.save(group);
		tx.commit();
		session.close();
	}

	private static void print(Object o) {
		System.out.println(o);
	}

	/*
	 * private static void testQueries() { Session session =
	 * sessionFactory.openSession(); Transaction tx =
	 * session.beginTransaction(); Iterator items =
	 * session.createCriteria(Item.class) .createAlias("bids", "bid") .add(
	 * Expression.like("this.description", "%gc%") ) .add(
	 * Expression.gt("bid.amount", new Long("100") ) ) .list().iterator(); while
	 * ( items.hasNext() ) { Item item = (Item) items.next(); print(item); }
	 * tx.commit(); session.close(); }
	 * 
	 * private static void addCategoryToTree() { Session session =
	 * sessionFactory.openSession(); Transaction tx =
	 * session.beginTransaction(); Category computer = (Category)
	 * session.get(Category.class, new Long(3));
	 * Hibernate.initialize(computer.getChildCategories()); tx.commit();
	 * session.close();
	 * 
	 * Category laptops = new Category("Laptops 4"); Category laptopAccessories
	 * = new Category("Laptop Accessories"); Category laptopTabletPCs = new
	 * Category("Tablet PCs"); laptops.addChildCategory(laptopAccessories);
	 * laptops.addChildCategory(laptopTabletPCs);
	 * computer.addChildCategory(laptops);
	 * 
	 * session = sessionFactory.openSession(); tx = session.beginTransaction();
	 * // Persist one new category and the link to its parent category
	 * session.save(laptops); tx.commit(); session.close(); }
	 * 
	 * private static void testItemsAndBids() {
	 * logger.info("Testing item and bids..."); Session session =
	 * sessionFactory.openSession(); Transaction newTx =
	 * session.beginTransaction(); Item item = null; item = (Item)
	 * session.get(Item.class, 1L); if (item != null) { logger.info("Item: " +
	 * item.getName() + " " + item.getDescription()); long maxBid =
	 * Long.MIN_VALUE; for (Object bidObj : item.getBids()) { Bid bid = (Bid)
	 * bidObj; logger.info("Bid " + bid.getId() + ": " + bid.getAmount()); if
	 * (bid.getAmount() > maxBid) { maxBid = bid.getAmount(); } }
	 * item.addBid(new Bid(maxBid + 500L)); session.delete(item); }
	 * newTx.commit(); session.close(); }
	 * 
	 * private static void createUser() { Session session =
	 * sessionFactory.openSession(); Transaction newTx =
	 * session.beginTransaction(); List<?> categories =
	 * session.createQuery("from User").list(); if (categories.size() == 0) {
	 * logger.info("Creating user..."); User me = new User("Anton Kharenko");
	 * Address myAddress = new Address("Entuziastov 13, ap. 34", "Kiev",
	 * "02154"); me.setHomeAddress(myAddress); me.setBillingAddress(myAddress);
	 * session.save(me); } newTx.commit(); session.close(); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * private static void createCategories() {
	 * logger.info("Creating categories..."); Session session =
	 * sessionFactory.openSession(); Transaction tx =
	 * session.beginTransaction(); for (int categoryIndex = 0; categoryIndex <
	 * categoryNames.length; categoryIndex++) { Category category = new
	 * Category(categoryNames[categoryIndex]); category.setId((long)
	 * categoryIndex); session.save(category); } tx.commit(); session.close(); }
	 * 
	 * private static void printCategories() {
	 * logger.info("Printing categories..."); Session session =
	 * sessionFactory.openSession(); Transaction newTx =
	 * session.beginTransaction(); List<?> categories =
	 * session.createQuery("from Category").list(); for (Object category :
	 * categories) { System.out.println(((Category) category).getName()); }
	 * newTx.commit(); session.close(); }
	 * 
	 * private static void updateCategory() {
	 * logger.info("Updating category..."); Session session =
	 * sessionFactory.openSession(); Transaction newTx =
	 * session.beginTransaction(); List<?> categories = session.createQuery(
	 * "from Category where name='Toys'").list(); for (Object category :
	 * categories) { ((Category) category).setName("Toys & Games");
	 * session.update(category); } newTx.commit(); session.close(); }
	 */
}
