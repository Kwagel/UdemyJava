package Final;

public class ExtendedPassword extends Password{
	private int decryptedPassword;
	
	public ExtendedPassword(int password) {
		super(password);
		this.decryptedPassword = password;
	}
//	for anything that you never want someone else to be able to change, declaring them as final prevents from being overwritten
//	@Override
//	public void storePassword() {
//		System.out.println("Saving password as " + this.decryptedPassword);
//	}
}
