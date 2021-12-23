package banking.app;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;
    
    public Customer(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
    }
    
    public Customer(String name, double amount) {
        new Customer(name);
        addTransaction(amount);
    }
    
    public String getName() {
        return name;
    }
    
    public void addTransaction(double transaction) {
        transactions.add(transaction);
    }
    
}
