package de.vogella.datastructures.map;


import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyMapTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testStandardMap() {
		// Standard Map
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Lars", 1);
		map.put("Lars", 2);
		map.put("Lars", 1);
		Assert.assertEquals((int)map.get("Lars"), 1);

		for (int i = 0; i < 100; i++) {
			map.put(String.valueOf(i), i);
		}
		Assert.assertEquals(map.size(), 101);

		Assert.assertEquals((int)map.get("51"), 51);
		map.keySet();
	}

	@Test
	public void testMapMap() {

		// MyMap
		MyMap<String, Integer> map = new MyMap<String, Integer>();
		map.put("Lars", 1);
		map.put("Lars", 2);
		map.put("Lars", 1);
		Assert.assertEquals((int)map.get("Lars"), 1);
		for (int i = 0; i < 100; i++) {
			map.put(String.valueOf(i), i);
		}
		Assert.assertEquals((int)map.size(), 101);
		Assert.assertEquals((int)map.get("51"), 51);

	}
}