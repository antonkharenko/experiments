package guava;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class GuavaTest {
	
	private static Multimap<String, String> multimap = HashMultimap.create();
	
	public static void main(String[] args) {
		System.out.println("Guava Multimap: " + multimap);
		multimap.put("key1", "value1");
		multimap.put("key1", "value2");
		multimap.put("key2", "value3");
		System.out.println("Guava Multimap: " + multimap);
	}
}
