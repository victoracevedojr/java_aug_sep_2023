import java.util.HashMap; // Importing the HashMap class (you'll be importing OFTEN!)

public class Wednesday {
    public static void main(String[] args) {
        String message = "Hello from Java!"; // When defining a string, do NOT use single quotes - use double quotes
        char letter = 'a'; // Character - defined with the single quotes '
        System.out.println(message);
        System.out.println(letter);
        // One way to concatenate (put together) strings (other ways shown in platform)
        String name = "Adrian";
        System.out.println("Hello from " + name);
        String name2 = new String("Adrian");
        System.out.println(name == name2); // false!  Compares MEMORY LOCATIONS - not the values of the strings
        System.out.println(name.equals(name2)); // Prints true as expected - compares values themselves
        printGreeting("Melissa"); // Call on the static method defined in this class
        // Dependency injection
        NASA firstNasaVersion = new NASA(); // Creating an instance of the NASA class (in same folder as this file)
        firstNasaVersion.countdown();
        firstNasaVersion.countdown(20);

        // Create a map - key-value pairs
        HashMap<String, String> countryCapitals = new HashMap<String,String>();
        countryCapitals.put("Canada","Ottawa");
        countryCapitals.put("France","Paris");
        System.out.println("The capital of Canada is "+countryCapitals.get("Canada"));

        // Type casting
        double price = 24.99;
        int priceDollars = (int) price;
        System.out.println(priceDollars);
        double quotient = (double) 7 / 2; // Only store 3, NOT 3.5, if you save as an int
        System.out.println(quotient);

    }

    // If you define a method in the same class file as the one that has the main method, you need the word "static"
    public static void printGreeting(String name) {
        System.out.println("Hello "+name);
    }
}