package concurrency.in.practice.factorizer;

import java.math.BigInteger;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import concurrency.in.practice.annotations.GuardedBy;
import concurrency.in.practice.annotations.ThreadSafe;

@ThreadSafe
public class CachedFactorizer implements Servlet {
    @GuardedBy("this") private BigInteger lastNumber;
    @GuardedBy("this") private BigInteger[] lastFactors;
    @GuardedBy("this") private long hits;
    @GuardedBy("this") private long cacheHits;

    public synchronized long getHits() { return hits; }
    public synchronized double getCacheHitRatio() {
        return (double) cacheHits / (double) hits;
    }

    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = null;
        synchronized (this) {
            ++hits;
            if (i.equals(lastNumber)) {
                ++cacheHits;
                factors = lastFactors.clone();
            }
        }
        if (factors == null) {
            factors = factor(i);
            synchronized (this)  {
                lastNumber = i;
                lastFactors = factors.clone();
            }
        }
        encodeIntoResponse(resp, factors);
    }
	private BigInteger[] factor(BigInteger i) {
		// TODO Auto-generated method stub
		return null;
	}
	private BigInteger extractFromRequest(ServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}
	private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
