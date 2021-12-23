import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(array));
        reverse(array);
        System.out.println(Arrays.toString(array));
        
    }
    
    public static void reverse(int[] array) {
        int maxIndex = array.length - 1;
        for (int i = 0; i < (array.length / 2); i++) {
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }
    }
    
}
