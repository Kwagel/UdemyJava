package inner.classes;

public class Main {
    public static void main(String[] args) {
//        static nested
//        non static nested
//        local class
//        anon class
        GearBox mcLaren = new GearBox(6);
//        how to create an instance from a nested class
//        use outerclass.innerclass to select the innerclass template
        GearBox.Gear first = mcLaren.new Gear(1, 12.3);
//        must reference, the outer class, and then instantiate the inner class
//        GearBox.Gear second = new GearBox.Gear(2, 15.4);
//        you cant instantiate and then try to refer to an inner class without instantiating it
//        GearBox.Gear third = new mcLaren.Gear(3,17.8);
        System.out.println(first.driveSpeed(1000));
//        for the gears class, you probably only want to access that inside the gear box, and instantiate them inside as well, so you would set the class as private.
    }
    
}
