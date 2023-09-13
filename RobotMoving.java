import java.util.Scanner;

// SARA ANGELINA RAHIM
// R00211761

public class RobotMoving { // class RobotMoving
    public static void main(String[] args) { // main method
        Scanner scanner = new Scanner(System.in); // scanner object that takes in user input

        System.out.print("Enter number of rows in the matrix: "); // user input to get number of rows in matrix
        int ROWS = scanner.nextInt(); // store user input in variable ROWS

        // cost of movement for cost1 and cost2
        double cost1_right = 1.1;
        double cost1_down = 1.3;
        double cost1_diagonal = 2.5;

        double cost2_right = 1.5;
        double cost2_down = 1.2;
        double cost2_diagonal = 2.3;

        double[][] cost1 = new double[ROWS][ROWS]; // 2D array of cost1
        cost1[0][0] = 0; // set cost1[0][0] to 0

        for (int i = 1; i < ROWS; i++) { // for loop to iterate through each row
            cost1[i][0] = cost1[i - 1][0] + cost1_down; // calculate cost1[i][0]
        }
        for (int j = 1; j < ROWS; j++) { // for loop to iterate through each row
            cost1[0][j] = cost1[0][j - 1] + cost1_right; // calculate cost1[0][j]
        }
        for (int i = 1; i < ROWS; i++) { // for loop to iterate through each row
            for (int j = 1; j < ROWS; j++) { // for loop to iterate through each row

                double cost_right = cost1[i][j - 1] + cost1_right; // calculate cost_right
                double cost_down = cost1[i - 1][j] + cost1_down; // calculate cost_down
                double cost_diagonal = cost1[i - 1][j - 1] + cost1_diagonal; // calculate cost_diagonal
                cost1[i][j] = Math.min(Math.min(cost_right, cost_down), cost_diagonal); // calculate cost1[i][j]
            }
        }
        System.out.printf("The minimum cost of Cost1 is: %.2f%n", cost1[ROWS - 1][ROWS - 1]); // print out minimum cost of cost1

        double[][] cost2 = new double[ROWS][ROWS]; // 2D array of cost2
        cost2[0][0] = 0; // set cost2[0][0] to 0
        for (int i = 1; i < ROWS; i++) { // for loop to iterate through each row
            cost2[i][0] = cost2[i - 1][0] + cost2_down; // calculate cost2[i][0]
        }
        for (int j = 1; j < ROWS; j++) {  // for loop to iterate through each row
            cost2[0][j] = cost2[0][j - 1] + cost2_right; // calculate cost2[0][j]
        }
        for (int i = 1; i < ROWS; i++) { // for loop to iterate through each row
            for (int j = 1; j < ROWS; j++) { // for loop to iterate through each row

                double cost_right = cost2[i][j - 1] + cost2_right; // calculate cost_right
                double cost_down = cost2[i - 1][j] + cost2_down; // calculate cost_down
                double cost_diagonal = cost2[i - 1][j - 1] + cost2_diagonal; // calculate cost_diagonal
                cost2[i][j] = Math.min(Math.min(cost_right, cost_down), cost_diagonal); // calculate cost2[i][j]
            }
        }
        System.out.printf("The minimum cost of Cost2 is: %.2f%n", cost2[ROWS - 1][ROWS - 1]); // print out minimum cost of cost2

        StringBuilder robotMovements = new StringBuilder("The movement of the robot with Cost1 is:\n"); // string builder to store robot movements
        int row = ROWS - 1, col = ROWS - 1; // set row and col to ROWS - 1

        while (row > 0 && col > 0) { // while loop to iterate through each row and col

            double cost_right = cost1[row][col - 1] + cost1_right; // calculate cost_right
            double cost_down = cost1[row - 1][col] + cost1_down; // calculate cost_down

            if (cost_right < cost_down) { // if statement to check if cost_right is less than cost_down
                robotMovements.append("RIGHT "); // append RIGHT to robotMovements
                col--; // decrement col
            } else { // else
                robotMovements.append("DOWN "); // append DOWN to robotMovements
                row--; // decrement row
            }
        }

        while (row > 0) { // while loop to iterate through each row
            if (row == 0) { // if statement to check if row is equal to 0
                robotMovements.append("RIGHT "); // append RIGHT to robotMovements
                col--; // decrement col
            } else { // else
                robotMovements.append("DOWN "); // append DOWN to robotMovements
                row--; // decrement row
            }
        }

        robotMovements.append("\nThe movement of the robot with Cost2 is:\n"); // append string to robotMovements
        int row2 = ROWS - 1, col2 = ROWS - 1; // set i2 and j2 to ROWS - 1

        while (row2 > 0 && col2 > 0) { // while loop to iterate through each row and col
            double cost_right = cost2[row2][col2 - 1] + cost2_right; // calculate cost_right
            double cost_down = cost2[row2 - 1][col2] + cost2_down; // calculate cost_down
            double cost_diagonal = cost2[row2 - 1][col2 - 1] + cost2_diagonal; // calculate cost_diagonal

            if (cost_diagonal <= cost_right && cost_diagonal <= cost_down) { // if statement to check if cost_diagonal is less than or equal to cost_right and cost_down
                robotMovements.append("DIAGONAL "); // append DIAGONAL to robotMovements
                row2--; // decrement i2
                col2--; // decrement j2
            } else if (cost_right < cost_down) { // else if statement to check if cost_right is less than cost_down
                robotMovements.append("RIGHT "); // append RIGHT to robotMovements
                col2--; // decrement j2
            } else { // else
                robotMovements.append("DOWN "); // append DOWN to robotMovements
                row2--; // decrement i2
            }
        }

        System.out.println(robotMovements); // print out movements of robot
    }
}
