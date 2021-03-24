package hw8;

public class hw8 {

	public static void main(String[] args) {
		System.out.println("Welcome to the Observer Demo");
		
		// create the Publisher
		PublisherImpl pub = new PublisherImpl();
		
		// Create a subscriber
		SubscriberImpl sub1 = new SubscriberImpl();
		
		// Subscribe to the publisher
		pub.addSubscriber(sub1);
		
		// Create an event
		MyEvent e1 = new MyEvent("Example Payload String", "a Second example Payload String");
		
		// Let everyone know about the new event
		pub.notifyAll(e1);	
	}

}
