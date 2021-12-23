package mobile_phone;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> contacts;
    
    public MobilePhone() {
        this.contacts = new ArrayList<Contact>();
    }
    
    public boolean addContact(String name, String phoneNumber) {
        if (!checkName(name)) {
            contacts.add(new Contact(name, phoneNumber));
            return true;
        }
        return false;
    }
    
    public boolean modifyContact(String name, String newName) {
        if (checkName(name)) {
            if (!isNumber(newName)) {
                if(checkName(newName)){
                    return false;
                }else {
                    contacts.get(getID(name)).setName(newName);
                }
            } else {
                contacts.get(getID(name)).setPhoneNumber(newName);
            }
            return true;
        }
        return false;
    }
    
    private boolean isNumber(String newEntry) {
        char[] number = newEntry.toCharArray();
        for (char c : number
        ) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean removeContact(String name) {
        if (checkName(name)) {
            contacts.remove(getID(name));
            return true;
        }
        return false;
    }
    
    public boolean lookUpContact(String name) {
        if (checkName(name)) {
            System.out.println("Found Contact...");
            contacts.get(getID(name)).printContactDetails();
            return true;
        } else {
            return false;
        }
    }
    
    public void displayContacts() {
        for (Contact c : contacts
        ) {
            c.printContactDetails();
        }
    }
    
    private boolean checkName(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
    
    private int getID(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
    
}


