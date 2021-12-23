package banking.app;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    static ArrayList<Branch> branches = new ArrayList<>();
   
    public static void main(String[] args) {
        branches.add(new Branch());
        boolean quit = false;
        while (!quit) {
            System.out.println("1 - Add new Account");
            System.out.println("2 - Add new Account with transactions");
            System.out.println("3 - Add new Transaction");
            System.out.println("4 - quit");
            int choice = 0;
            do {
                System.out.println("Please enter choice");
                String input = new Scanner(System.in).nextLine();
                if (!isInt(input)) {
                    System.out.println("Invalid choice");
                } else if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 4) {
                    System.out.println("Invalid choice");
                    
                } else {
                    choice = Integer.parseInt(input);
                }
            } while (choice < 1 || choice > 4);
            
            switch (choice) {
                case 1:
                    
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
    }
    
    public static boolean isInt(String choice) {
        try {
            int output = Integer.parseInt(choice);
            return true;
        } catch (NumberFormatException e) {
            return false;
            
        }
        
    }
    
}
