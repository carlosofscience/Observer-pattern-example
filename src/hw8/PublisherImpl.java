package hw8;

import java.util.ArrayList;

public class PublisherImpl implements PublisherInterface {
	ArrayList<SubscriberInterface> subscribers = new ArrayList<SubscriberInterface>();
	
	
	// add the subscriber to list
	@Override
	public void addSubscriber(SubscriberInterface s) {
		subscribers.add(s);
	}

	@Override
	public void removeSubscriber(SubscriberInterface s) {
		subscribers.remove(s);
		
	}

	@Override
	public void notifyAll(MyEvent e) {
		for (SubscriberInterface s : subscribers) {
			s.notifyMe(e);
		}
	}

}
