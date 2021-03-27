package hw8;

public class Event {
	
	private int EventSequenceNumber;
	private int EventDataValue;
	
	public Event(int seqNum, int data) {
		EventSequenceNumber = seqNum;
		EventDataValue = data;
	}

	public int getEventSeqNum() {return EventSequenceNumber;}
	public int getEventDataNum() {return EventDataValue;}
}
