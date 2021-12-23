package interfaces;

public class GearBox {
    private boolean clutchIsIn;
//     An interface is a commitment to the layout of a class, so that method signatures won;t change, and keeps it functioning
    public void operateClutch(boolean inOrOut) {
        this.clutchIsIn = inOrOut;
    }
}
