package tuesdayWeek8Demo;

public class TuesdayAlgo {

	public static void main(String[] args) {
		int[] keyboardArr = {40, 30, 25};
		int[] drivesArr = {15, 22, 26};
		int thisMax = getMoneySpent(keyboardArr, drivesArr, 53);
		System.out.println("Max found is "+thisMax);
	}
	
	/*
	 * keyboards = an array of keyboard prices
	 * drives = an array of USB drive prices
	 * b = budget - amount you can afford to spend
	 * 
	 * Return:
	 * The maximum amount we can spend, or -1 if we can't afford to buy both a keyboard and a drive
	 */
	public static int getMoneySpent(int[] keyboards, int[] drives, int b) {
		// One possibility - you could sort the two arrays
		
		// Do you think we need any variables BEFORE the for loops?  And if so, which variable(s)?
		int maxSum = -1;
		// Brute-force way: loop through both arrays
		for (int i = 0; i < keyboards.length; i++) {
			int curKeyboardPrice = keyboards[i]; // How do we grab onto the current keyboard's price at index i?
			for (int curDrivePrice : drives) {
				int currentSum = curKeyboardPrice + curDrivePrice;
				System.out.println("Current prices: keyboard = "+curKeyboardPrice+", drive = "+curDrivePrice+"; sum is "+currentSum);
				System.out.println("Maximum sum so far is " + maxSum);
				if (currentSum <= b && currentSum > maxSum) { // Within our budget AND the sum is bigger than the maximum sum so far
					maxSum = currentSum; // Take the current sum and make that the new maximum sum we have found so far
					System.out.println("New max sum is now " + maxSum);
				}
			}
		}
		return maxSum;
	}
}
