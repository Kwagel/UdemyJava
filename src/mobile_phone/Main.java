package mobile_phone;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static MobilePhone mobilePhone = new MobilePhone();
    public static void main(String[] args) {
        
        boolean quit = false;
        while (!quit) {
            System.out.println("Contact Menu");
            System.out.println("------------");
            System.out.println("1 - Print Contact List");
            System.out.println("2 - Add New Contact");
            System.out.println("3 - Update Existing Contact");
            System.out.println("4 - Remove Contact");
            System.out.println("5 - Search For Contact");
            System.out.println("6 - Quit");
            int choice = 0;
            do {
                System.out.println("Choose an option:");
                String input = scanner.nextLine();
                
                if (!isInt(input) || Integer.parseInt(input) > 6 || Integer.parseInt(input) < 1) {
                    System.out.println("Not A Valid Choice.");
                } else {
                    choice = Integer.parseInt(input);
                }
            } while (choice > 6 || choice < 1);
            switch (choice) {
                case 1:
                    mobilePhone.displayContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    SearchForContact();
                    break;
                case 6:
                    quit = true;
                    break;
            }
            
        }
    }
    
    private static void addContact() {
        System.out.print("Please enter Name:");
        String name = scanner.nextLine();
        System.out.print("Please enter Number:");
        String number = scanner.nextLine();
        if(mobilePhone.addContact(name,number)){
            System.out.println("Added Contact");
        }else{
            System.out.println("Failed to Add Contact");
        }
    }
    
    public static void updateContact() {
        System.out.print("Please enter Name:");
        String name = scanner.nextLine();
        System.out.print("Please enter new name or number:");
        String newField = scanner.nextLine();
        if( mobilePhone.modifyContact(name,newField)){
            System.out.println("Updated Contact");
        }else{
            System.out.println("Failed to Update Contact");
        }
    }
    
    private static void removeContact() {
        System.out.print("Please enter Name:");
        String name = scanner.nextLine();
         if (!mobilePhone.removeContact(name)){
             System.out.println("Contact doesn't exist");
         }
    }
    
    private static void SearchForContact() {
        System.out.print("Please enter Name:");
        String name = scanner.nextLine();
        if (!mobilePhone.lookUpContact(name)){
            System.out.println("Could not find Contact");
        }
    }
    
    public static boolean isInt(String input) {
        
        try {
            int number = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
}
