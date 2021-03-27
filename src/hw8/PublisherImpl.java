package hw8;

import java.util.ArrayList;

public class PublisherImpl implements PublisherInterface {
	ArrayList<SubscriberInterface> subscribers = new ArrayList<SubscriberInterface>();
	


	@Override
	public void notifySubscribers(Event e) {
		for (SubscriberInterface s : subscribers) {
			s.notifySubscriber(e);
		}
	}
	
	// add the subscriber to list
	@Override
	public void registerSubscriber(SubscriberInterface s) {
		subscribers.add(s);
	}

	@Override
	public void unregisterSubscriber(SubscriberInterface s) {
		subscribers.remove(s);
		
	}
	
	public PublisherImpl() {}

}
