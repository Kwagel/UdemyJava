package linked.list;

import java.util.ArrayList;

public class Main {
    //     linked lists are structure in away that allows calculation of memory address location with base address of index 0 and required index location
//    this is because each value in the list is assigned 4 bytes of memory to hold the value
//    this means there memory address of any position is = base address + 4*index
//    Linked List
//for linked lists of strings, the value will actually be a string address, that point tot the address that stores the string value, as string can be any size, so wont work for normal conversion
    public static void main(String[] args) {
        Customer customer = new Customer("Tim", 54.96);
        Customer anotherCustomer;
        anotherCustomer = customer;
        anotherCustomer.setBalance(12.18);
        System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance());
    
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(3);
        intList.add(4);
        
        for (int i = 0; i < intList.size(); i++){
            System.out.println(i + ": " + intList.get(i));
        }
    intList.add(1,2);
        for (int i = 0; i < intList.size(); i++){
            System.out.println(i + ": " + intList.get(i));
        }
        
//        linked lists  values holds the address of the next item in the list, this means when you add something, you only need to change two values, instead of pushing every single value along the memory address resiter
//    garbage collection detects when an element in a linked list is unused and will destroy it
    
    }
    
    
    
    
}
