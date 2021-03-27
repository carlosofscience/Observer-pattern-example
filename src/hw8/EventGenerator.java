package hw8;

import java.util.ArrayList;

public class EventGenerator {
	ArrayList<SubscriberInterface> subscribers = new ArrayList<SubscriberInterface>();

	public EventGenerator() {}
	
	public void runSimulation() {
		//create a random number to notify each subscriber
		//simulation for 200 iterations
		int max = 10000, min = 0, data = (int) (Math.random() * (max - min + 1) + min);
		
		for (int sequence=0; sequence < 200; sequence++)
		{
			System.out.printf("sequence: %d, data: %d\n", sequence, data);
			Event event =  new Event(sequence, data);
			//if sequence is divisible by 40 re-register subscribers
			if(sequence % 40 == 0) {
				//re-register
				for (SubscriberInterface subscriber: subscribers) {
					subscriber.reRegister();
				}
			}else {
				for (SubscriberInterface subscriber: subscribers) {
					subscriber.notifySubscriber(event);
				}
			}
			
			//generate new random data
			data = (int) (Math.random() * (max - min + 1) + min);
		}
		
	}
	
	private Event generateEvent() {
		return new Event(0,0); //change this to UID
	}
}
