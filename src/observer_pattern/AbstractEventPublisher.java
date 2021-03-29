package observer_pattern;

import java.util.ArrayList;

public abstract class AbstractEventPublisher implements IPublisher{

	protected ArrayList<AbstractEventDrivenSubscriber> subscribers;
	protected Event state; //current event

	AbstractEventPublisher(){
		subscribers = new ArrayList<AbstractEventDrivenSubscriber>();
	}
	
	public void setState(Event e) {//sets the state (event)
		state = e;
	}
	
	@Override
	public void notifySubscriber() {
		for(AbstractEventDrivenSubscriber subscriber: subscribers) {
			if(subscriber.isRegistered) subscriber.update();	//only update registered subscribers
		}
	}

	@Override
	public void registerSubscriber(AbstractEventDrivenSubscriber s) {
		s.isRegistered = true;
		System.out.printf(" + registering Subscriber -> class: %s\n", s.getClass());
	}

	@Override
	public void unregisterSubscriber(AbstractEventDrivenSubscriber s) {
		s.isRegistered = false;
		System.out.printf(" - unregistering Subscriber -> class: %s\n", s.getClass());

	}

}
