package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import observer_pattern.AbstractEventPublisher;
import observer_pattern.Event;
import observer_pattern.EventGenerator;
import observer_pattern.SubscriberEvens;

class SubscriberEvensTest{
	
	private AbstractEventPublisher publisher;
	private SubscriberEvens subscriber;

	@BeforeEach
	void setUp() throws Exception {
		publisher = new EventGenerator();
		subscriber = new SubscriberEvens(publisher);
	}

	@Test
	void updateTest() {		
		for(int i=0; i < 15; i++) {
			publisher.setState(new Event(i, 0));
			boolean actual = subscriber.update();
			if(i < 14 && actual == false) {
				fail("notifySubscriber() returned \"false\" under threshold when should be \"true\"");
			}else if(i >= 14 && actual) {
				fail("notifySubscriber() returned \"true\" under threshold when should be \"false\"");
			}
		}
	}
	
	@Test
	void notifySubscriberResetTest() {	

		//adjusting threshold to avoid unregister when max threshold reached
		subscriber.setTreshold(41);
		publisher.registerSubscriber(subscriber);

		for(int i=0; i < 41; i++) {
			publisher.setState(new Event(i, 0));
			boolean actual = subscriber.update();
		}
		
		//check if subscriber is registered
		if (subscriber.isRegistered()) fail("failes to unregister subscriber after 40 iterations");
	}
	
	@Test
	void notifySubscriberThresholdNotReachedTest() {	

		publisher.registerSubscriber(subscriber);

		for(int i=0; i < 14; i++) {
			publisher.setState(new Event(i, 0));
			boolean actual = subscriber.update();
			if (actual == false) fail("notifySubscriber returns false while still under threshold");
		}
	}
}
