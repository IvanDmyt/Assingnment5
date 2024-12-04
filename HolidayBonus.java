/*
 * Class: CMSC203 
 * Instructor:Professor Monshi
 * Description: Computer Science class where we study object oriented design using Java programming language
 * Due: 12/03/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Ivan Sergiyovych Dmytriiev
*/


import java.util.Arrays;

public class HolidayBonus {
    private static final double HIGHEST_BONUS = 5000.0;
    private static final double LOWEST_BONUS = 1000.0;
    private static final double OTHER_BONUS = 2000.0;

    public static double[] calculateHolidayBonus(double[][] sales) {
        double[] bonuses = new double[sales.length];
        for (int col = 0; col < getMaxColumns(sales); col++) {
            int highestIndex = -1;
            int lowestIndex = -1;
            double highest = Double.NEGATIVE_INFINITY;
            double lowest = Double.POSITIVE_INFINITY;

            // Find highest and lowest in the column
            for (int row = 0; row < sales.length; row++) {
                if (col < sales[row].length && sales[row][col] > 0) {
                    if (sales[row][col] > highest) {
                        highest = sales[row][col];
                        highestIndex = row;
                    }
                    if (sales[row][col] < lowest) {
                        lowest = sales[row][col];
                        lowestIndex = row;
                    }
                }
            }

            // Assign bonuses
            for (int row = 0; row < sales.length; row++) {
                if (col < sales[row].length && sales[row][col] > 0) {
                    if (row == highestIndex) bonuses[row] += HIGHEST_BONUS;
                    else if (row == lowestIndex) bonuses[row] += LOWEST_BONUS;
                    else bonuses[row] += OTHER_BONUS;
                }
            }
        }
        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] sales) {
        double[] bonuses = calculateHolidayBonus(sales);
        return Arrays.stream(bonuses).sum();
    }

    private static int getMaxColumns(double[][] sales) {
        return Arrays.stream(sales)
                     .mapToInt(row -> row.length)
                     .max()
                     .orElse(0);
    }
}
