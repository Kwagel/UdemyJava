package interfaces;

public class Main {
    
    public static void main(String[] args) {
        ITelephone kensPhone = new DeskPhone(123235);
        kensPhone.powerOn();
        kensPhone.callPhone(123235);
        kensPhone.answer();
    }
    
}
