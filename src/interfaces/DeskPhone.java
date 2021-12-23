package interfaces;

public class DeskPhone implements ITelephone{
    public DeskPhone(int myNumber) {
        this.myNumber = myNumber;
    }
    
    //    must implement all methods from the interface, part of the contract
    private int myNumber;
    private boolean isRinging;
    @Override
    public void powerOn() {
        System.out.println("No action taken, desk phone does not have a power button");
    }
    
    @Override
    public void dial(int phoneNumber) {
        System.out.println("Now ringing " + phoneNumber + " on the desk phone");
    }
    
    @Override
    public void answer() {
        if (isRinging()){
            System.out.println("Answering the phone");
            isRinging = false;
        }
    }
    
    @Override
    public boolean callPhone(int phoneNumber) {
        if(phoneNumber ==  myNumber){
            isRinging = true;
        }else{
            isRinging = false;
        }
        return isRinging;
    }
    
    @Override
    public boolean isRinging() {
        return isRinging;
    }
    
}
