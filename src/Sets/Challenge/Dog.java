package Sets.Challenge;

public class Dog {
	private final String name;
	
	public Dog(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
//	we have to declare this as final, as anythign that is a subclass of a dog, is also a dog, so they shouldn't have their own unique equals.
	public final boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj instanceof Dog){
			String objName = ((Dog) obj).getName();
			return this.name.equals(objName);
		}
		return false;
	}
}
