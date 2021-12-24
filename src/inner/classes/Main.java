package inner.classes;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");
    public static void main(String[] args) {
//        static nested
//        non static nested
//        local class
//        anon class
        GearBox mcLaren = new GearBox(6);
//        how to create an instance from a nested class
//        use outerclass.innerclass to select the innerclass template
//        GearBox.Gear first = mcLaren.new Gear(1, 12.3);
//        must reference, the outer class, and then instantiate the inner class
//        GearBox.Gear second = new GearBox.Gear(2, 15.4);
//        you cant instantiate and then try to refer to an inner class without instantiating it
//        GearBox.Gear third = new mcLaren.Gear(3,17.8);
//        System.out.println(first.driveSpeed(1000));
//        for the gears class, you probably only want to access that inside the gear box, and instantiate them inside as well, so you would set the class as private.
//        mcLaren.addGear(1, 5.3);
//        mcLaren.addGear(2, 10.6);
//        mcLaren.addGear(3, 15.9);

//
//        mcLaren.operateClutch(true);
//        mcLaren.changeGear(1);
//        mcLaren.operateClutch(false);
//        System.out.println(mcLaren.wheelSpeed(1000));
//        mcLaren.changeGear(2);
//        System.out.println(mcLaren.wheelSpeed(3000));
//        mcLaren.operateClutch(true);
//        mcLaren.changeGear(3);
//        mcLaren.operateClutch(false);
//        System.out.println(mcLaren.wheelSpeed(6000));
    
        class ClickListener implements Button.OnCLickListener{
            public ClickListener(){
                System.out.println("I've been attached");
            }
    
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
    
        }
        
        btnPrint.setOnClickListener(new ClickListener());
        listen();
    }
    private static void listen(){
        boolean quit = false;
        while (!quit){
            int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 0:
                            quit = true;
                            break;
                        case 1:
                            btnPrint.onClick();
                            break;
                    }
        }
    }
}