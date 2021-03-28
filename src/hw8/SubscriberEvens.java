package hw8;

public class SubscriberEvens extends AbstractEventDrivenSubscriber{

	SubscriberEvens(AbstractEventPublisher publisher) {
		super(publisher);
		threshold = 14;
	}
	
	@Override 
	public boolean update() {
		
		boolean result = false;
		
		//gets updated by publisher
		int data = publisher.state.getEventDataValue();
		
		if(data % 2 == 0) {
			eventsReceived++;
			if(eventsReceived <= threshold) {
				System.out.printf("SubscriberEvens: Event is even: %d\n", data);
				result = true;
			}
			
			if(eventsReceived == threshold) {
				publisher.unregisterSubscriber(this);
			}
			
		}
		
		return result;
		
	}

}

