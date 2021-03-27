package hw8;

public class OddsSubscriberImpl implements SubscriberInterface{
	
	private int eventsReceived;
	private int threshold = 21;
	private PublisherImpl publisherImpl;
	
	@Override
	public boolean notifySubscriber(Event event) {
		int value = event.getEventDataNum();
		if(value % 2 != 0) {
			eventsReceived++;
			if(eventsReceived <= threshold) {
				System.out.printf("OddsSubscriberImpl: Event is odd: %d\n", value);
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
