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

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class TwoDimRaggedArrayUtilityTestStudent {

    private final double[][] data = {
        {1.5, 2.0, 3.0},
        {4.0, 5.5},
        {6.0, 7.0, 8.5, 9.0}
    };

    @Test
    void testReadFile() throws IOException {
        File inputFile = new File("testInput.txt");
        TwoDimRaggedArrayUtility.writeToFile(data, inputFile);
        double[][] readData = TwoDimRaggedArrayUtility.readFile(inputFile);
        assertArrayEquals(data, readData, "Read file data does not match expected data");
    }

    @Test
    void testWriteToFile() throws IOException {
        File outputFile = new File("testOutput.txt");
        TwoDimRaggedArrayUtility.writeToFile(data, outputFile);
        double[][] readData = TwoDimRaggedArrayUtility.readFile(outputFile);
        assertArrayEquals(data, readData, "Written file data does not match input data");
    }

    @Test
    void testGetTotal() {
        double expectedTotal = 46.5;
        double actualTotal = TwoDimRaggedArrayUtility.getTotal(data);
        assertEquals(expectedTotal, actualTotal, 0.001, "Total calculation is incorrect");
    }

    @Test
    void testGetAverage() {
        double expectedAverage = 5.166666666666667; // 46.5 / 8
        double actualAverage = TwoDimRaggedArrayUtility.getAverage(data);
        assertEquals(expectedAverage, actualAverage, 0.001, "Average calculation is incorrect");
    }

    @Test
    void testGetRowTotal() {
        double expectedRowTotal = 6.5; // 1.5 + 2.0 + 3.0
        double actualRowTotal = TwoDimRaggedArrayUtility.getRowTotal(data, 0);
        assertEquals(expectedRowTotal, actualRowTotal, 0.001, "Row total calculation is incorrect");
    }

    @Test
    void testGetColumnTotal() {
        double expectedColumnTotal = 11.5; // 1.5 + 4.0 + 6.0
        double actualColumnTotal = TwoDimRaggedArrayUtility.getColumnTotal(data, 0);
        assertEquals(expectedColumnTotal, actualColumnTotal, 0.001, "Column total calculation is incorrect");
    }

    @Test
    void testGetHighestInRow() {
        double expectedHighest = 3.0;
        double actualHighest = TwoDimRaggedArrayUtility.getHighestInRow(data, 0);
        assertEquals(expectedHighest, actualHighest, 0.001, "Highest in row calculation is incorrect");
    }

    @Test
    void testGetHighestInRowIndex() {
        int expectedIndex = 2; // Index of 3.0
        int actualIndex = TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 0);
        assertEquals(expectedIndex, actualIndex, "Highest in row index calculation is incorrect");
    }

    @Test
    void testGetLowestInRow() {
        double expectedLowest = 1.5;
        double actualLowest = TwoDimRaggedArrayUtility.getLowestInRow(data, 0);
        assertEquals(expectedLowest, actualLowest, 0.001, "Lowest in row calculation is incorrect");
    }

    @Test
    void testGetLowestInRowIndex() {
        int expectedIndex = 0; // Index of 1.5
        int actualIndex = TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 0);
        assertEquals(expectedIndex, actualIndex, "Lowest in row index calculation is incorrect");
    }

    @Test
    void testGetHighestInColumn() {
        double expectedHighest = 6.0;
        double actualHighest = TwoDimRaggedArrayUtility.getHighestInColumn(data, 0);
        assertEquals(expectedHighest, actualHighest, 0.001, "Highest in column calculation is incorrect");
    }

    @Test
    void testGetHighestInColumnIndex() {
        int expectedIndex = 2; // Index of 6.0
        int actualIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 0);
        assertEquals(expectedIndex, actualIndex, "Highest in column index calculation is incorrect");
    }

    @Test
    void testGetLowestInColumn() {
        double expectedLowest = 1.5;
        double actualLowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, 0);
        assertEquals(expectedLowest, actualLowest, 0.001, "Lowest in column calculation is incorrect");
    }

    @Test
    void testGetLowestInColumnIndex() {
        int expectedIndex = 0; // Index of 1.5
        int actualIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 0);
        assertEquals(expectedIndex, actualIndex, "Lowest in column index calculation is incorrect");
    }

    @Test
    void testGetHighestInArray() {
        double expectedHighest = 9.0;
        double actualHighest = TwoDimRaggedArrayUtility.getHighestInArray(data);
        assertEquals(expectedHighest, actualHighest, 0.001, "Highest in array calculation is incorrect");
    }

    @Test
    void testGetLowestInArray() {
        double expectedLowest = 1.5;
        double actualLowest = TwoDimRaggedArrayUtility.getLowestInArray(data);
        assertEquals(expectedLowest, actualLowest, 0.001, "Lowest in array calculation is incorrect");
    }
}
