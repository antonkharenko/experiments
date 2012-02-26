package jetty.examples.edsworld;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.ServerChannel;
import org.cometd.bayeux.server.ServerMessage;
import org.cometd.bayeux.server.ServerSession;
import org.cometd.server.DefaultSecurityPolicy;

public class BayeuxInitialiser extends GenericServlet
{
	private static final long serialVersionUID = -9089442901563633963L;

	public void init() throws ServletException
    {
        BayeuxServer bayeux = (BayeuxServer)getServletContext().getAttribute(BayeuxServer.ATTRIBUTE);
        bayeux.setSecurityPolicy(new DefaultSecurityPolicy(){

			@Override
			public boolean canCreate(BayeuxServer server,
					ServerSession session, String channelId,
					ServerMessage message) {
				return true;
			}

			@Override
			public boolean canHandshake(BayeuxServer server,
					ServerSession session, ServerMessage message) {
				return true;
			}

			@Override
			public boolean canPublish(BayeuxServer server,
					ServerSession session, ServerChannel channel,
					ServerMessage message) {
				return true;
			}

			@Override
			public boolean canSubscribe(BayeuxServer server,
					ServerSession session, ServerChannel channel,
					ServerMessage message) {
				return true;
			}

        });
        new HelloService(bayeux);
    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
    {
        throw new ServletException();
    }
}