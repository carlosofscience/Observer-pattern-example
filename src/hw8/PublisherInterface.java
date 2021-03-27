package hw8;

public interface PublisherInterface {
	
	void notifySubscribers(Event e);
	public void registerSubscriber(SubscriberInterface s);
	public void unregisterSubscriber(SubscriberInterface s);
}
