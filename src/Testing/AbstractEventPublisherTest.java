package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hw8.AbstractEventPublisher;
import hw8.Event;
import hw8.EventGenerator;
import hw8.SubscriberEvens;

class AbstractEventPublisherTest {

	private AbstractEventPublisher publisher;
	private SubscriberEvens subscriber;

	@BeforeEach
	void setUp() throws Exception {
		publisher = new EventGenerator();
		subscriber = new SubscriberEvens(publisher);
	}


	@Test
	void RegisterSubscriberTest() {
		publisher.registerSubscriber(subscriber);
		if(!subscriber.isRegistered()) fail("registerSubscriber() failed to register Subscriber");
	}

	@Test
	void UnregisterSubscriberTest() {
		publisher.unregisterSubscriber(subscriber);
		if(subscriber.isRegistered()) fail("registerSubscriber() failed to unregister Subscriber");
	}
	
	@Test
	void NotifiedEventTest() {
		publisher.unregisterSubscriber(subscriber);
		Event event = new Event(0, 15);
		publisher.setState(event);
		publisher.notifySubscriber();
		
		if(subscriber.update()) fail("notifySubscriber() failed to notify Subscriber");
	}

}
