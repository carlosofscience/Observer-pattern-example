package observer_pattern;

public class SubscriberOdds extends AbstractEventDrivenSubscriber{

	SubscriberOdds(AbstractEventPublisher publisher) {
		super(publisher);
		threshold = 21;
	}
	
	@Override 
	public boolean update() {
		boolean result = false;

		//gets updated by publisher
		int data = publisher.state.getEventDataValue();
		
		if(data % 2 != 0) {
			eventsReceived++;
			if(eventsReceived <= threshold) {
				System.out.printf("SubscriberOdds: Event is odd: %d\n", data);
				result = true;
			}
			
			if(eventsReceived == threshold) {
				publisher.unregisterSubscriber(this);
			}
			
		}
		return result;

	}

}
