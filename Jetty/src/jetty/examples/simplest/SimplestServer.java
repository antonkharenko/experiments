package jetty.examples.simplest;

import org.eclipse.jetty.server.Server;

public class SimplestServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(new HelloWorldHandler());
        server.start();
        server.join();
    }
}
