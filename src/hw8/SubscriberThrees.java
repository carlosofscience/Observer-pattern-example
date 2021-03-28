package hw8;

public class SubscriberThrees extends AbstractEventDrivenSubscriber{

	SubscriberThrees(AbstractEventPublisher publisher) {
		super(publisher);
		threshold = 14;
	}
	
	@Override 
	public boolean update() {
		boolean result = false;
		//gets updated by publisher
		int data = publisher.state.getEventDataValue();
		
		if(data % 3 == 0) {
			eventsReceived++;
			if(eventsReceived <= threshold) {
				System.out.printf("SubscriberThrees: Event is divisble 3: %d\n", data);
				result = true;
			}
			
			if(eventsReceived == threshold) {
				publisher.unregisterSubscriber(this);
			}
			
		}
		
		return result;
		
	}

}

