import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ThursdayObjectDemo {
    // Take in an array of integers as input and return the sum as output
    public int sumArray(int[] inputArr) {
        int sum = 0;
        for (int ind = 0; ind < inputArr.length; ind++) {
            // Add the current value to the sum
            sum += inputArr[ind]; // sum += inputArr[0], sum += inputArr[1], etc.
            // sum = sum + inputArr[ind]; // Alternate approach to adding to the sum
        }
        return sum;
    }

    public void arrayListTest() {
        // Inside the <> you need some sort of Object - it can be the generic Object class so you can store any data types,
        // or you could use wrapper classes like Integer, Boolean, you could use Strings, or even classes you create, like
        // a User class
        // WARNING: do NOT use primitive types - so don't do ArrayList<int>, it has to be ArrayList<Integer>
        ArrayList<String> codingLanguages = new ArrayList<String>();
        codingLanguages.add("Java");
        codingLanguages.add("Python");
        codingLanguages.add("JavaScript");
        // System.out.println(codingLanguages); // Print entire array list (it'll look like an array)
        // System.out.println(codingLanguages.get(0)); // Equivalent to codingLanguages[0] in Python and JS

        // // Display all the languages from this array list, one at a time
        // for (int i = 0; i < codingLanguages.size(); i++) {
        //     System.out.println(codingLanguages.get(i));
        // }

        for (String currentLanguage : codingLanguages) { // Another version with an "enhanced" for loop
            System.out.println(currentLanguage);
        }
    }

    public void hashMapDemo() {
        // Hash map where the string is going to hold a key which is the programming language, and the value is a score (integer)
        HashMap<String, Integer> languageScores = new HashMap<String, Integer>();
        languageScores.put("JavaScript",8);
        languageScores.put("Python",8);
        languageScores.put("Java",6);
        System.out.println(languageScores);
        Set<String> allLanguages = languageScores.keySet(); // Grab all the keys for this map
        // Go through each key (and value)
        for (String curLanguage : allLanguages) {
            System.out.println(curLanguage + " has a value (score) of " + languageScores.get(curLanguage));
        }
    }
}