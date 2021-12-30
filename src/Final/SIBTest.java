package Final;

public class SIBTest {
	public static final String owner;
	
	static {
		owner = "tim";
		System.out.println("SIBTest static initialization block called");
		
	}
	
	static {
		System.out.println("2nd Initialization block called");
		
	}
	
	public SIBTest() {
		System.out.println("SIB constructed called");
		
	}
	
	public void someMethod() {
		System.out.println("SomeMethod called");
	}
	
	
}
