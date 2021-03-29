package observer_pattern;



public abstract class AbstractEventDrivenSubscriber implements ISubscriber{

	protected int eventsReceived;
	protected int threshold;
	protected boolean isRegistered; //flag to see if register, avoid error when modifying array while iterating
	protected AbstractEventPublisher publisher;
	
	AbstractEventDrivenSubscriber(AbstractEventPublisher publisher){
		this.publisher = publisher;
		this.eventsReceived = 0;
		this.isRegistered = false;
	}
	
	//executes when updated by publisher
	public boolean update() {
		return false;
	}
	
	public boolean isRegistered() {
		return this.isRegistered;
	}
	public void setTreshold(int threshold) {
		this.threshold = threshold;
	}
}
