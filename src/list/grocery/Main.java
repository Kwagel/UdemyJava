package list.grocery;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();
    
    public static void main(String[] args) {
        boolean quit = false;
        int choice = -1;
        while (!quit) {
            System.out.print("Press any key to continue...");
            scanner.nextLine();
            printInstructions();
            boolean validChoice = false;
            do {
                System.out.println("Please enter a valid choice:");
                String input = scanner.nextLine();
                if (!isInt(input)) {
                    System.out.println(input + " is not a valid choice:");
                } else if ( isInt(input) && Integer.parseInt(input) < 0 || isInt(input) && Integer.parseInt(input) > 6){
                    System.out.println(input + " is not a valid choice:");
                }else {
                    choice = Integer.parseInt(input);
//                    scanner.nextLine();
                    validChoice = true;
                }
            } while ( !validChoice);
            
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
        
    }
    
    private static void addItem() {
        System.out.print("Please enter a new grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }
    
    private static void modifyItem() {
        System.out.print("Enter item you with to replace:");
        String itemNo = scanner.nextLine();
        System.out.print("Enter replacement item:");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo, newItem);
        
    }
    
    private static void removeItem() {
        System.out.print("Enter item that you wish to remove:");
        String item = scanner.nextLine();
        
        groceryList.removeGroceryItem(item);
    }
    
    private static void searchForItem() {
        System.out.println("Enter item you are looking for:");
        String searchItem = scanner.nextLine();
        if (groceryList.onFile(searchItem)) {
            System.out.println("Found " + searchItem);
        } else {
            System.out.println(searchItem + ", not on file.");
        }
    }
    
    public static void printInstructions() {
        System.out.println("\tGrocery List Menu");
        System.out.println("-----------------------------");
        System.out.println("\t0 - print choice options");
        System.out.println("\t1 - print grocery list");
        System.out.println("\t2 - add item");
        System.out.println("\t3 - modify item");
        System.out.println("\t4 - remove item");
        System.out.println("\t5 - search for item");
        System.out.println("\t6 - quit");
        System.out.println();
    }
    
    public static boolean isInt(String input){
        try {
            Integer.parseInt(input);
                    return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
    
}
