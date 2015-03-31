package antonkharenko.akka;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import scala.concurrent.duration.Duration;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.RoundRobinRouter;

public class AkkaExample {

	public static void main(String[] args) {
		ActorSystem system = ActorSystem.create("ExampleActorSystem");
		ActorRef greeter = system.actorOf(new Props(GreeterMasterActor.class), "greeter");
		
		List<String> message = Arrays.asList("Anton", "Miroslav", "Vitalii", "Sergey", "Andrey", "Alexey", "Ivan", "Igor", "Katya", "Alex");
		
		//greeter.tell(message, null);
		
		system.scheduler().schedule(
				Duration.Zero(), 
				Duration.create(30, TimeUnit.SECONDS), 
				greeter, 
				message, 
				system.dispatcher());
		
		//system.shutdown();
	}
	
	public static class GreeterMasterActor extends UntypedActor {
		
		private static final Logger LOGGER = LoggerFactory.getLogger(GreeterMasterActor.class);
		
		private ActorRef workerRouter;
		
		private GreeterMasterActor() {
			workerRouter = getContext().actorOf(new Props(GreeterWorkerActor.class)
					.withRouter(new RoundRobinRouter(5)), "workerRouter");
		}

		@Override
		public void onReceive(Object message) throws Exception {
			if (message instanceof List) {
				LOGGER.debug("Received list of names for greeting: {}", message);
				List<String> names = (List<String>) message;
				for (String name : names) {
					workerRouter.tell(new Greeting(name), getSelf());
				}
			}
		}
	}

	public static class GreeterWorkerActor extends UntypedActor {
		
		private static final Logger LOGGER = LoggerFactory.getLogger(GreeterWorkerActor.class);

		public void onReceive(Object message) throws Exception {
			if (message instanceof Greeting) {
				Thread.sleep((long) (Math.random() * 1000)); //sleep for random interval from 0 to 1000 ms
				LOGGER.debug("Hello " + ((Greeting) message).who);
				getSender().tell(new Result(true), getSelf());
			} else {
				getSender().tell(new Result(false), getSelf());
			}
		}
	}
	
	public static class Greeting {
		
		public final String who;

		public Greeting(String who) {
			this.who = who;
		}
	}
	
	public static class Result {
		
		public final boolean done;

		private Result(boolean done) {
			this.done = done;
		}
	}

}
