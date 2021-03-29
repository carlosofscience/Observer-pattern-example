package observer_pattern;

public class Event {
	private int eventSequenceNumber;
	private int eventDataValue;
	
	public Event(int sequence, int data){
		eventSequenceNumber = sequence;
		eventDataValue = data;
	}

	public int getEventSequenceNumber() {
		return eventSequenceNumber;
	}

	public int getEventDataValue() {
		return eventDataValue;
	}
}
