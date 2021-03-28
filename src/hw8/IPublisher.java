package hw8;

//Observable
public interface IPublisher {
	public void notifySubscriber();
	public void registerSubscriber(AbstractEventDrivenSubscriber s);
	public void unregisterSubscriber(AbstractEventDrivenSubscriber s);
}
