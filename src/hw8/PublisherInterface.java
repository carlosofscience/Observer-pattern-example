package hw8;

public interface PublisherInterface {
	
	public void addSubscriber(SubscriberInterface s);
	public void removeSubscriber(SubscriberInterface s);
	
	public void notifyAll(MyEvent e);

}
