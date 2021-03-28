package hw8;

public class SubscriberOdds extends AbstractEventDrivenSubscriber{

	SubscriberOdds(AbstractEventPublisher publisher) {
		super(publisher);
		threshold = 21;
	}
	
	@Override 
	public void update() {
		
		//gets updated by publisher
		int data = publisher.state.getEventDataValue();
		
		if(data % 2 != 0) {
			eventsReceived++;
			if(eventsReceived <= threshold) {
				System.out.printf("SubscriberOdds: Event is odd: %d\n", data);
			}
			
			if(eventsReceived == threshold) {
				publisher.unregisterSubscriber(this);
			}
			
		}
		
	}

}
