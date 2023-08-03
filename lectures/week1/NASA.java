public class NASA {
    // NOT every file will have a main method!!
    
    // Count down from 10 to 1, then display "Lift off!"
    public void countdown() {
        // Start at 10, go down by one (i--)
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }
        System.out.println("Lift off!");
    }
    // Overloading - same method name, but different input(s) and/or return types
    public void countdown(int startingPoint) {
        // Start at the given number, go down by one (i--)
        for (int i = startingPoint; i > 0; i--) {
            System.out.println(i);
        }
        System.out.println("Lift off!");
    }
}