package junit.tests.extensions;

import junit.framework.*;
import junit.extensions.*;
import junit.tests.WasRun;

/**
 * A test case testing the extensions to the testing framework.
 *
 */
public class ExtensionTest extends TestCaseRef {
	static class TornDown extends TestSetup { 
		boolean fTornDown= false;
		
		TornDown(Test test) {
			super(test);
		}
		protected void tearDown() {
			fTornDown= true;
		}
	}
	public void testRunningErrorInTestSetup() {
		TestCaseRef test= new TestCaseRef("failure") {
			public void runTest() {
				fail();
			}
		};

		TestSetup wrapper= new TestSetup(test);

		TestResult result= new TestResult();
		wrapper.run(result);
		assertTrue(!result.wasSuccessful());
	}
	public void testRunningErrorsInTestSetup() {
		TestCaseRef failure= new TestCaseRef("failure") {
			public void runTest() {
				fail();
			}
		};

		TestCaseRef error= new TestCaseRef("error") {
			public void runTest() {
				throw new Error();
			}
		};

		TestSuite suite= new TestSuite();
		suite.addTest(failure);
		suite.addTest(error);
		
		TestSetup wrapper= new TestSetup(suite);

		TestResult result= new TestResult();
		wrapper.run(result);

		assertEquals(1, result.failureCount());
		assertEquals(1, result.errorCount());
	}
	public void testSetupErrorDontTearDown() {
		WasRun test= new WasRun();

		TornDown wrapper= new TornDown(test) {
			public void setUp() {
				fail();
			}
		};

		TestResult result= new TestResult();
		wrapper.run(result);

		assertTrue(!wrapper.fTornDown);
	}
	public void testSetupErrorInTestSetup() {
		WasRun test= new WasRun();

		TestSetup wrapper= new TestSetup(test) {
			public void setUp() {
				fail();
			}
		};

		TestResult result= new TestResult();
		wrapper.run(result);

		assertTrue(!test.fWasRun);
		assertTrue(!result.wasSuccessful());
	}
}