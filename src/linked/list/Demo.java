package linked.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Melbourne");
        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Perth");
        addInOrder(placesToVisit, "Canberra");
        addInOrder(placesToVisit, "Adelaide");
        addInOrder(placesToVisit, "Darwin");
        addInOrder(placesToVisit, "Brisbane");
        
        printList(placesToVisit);
//        makes index 0 have new address to alice springs, and alice springs has address of melbourne
        addInOrder(placesToVisit, "Alice Springs");
        visit(placesToVisit);
//        placesToVisit.remove(4);
//        printList(placesToVisit);
        
    }
    
    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        
        while (i.hasNext()) {
//            everytime next is called, it changes the value of the iterator and also prints out the current recprd
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("---------------------");
    }
    
    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
//        when ListIterator is initially called,  it doesn't point to the first record yet, so you must call next for it to point to the first one
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while (stringListIterator.hasNext()) {
//            compareTo outputs a number depending on how it compares against the current element that next refers to
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
//                if equal, do not add,(duplicate entry)
                System.out.println(newCity + " is already included as as destination");
                return false;
            } else if (comparison > 0) {
//                new city should appear before this one
//            Brisbane -> Adelaide , would return > 0
//                so if its mean to be before, we have to move the iterator back, then add the city, the method will do the rest for us
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }
        }
        //            once it's gone past every single entry, if still <, add it to the end.
        stringListIterator.add(newCity);
        return true;
    }
    
    
    private static void visit(LinkedList<String> cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();
        if (cities.isEmpty()) {
            System.out.println("No cities in the itinerary");
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            
            switch (action) {
                case 0:
                    System.out.println("Holiday over");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("You have reached the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }
    
    private static void printMenu() {
        System.out.println("Available actions: \npress ");
        System.out.println("0 - to quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous\n");
    }
    
}
    

