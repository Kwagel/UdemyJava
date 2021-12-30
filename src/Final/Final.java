package Final;

public class Final {
	private static int classCounter = 0;
	public final int instanceNumber; // = 1
	private final String name;
	
	public Final(String name) {
		this.name = name;
		classCounter++;
//		you would do this more often if the value is calculated, instead of defined by yourself
//		e.g retrieving information from a database
		instanceNumber = classCounter;
		System.out.println(name + " created, instance is "+ instanceNumber);
	}
	
	public int getInstanceNumber() {
		return instanceNumber;
	}
}
