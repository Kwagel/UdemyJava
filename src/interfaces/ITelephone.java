package interfaces;

public interface ITelephone {
    //    only signatures, the parameters, the name, the return type
    void powerOn();
    
    void dial(int phoneNumber);
    
    void answer();
    
    boolean callPhone(int phoneNumber);
    
    boolean isRinging();
    
}
