public class FirstJava {
    public static void main(String[] args) {
        /*
        This is a block comment
        */
        System.out.println("Hello from the August cohort!"); // Remember to put a ";" at the end of most lines!!
        System.out.println("We all love Java!");
        int x = 10; // The variable x is the primitive type "int"
        int y = 5;
        int z = x + y; // Notice that z is an int
        boolean isHappy = true; // Variable names are camelCase
        System.out.println(z);
        // Conditional (if) statement demo
        if (isHappy) {
            System.out.println("I'm glad you're happy!");
        } else {
            System.out.println("It's okay - we've been there.");
        }
        // Array and go through the array with a loop
        String[] names = {"Adrian", "Trae", "Aaron", "Melissa", "Devon"}; // Fixed array uses the {}, NOT the square brackets
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
        for (String currentName : names) { // Enhanced for loop ("for-in" loop in other languages)
            System.out.println(currentName);
        }
    }
}