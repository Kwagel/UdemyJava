package linked.list;

public class Customer {
    private String name;
    private double balance;
    
    public String getName() {
        return name;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public Customer(String customer, double balance) {
        this.name = customer;
        this.balance = balance;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
}

