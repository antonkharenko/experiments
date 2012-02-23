package jetty.examples.webapp;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebAppServer {
	public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        
        /*
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setWar("./war/dojo-jetty7-primer.war");
        server.setHandler(webapp);
        */
        
        WebAppContext context = new WebAppContext();
        context.setDescriptor("./webapp/WEB-INF/web.xml");
        context.setResourceBase("./webapp");
        context.setContextPath("/");
        context.setParentLoaderPriority(true);
 
        server.setHandler(context);
        
        server.start();
        server.join();
    }
}
