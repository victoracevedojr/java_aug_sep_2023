import java.util.Arrays; // Import statements go at the top of your files!

public class ThursdayTest {
    public static void main(String[] args) {
        int[] zeroesArray = new int[7]; // Array of 7 integer values - all 0 by default
        int[] myValues = {10, 7, 12}; // Fixed array - you MUST use the {} on the right, NOT the []
        System.out.println(Arrays.toString(myValues)); // Proper way to print the entire array
        // Testing each item
        ThursdayObjectDemo thursDemo = new ThursdayObjectDemo();
        System.out.println(thursDemo.sumArray(myValues));
        thursDemo.arrayListTest();
        thursDemo.hashMapDemo();
    }
}