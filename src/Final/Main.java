package Final;

public class Main {
	public static void main(String[] args) {

//		Final one = new Final("one");
//		Final two = new Final("two");
//		Final three = new Final("three");
//
//		System.out.println(one.getInstanceNumber());
//		System.out.println(two.getInstanceNumber());
//		System.out.println(three.getInstanceNumber());
////		name can't be changed because it is private, and final
////		one.name = "three";
//
////		instanceNumber cannot be change because it is final
////		one.instanceNumber = 4;
//		System.out.println(Math.PI);
////		Math m = new Math();
//
//		int pw = 123456;
//		Password password = new ExtendedPassword(pw);
//		password.storePassword();
//		password.letMeIn(1);
//		password.letMeIn(123456);
//		password.letMeIn(583458);
		
		System.out.println("Main method called");
		SIBTest test = new SIBTest();
		test.someMethod();
		System.out.println("Owner is "+ SIBTest.owner);
	}
	
	
}
