package junit.tests.runner;

import junit.framework.TestCaseRef;
import junit.runner.SimpleTestCollector;

public class SimpleTestCollectorTest extends TestCaseRef {
	
	public void testMissingDirectory() {
		SimpleTestCollector collector= new SimpleTestCollector();
		assertFalse(collector.collectFilesInPath("foobar").elements().hasMoreElements());
	}

}

