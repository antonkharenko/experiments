package junit.tests.framework;

/**
 * Test class used in SuiteTest
 */
import junit.framework.TestCaseRef;

public class NotVoidTestCase extends TestCaseRef {
	public int testNotVoid() {
		return 1;
	}
	public void testVoid() {
	}
}