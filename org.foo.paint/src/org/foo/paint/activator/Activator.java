package org.foo.paint.activator;

import org.foo.paint.PaintFrame;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		PaintFrame.main(new String[] {});
	}

	@Override
	public void stop(BundleContext context) throws Exception {
	}

}
