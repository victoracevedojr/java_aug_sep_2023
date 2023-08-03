import java.util.Arrays;

public class WednesdayDemo {
    public static void main(String[] args) {
        double miles = 33.44;
        int price = 15; // Can't do int price = 15.45 as the 15.45 has a decimal
        double mileage = 5.25 * miles;
        int dreamSalary = 1_000_000; // "_" is like a comma when dealing with big numbers for legibility
        // int population = 55,222,132; // ILLEGAL - CANNOT use commas when representing numbers
        System.out.println("My dream salary is "+dreamSalary);

        // Create two arrays - one with values already included, and one that's empty
        String[] months = {"January", "February", "March", "April", "May", "June", "July"}; // Fixed array
        int[] favoriteNumbers = new int[10]; // Empty array of int values - the array is size 10
        System.out.println(months);
        System.out.println(Arrays.toString(months)); // Print out the array in a way that we humans can understand!
        System.out.println(Arrays.toString(favoriteNumbers));
    }
}