package osgi_tutorial;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class HelloWorldActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Hello, World!");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Goodbye, World!");
	}

}
