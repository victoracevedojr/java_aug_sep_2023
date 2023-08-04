import java.util.Random;

public class NumberGame {
    // Method to generate AND return the random number, which is an int
    public int pickRandomNumber() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(1000) + 1; // .nextInt(1000) generates int from 0 to 999 (inclusively)
    }

    // Play the game
    public void playGame() {
        // The actual number, number of guesses, previous guesses
        
        // Get the random number itself
        int pickedNumber = pickRandomNumber();
        // System.out.println(pickedNumber);
        int guessCount = 1; // Start with first guess
        boolean winner = false; // Game not won yet
        while (guessCount < 13 && !winner) { // While we have guesses remaining and we haven't won the game yet
            // Read in user's guess
            System.out.println("Guess #" + guessCount + ": Enter your guess here!");
            String inputGuess = System.console().readLine(); // See week 1 core assignment
            int inputVal;
            // Validate input here (doesn't check for integers out of range)
            try {
                inputVal = Integer.parseInt(inputGuess); // Type-cast this to an int
            } catch (NumberFormatException e) { // Didn't get a valid integer as input
                System.out.println("Invalid input!");
                continue; // Go to next iteration of loop
            }
            if (inputVal < pickedNumber) { // Actual value is higher
                System.out.println("The number is higher than " + inputVal);
                guessCount++;
            } else if (inputVal > pickedNumber) { // Actual value is lower
                System.out.println("The number is lower than " + inputVal);
                guessCount++;
            } else { // Equal
                System.out.println("Congratulations!!!  The number is indeed " + inputVal);
                winner = true; // Allow us to exit the loop
            }
        }
        if (!winner) {
            System.out.println("I'm sorry - you're out of guesses.  The correct number is " + pickedNumber);
        }
    }
}