package hw8;

public class ThreesSubscriberImpl implements SubscriberInterface{

	private int eventsReceived;
	private int threshold = 10;
	private PublisherImpl publisherImpl;
	
	@Override
	public boolean notifySubscriber(Event event) {
		int value = event.getEventDataNum();
		if(value % 3 == 0) {
			eventsReceived++;
			if(eventsReceived <= threshold) {
				System.out.printf("ThreesSubscriberImpl: Event is divisible by 3: %d\n", value);
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
