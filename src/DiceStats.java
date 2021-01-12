/*
 * Chapter 7 Lab
 * Description: simulate 10,000 rolls of each dice, record the results, then calculate some stats for each list
 * Name: Mohammad Abdelrahman
 * ID: 920158652
 * Class: CSC 211-02
 * Semester: fall 2020
 */
public class DiceStats {
    public static final int ROLLS = 10000;
    public static void main(String[] args) {
        double[] dice = new double[ROLLS]; // array to list the 10000 rolls for each dice
        double avg = 0.0; // variable avg to hold the calculated avg for each dice

        for (int i = 4; i <= 20; i += 2) { // loop to go through all the different dices we have starts from 4 and ends at 20
            System.out.printf("d%d STATS\n",i); // prints the status of dice
            System.out.println("===================");
            avg = average(dice, i); // call average method to get the average of rolls for the desired dice(i)
            System.out.printf("Calculated Average: %.3f\n", avg); // prints out the value of the calculated average
            System.out.printf("Calculated Std Dev: %.3f\n", StdDeviation(dice, avg)); // call StdDeviation method with the array and it's average
            System.out.println("Expected Average: " + expectedAvg(i)); // call expectedAvg method to get the Theoretical Avg for a specific dice face
            System.out.printf("%% error for Calculated Avg: %.2f%%\n", error(expectedAvg(i), avg)); // call error method to get the % error passing the Theoretical Avg and the calculated avg
            System.out.println(); // new line
            System.out.println("Practical Average: " + (int) avg); // print the casted calculated avg
            System.out.println("Expected Practical Average: " + (int) expectedAvg(i)); // print the casted Theoretical Avg
            System.out.printf("%% error for Practical Avg: %.2f%%\n", error((int) expectedAvg(i), (int) avg) ); // call error method to get the % error passing the casted Theoretical Avg and the casted calculated avg
            System.out.println(); // new line
            if (i == 12) { // condition to make sure to get to all faces from 4 to 20 skipping (14,16,18)
                i = 18;
            }
        }

    }

    public static double expectedAvg(int face) { // method to return the desired Theoretical Avg for a given dice face
        double expAvg = 0.0;
        switch (face) {
            case 4:
                return expAvg = 2.5;
            case 6:
                return expAvg = 3.5;
            case 8:
                return expAvg = 4.5;
            case 10:
                return expAvg = 5.5;
            case 12:
                return expAvg = 6.5;
            case 20:
                return expAvg = 10.5;
            default:
                System.out.println("Wrong face number!");

                return expAvg;
        }
    }

    public static double average(double[] dice, int face) { // method to calculate the average of a dice and it's faces
        double sum = 0; // variable to hold the calculated sum
        double avg = 0; // variable to hold the calculated avg
        for (int i = 0; i < dice.length; i++) { // loop to go though the given array
            dice[i] = rollDice(face); // assign a random value from the rollDice method into the array
            sum += dice[i]; // adding all the values together
        }
        return avg = sum / (ROLLS - 1); // calculating the average by dividing the sum of all values over the rolls
    }

    public static int rollDice(int face) { // method to run a dice with a certain face number
        return (int) (Math.random() * face) + 1; // return a random number between 1 and face number
    }

    public static double StdDeviation(double[] dice, double avg) { // method to calculate the Standard deviation it takes the array and it's calculated avg
        double sigma = 0; // variable to get the sigma for the formula
        for (int i = 0; i < dice.length; i++) { // loop through the array
            sigma += Math.pow((dice[i] - avg), 2); // calculating sigma based on the std deviation formula
        }
        return Math.sqrt(sigma / (ROLLS - 1)); // dividing sigma over the rolls and square rooting it

    }

    public static double error(double theo, double exp) { // method to calculate the %error
        return Math.abs( (theo - exp) / exp ) * 100; // the formula for calculating the %error
    }
}

