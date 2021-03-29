package observer_pattern;

//Observer
public interface ISubscriber {
	public boolean update(); //runs when Observable state changes
}
