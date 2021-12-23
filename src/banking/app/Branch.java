package banking.app;

import java.util.ArrayList;

public class Branch {
    ArrayList<Customer> customers = new ArrayList<>();
    
    public Branch() {
    }
    
    public void addCustomer(String name) {
        customers.add(new Customer(name));
    }
    
    public void addCustomer(String name, double amount) {
        customers.add(new Customer(name, amount));
    }
    
    public void addTransaction(String name, double amount) {
        if (isCustomer(name)) {
            customers.get(getID(name)).addTransaction(amount);
        }
    }
    
    public boolean isCustomer(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
    
    public int getID(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
    
}
