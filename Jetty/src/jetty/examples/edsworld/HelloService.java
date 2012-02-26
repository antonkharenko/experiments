package jetty.examples.edsworld;

import java.util.Map;
import java.util.HashMap;

import org.cometd.bayeux.Message;
import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.ServerSession;
import org.cometd.server.AbstractService;

public class HelloService extends AbstractService
{
    public HelloService(BayeuxServer bayeux)
    {
        super(bayeux, "hello");
        addService("/service/hello", "processHello");
        System.out.println("New HelloService");
    }

    public void processHello(final ServerSession remote, Message message)
    {
        Map input = message.getDataAsMap();
        String name = (String)input.get("name");
        Map output = new HashMap();
        output.put("greeting", "Hello, " + name);
        remote.deliver(getServerSession(), "/hello", output, null);

        Thread t = new Thread(){
        	int count = 0;
			@Override
			public void run() {
				while (true) {
					remote.deliver(getServerSession(), "/reply", count + "", null);
					System.out.println(count);
					count++;
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

        };
        t.start();
    }
}
