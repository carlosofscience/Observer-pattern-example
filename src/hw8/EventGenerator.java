package hw8;

public class EventGenerator extends AbstractEventPublisher{
	
	private static int EUID; //event unique id
	
	EventGenerator(){
		super();
		EUID = 0;
		state = null;
		//creating 10 subscribers of each subscriber variation
		//passing reference to this publisher to each new subscriber
		for (int i=0; i < 30; i++) {
			if(i < 10) {
				subscribers.add(new SubscriberEvens(this));
			}else if (i < 20){
				subscribers.add(new SubscriberOdds(this));
			}else {
				subscribers.add(new SubscriberThrees(this));
			}
		}
	}
	
	public void runSimulation() {
		for (int index=0; index < 200; index++) {
			
			if(index > 0 && index % 40 == 0)
				reRegisterAll();
			
			//sets the current state of the Publisher
			setState(generateEvent());

			//printing 
			System.out.printf("Event #%d -> sequence: %d, data: %d\n", index, state.getEventSequenceNumber(), state.getEventDataValue());

			//notify all subscribers about it
			notifySubscriber();
		}
		
		
	}
	
	private Event generateEvent() {//generates an state (event)
		int min = 0, max = 1000;
		return new Event(EUID++, (int) (Math.random()* (max - min) + min));
	}
	
	private void reRegisterAll() {
		
		//unregistering all subscribers
		for(AbstractEventDrivenSubscriber subscriber: subscribers) {
			unregisterSubscriber(subscriber);
		}		
		System.out.printf("Unregistered %d subscribers\n", subscribers.size());
		
		//registering all subscribers back
		for(AbstractEventDrivenSubscriber subscriber: subscribers) {
			registerSubscriber(subscriber);
		}
		System.out.printf("Registered %d subscribers\n", subscribers.size());

	}

}
