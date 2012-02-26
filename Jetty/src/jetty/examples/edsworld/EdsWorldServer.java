package jetty.examples.edsworld;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class EdsWorldServer {
	public static void main(String[] args) throws Exception {
        Server server = new Server(8081);
        
        WebAppContext context = new WebAppContext();
        context.setDescriptor("./webapp4edsworld/WEB-INF/web.xml");
        context.setResourceBase("./webapp4edsworld");
        context.setContextPath("/");
        context.setParentLoaderPriority(true);
 
        server.setHandler(context);
        
        server.start();
        server.join();
    }
}
