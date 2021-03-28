package hw8;

public class Event {
	private int eventSequenceNumber;
	private int eventDataValue;
	
	Event(int sequence, int data){
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
