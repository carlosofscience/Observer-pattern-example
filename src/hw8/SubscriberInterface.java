package hw8;

public interface SubscriberInterface {
	public boolean notifySubscriber(Event e);
	public void reRegister(); //added to solve re-register
}
