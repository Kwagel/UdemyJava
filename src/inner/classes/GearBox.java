package inner.classes;

import java.util.ArrayList;

public class GearBox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    
    public GearBox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<>();
        Gear neutral = new Gear(0, 0.0);
        this.gears.add(neutral);
    }
//    you use nested classes, when the class doesn't make sense to exist by itself as you would never use that class independently
    public class Gear{
        private int gearNumber;
        private double ratio;
    
        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }
    
        public double driveSpeed(int revs){
            return revs * (this.ratio);
        }
    }
    
}
