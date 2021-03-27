package hw8;

public class EvensSubscriberImpl implements SubscriberInterface{
	
	private int eventsReceived;
	private int threshold = 14;
	private PublisherImpl publisherImpl;
	
	@Override
	public boolean notifySubscriber(Event event) {
		int value = event.getEventDataNum();
		if(value % 2 == 0) {
			eventsReceived++;
			if(eventsReceived <= threshold) {
				System.out.printf("EvensSubscriberImpl: Event is even: %d\n", value);
			}
			if(eventsReceived == threshold) {
				publisherImpl.unregisterSubscriber(this);
			}
		}
		return true;
	}
	
	@Override
	public void reRegister() {
		publisherImpl.unregisterSubscriber(this);
		publisherImpl.registerSubscriber(this);
	}

}
