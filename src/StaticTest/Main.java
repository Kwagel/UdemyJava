package StaticTest;

//use class main, so we can easily find the starting point of the code
public class Main {
	//	this has to be static, as you can't run non-static methods without instantiating the class first
	public static int multiplier = 7;
	
	public static void main(String[] args) {
//		if you are going to use static variables, it makes sense to make methods that deal with it static as well, as it wouldn't matter which instance you called as they draw from the same variable
//		StaticTest firstInstance = new StaticTest("1st Instance");
//		System.out.println(firstInstance.getName() + " is instance number " + StaticTest.getNumInstances());
//
//		StaticTest secondInstance = new StaticTest("2nd instance");
//		System.out.println(secondInstance.getName() + " is instance number " + StaticTest.getNumInstances());
//
//		StaticTest thirdInstance = new StaticTest("3rd instance");
//		System.out.println(thirdInstance.getName() + " is instance number " + StaticTest.getNumInstances());
		int answer = multiple(6);
		System.out.println("the answer is "+ answer);
		System.out.println("Multiplier is " + multiplier);
//		this restriction applies to non instantiated class methods and fields that aren't static, as they don't exist until they are, s you wouldn't be able to access them.
	}
	
	public static int multiple(int number) {
		return number * multiplier;
	}
	
}


