package ScopeChallenge;

import java.util.Scanner;

public class Main {
	private int x;
	public static void main(String[] args) {
		Main x = new Main();
		x.x();
	}
	
	public void x() {
		this.x = x( new Scanner(System.in));
		if (x > 0 && x < 12) {
			for (int x = 0; x <= 10; x++) {
				System.out.println(x * this.x);
				
			}
		}
	}
	public int x(Scanner x){
		
		return  Integer.parseInt(x.nextLine());
	}
}

