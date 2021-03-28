package hw8;



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
	public void update() {
		
	}
	
}
