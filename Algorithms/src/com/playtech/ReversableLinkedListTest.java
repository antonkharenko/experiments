package com.playtech;

import org.junit.Test;

public class ReversableLinkedListTest {
	
	@Test
	public void testListReverse() {
		ReversableLinkedList testList = new ReversableLinkedList();
		testList.add("A");
		testList.add("B");
		testList.add("C");
		testList.add("D");
		testList.add("E");
		
		System.out.println("Source list: " + testList);
		testList.reverse();
		System.out.println("Reversed list: " + testList);
	}
	
	
}
