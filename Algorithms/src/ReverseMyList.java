
public class ReverseMyList {
	
	public static void main(String[] args) {
		MyList testList = new MyList();
		testList.addToEnd("A");
		testList.addToEnd("B");
		testList.addToEnd("C");
		testList.addToEnd("D");
		System.out.println(testList);
		testList.reverse();
		System.out.println(testList);
	}
	
}
