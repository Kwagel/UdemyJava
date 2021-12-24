package interfaces;

public class Main {
//    when usign arraylists,vectors and linked list, you should call them with List as they all use that interface, which allows you to swap between them if your code necessitates it.
    public static void main(String[] args) {
        ITelephone kensPhone = new DeskPhone(123235);
        kensPhone.powerOn();
        kensPhone.callPhone(123235);
        kensPhone.answer();
    
        kensPhone = new MobilePhone(123414);
   kensPhone.callPhone(123414);
   kensPhone.powerOn();
   kensPhone.callPhone(123414);
   kensPhone.answer();
    }
    
}
