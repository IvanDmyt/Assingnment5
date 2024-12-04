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


import java.io.*;
import java.util.*;
import java.util.stream.*;

public class TwoDimRaggedArrayUtility {

    // Reads a ragged array from a file
    public static double[][] readFile(File file) throws IOException {
        List<double[]> rows = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" ");
                double[] row = Arrays.stream(line)
                                     .mapToDouble(Double::parseDouble)
                                     .toArray();
                rows.add(row);
            }
        }
        return rows.toArray(new double[0][]);
    }

    // Writes a ragged array to a file
    public static void writeToFile(double[][] data, File file) throws IOException {
        try (PrintWriter writer = new PrintWriter(file)) {
            for (double[] row : data) {
                writer.println(Arrays.stream(row)
                                     .mapToObj(Double::toString)
                                     .collect(Collectors.joining(" ")));
            }
        }
    }

    // Calculates the total of all elements in the ragged array
    public static double getTotal(double[][] data) {
        return Arrays.stream(data)
                     .flatMapToDouble(Arrays::stream)
                     .sum();
    }

    // Calculates the average of all elements in the ragged array
    public static double getAverage(double[][] data) {
        double total = getTotal(data);
        long count = Arrays.stream(data)
                           .mapToLong(row -> row.length)
                           .sum();
        return total / count;
    }

    // Calculates the total of a specified row
    public static double getRowTotal(double[][] data, int rowIndex) {
        return Arrays.stream(data[rowIndex]).sum();
    }

    // Calculates the total of a specified column
    public static double getColumnTotal(double[][] data, int colIndex) {
        return Arrays.stream(data)
                     .filter(row -> colIndex < row.length)
                     .mapToDouble(row -> row[colIndex])
                     .sum();
    }

    // Gets the highest value in a specified row
    public static double getHighestInRow(double[][] data, int rowIndex) {
        return Arrays.stream(data[rowIndex]).max().orElse(Double.NaN);
    }

    // Gets the index of the highest value in a specified row
    public static int getHighestInRowIndex(double[][] data, int rowIndex) {
        double max = getHighestInRow(data, rowIndex);
        for (int i = 0; i < data[rowIndex].length; i++) {
            if (data[rowIndex][i] == max) {
                return i;
            }
        }
        return -1; // Should not happen if data is valid
    }

    // Gets the lowest value in a specified row
    public static double getLowestInRow(double[][] data, int rowIndex) {
        return Arrays.stream(data[rowIndex]).min().orElse(Double.NaN);
    }

    // Gets the index of the lowest value in a specified row
    public static int getLowestInRowIndex(double[][] data, int rowIndex) {
        double min = getLowestInRow(data, rowIndex);
        for (int i = 0; i < data[rowIndex].length; i++) {
            if (data[rowIndex][i] == min) {
                return i;
            }
        }
        return -1; // Should not happen if data is valid
    }

    // Gets the highest value in a specified column
    public static double getHighestInColumn(double[][] data, int colIndex) {
        return Arrays.stream(data)
                     .filter(row -> colIndex < row.length)
                     .mapToDouble(row -> row[colIndex])
                     .max()
                     .orElse(Double.NaN);
    }

    // Gets the index of the highest value in a specified column
    public static int getHighestInColumnIndex(double[][] data, int colIndex) {
        double max = getHighestInColumn(data, colIndex);
        for (int i = 0; i < data.length; i++) {
            if (colIndex < data[i].length && data[i][colIndex] == max) {
                return i;
            }
        }
        return -1; // Should not happen if data is valid
    }

    // Gets the lowest value in a specified column
    public static double getLowestInColumn(double[][] data, int colIndex) {
        return Arrays.stream(data)
                     .filter(row -> colIndex < row.length)
                     .mapToDouble(row -> row[colIndex])
                     .min()
                     .orElse(Double.NaN);
    }

    // Gets the index of the lowest value in a specified column
    public static int getLowestInColumnIndex(double[][] data, int colIndex) {
        double min = getLowestInColumn(data, colIndex);
        for (int i = 0; i < data.length; i++) {
            if (colIndex < data[i].length && data[i][colIndex] == min) {
                return i;
            }
        }
        return -1; // Should not happen if data is valid
    }

    // Gets the highest value in the entire array
    public static double getHighestInArray(double[][] data) {
        return Arrays.stream(data)
                     .flatMapToDouble(Arrays::stream)
                     .max()
                     .orElse(Double.NaN);
    }

    // Gets the lowest value in the entire array
    public static double getLowestInArray(double[][] data) {
        return Arrays.stream(data)
                     .flatMapToDouble(Arrays::stream)
                     .min()
                     .orElse(Double.NaN);
    }
}
