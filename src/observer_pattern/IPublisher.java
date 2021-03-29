package observer_pattern;

//Observable
public interface IPublisher {
	public void notifySubscriber();
	public void registerSubscriber(AbstractEventDrivenSubscriber s);
	public void unregisterSubscriber(AbstractEventDrivenSubscriber s);
}
