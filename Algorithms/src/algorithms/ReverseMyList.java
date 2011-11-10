package algorithms;

public class ReverseMyList {
	
	public static void main(String[] args) {
		MyLinkedList testList = new MyLinkedList();
		testList.addToHead("A");
		testList.addToHead("B");
		testList.addToHead("C");
		testList.addToHead("D");
		System.out.println(testList);
		testList.reverse();
		System.out.println(testList);
	}
	
}
