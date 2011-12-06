package concurrency.in.practice.memoizer;

import java.math.BigInteger;

public class ExpensiveFunction implements Computable<String, BigInteger> {

	@Override
	public BigInteger compute(String arg) throws InterruptedException {
		// After deep thoughts
		Thread.sleep(1000);
		return new BigInteger(arg);
	}

}
