import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        values types individually refer to a single space in memory, reference types refer to the same location in memory, with multiple references that can reference it

//        value types
        int myIntValue = 10;
        int anotherIntValue = myIntValue;
        System.out.println(myIntValue);
        System.out.println(anotherIntValue);
        
        anotherIntValue++;
        System.out.println(myIntValue);
        System.out.println(anotherIntValue);
//        reference types
        int[] myIntArray = new int[5];
        int[] anotherArray = myIntArray;
        
//        coding interfaces.challenge
        System.out.println("Pleas choose how long the array will be");
        int count =  Integer.parseInt(new Scanner(System.in).nextLine());
        int[] array = readIntegers(count);
        System.out.println(Arrays.toString(array));
        int minValue = findMin(array);
        System.out.println(minValue);
    }
    
    public static int[] readIntegers(int count) {
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter number:");
            array[i] = scanner.nextInt();
            scanner.nextLine();
        }
        return array;
    }
    
    public  static int findMin(int[] count) {
        int minValue = count[0];
        for (int i = 0; i < count.length; i++) {
            if (count[i] < minValue) {
                minValue = count[i];
            }
        }
        return minValue;
    }
    
}
