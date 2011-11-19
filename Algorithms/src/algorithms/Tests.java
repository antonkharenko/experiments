package algorithms;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Tests {
	
	@Test
	public void testQuickSort() {
		int[] testArray = { 12, 7, 25, 3, 6, 58, 2, 10, 1, 5, 1, 7 };
		QuickSort.sort(testArray);
		
		int[] resultArray = Arrays.copyOf(testArray, testArray.length);
		Arrays.sort(resultArray);
		
		Assert.assertArrayEquals(resultArray, testArray);
	}
	
	@Test
	public void testMyLinkedListReverse() {
		MyLinkedList testList = new MyLinkedList();
		testList.addToHead("A");
		testList.addToHead("B");
		testList.addToHead("C");
		testList.addToHead("D");
		testList.addToHead("E");
		
		System.out.println("Source list: " + testList);
		testList.reverse();
		System.out.println("Reversed list: " + testList);
	}
}
