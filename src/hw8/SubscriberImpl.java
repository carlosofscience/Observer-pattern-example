package hw8;

public class SubscriberImpl implements SubscriberInterface {

	@Override
	public void notifyMe(MyEvent e) {
		System.out.println("I was invoked");
		System.out.println(e.getInfo1());
		System.out.println(e.getInfo2());
		
	}
	
	

}
