import java.util.Scanner;

// SARA ANGELINA RAHIM
// R00211761

public class PaperRollCuttingBottomUp { // class PaperRollCuttingBottomUp
    public static void main(String[] args) { // main method

        Scanner scanner = new Scanner(System.in); // scanner object that takes in user input
        System.out.print("Enter the length of the toilet roll:  "); // user input to get length of toilet roll

        int toiletRollLength = scanner.nextInt(); // user input in variable toiletRollLength
        double[] prices_Cut = {0,  1.2, 3, 5.8, 0, 10.1}; // array of prices for each cut of the toilet roll
        double[] revenue = new double[toiletRollLength + 1]; // array of revenue for each cut of the toilet roll - +1 because we start at 1 not 0
        int[] cuts = new int[6]; // array of cuts for each length of the toilet roll

        for (int i = 1; i<= toiletRollLength; i++) {  // for loop to iterate through each cut of the toilet roll - from 1 to toiletRollLength
            double best_revenue = Double.NEGATIVE_INFINITY; // set max_revenue to negative infinity -- first cut is always greater than max_revenue
            // so that it is updated through each iteration of the for loop above
            for (int j = 1; j <= Math.min(i, 5); j++) { // for loop to iterate through each cut of the toilet roll

                best_revenue = Math.max(best_revenue, prices_Cut[j] + revenue[i-j]); // calculate max revenue
                // max_revenue is the maximum of the current max_revenue and the price of the cut + the revenue of the remaining length
            }
            revenue[i] = best_revenue; // store max revenue in array
        }

        System.out.println("The best revenue is: " + String.format("%.2f", revenue[toiletRollLength]) + "€");
        // print out the best revenue, 2 decimal places

        while (toiletRollLength > 0) { // while loop to iterate through each cut of the toilet roll
            for (int j = 1; j <= Math.min(toiletRollLength, 5); j++) { // loops through each cut of the toilet roll

                if (revenue[toiletRollLength] == prices_Cut[j] + revenue[toiletRollLength - j]) { // if statement to check if revenue is equal to price of roll + the revenue
                    // of the remaining length of the toilet roll after the cut
                    cuts[j]++; // increment cuts array
                    toiletRollLength -= j; // decrement toiletRollLength

                    break; // break out of loop
                }
            }
        }

        // print out the number of rolls of each length
        System.out.println("Number of rolls of each length:" + "\nLength 1 => €1.2: " + cuts[1] + "\nLength 2 => €3.0: " + cuts[2] + "\nLength 3 => €5.8: " + cuts[3] + "\nLength 5 => €10.1: " + cuts[5]);
    }
}