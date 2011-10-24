package junit.tests.framework;

/**
 * Test class used in SuiteTest
 */
import junit.framework.TestCaseRef;

public class NotPublicTestCase extends TestCaseRef {
	protected void testNotPublic() {
	}
	public void testPublic() {
	}
}