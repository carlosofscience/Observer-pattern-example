package hw8;

public class HWMain {

	public static void main(String[] args) 
	{
		PublisherImpl pub = new PublisherImpl();
		EventGenerator eventGen = new EventGenerator();
		
		SubscriberInterface[] subs = 
		{
			new OddsSubscriberImpl(),
			new EvensSubscriberImpl(),
			new ThreesSubscriberImpl()
		};
		
		for(SubscriberInterface sub: subs) 
		{
			pub.registerSubscriber(sub);
		}
		
		eventGen.runSimulation();
	}

}
