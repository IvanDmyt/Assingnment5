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

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class HolidayBonusTestStudent {

    @Test
    void testCalculateHolidayBonus() {
        double[][] sales = {
            {1000, 2000, 3000},   // Row 0
            {4000, 500, 0},       // Row 1
            {600, 1500, 2500}     // Row 2
        };

        double[] expectedBonuses = {12000.0, 6000.0, 4000.0}; // Expected bonuses
        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(sales);

        // Test each bonus
        for (int i = 0; i < expectedBonuses.length; i++) {
            assertEquals(expectedBonuses[i], actualBonuses[i], 0.001, 
                "Bonus calculation failed for row " + i);
        }
    }

    @Test
    void testCalculateTotalHolidayBonus() {
        double[][] sales = {
            {1000, 2000, 3000},   // Row 0
            {4000, 500, 0},       // Row 1
            {600, 1500, 2500}     // Row 2
        };

        double expectedTotal = 22000.0; // Expected total bonuses
        double actualTotal = HolidayBonus.calculateTotalHolidayBonus(sales);

        assertEquals(expectedTotal, actualTotal, 0.001, 
            "Total bonus calculation failed");
    }

    @Test
    void testCalculateHolidayBonusWithEmptySales() {
        double[][] sales = {}; // No sales data
        double[] expectedBonuses = {};
        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(sales);

        assertEquals(expectedBonuses.length, actualBonuses.length, 
            "Empty sales should result in no bonuses.");
    }

    @Test
    void testCalculateTotalHolidayBonusWithEmptySales() {
        double[][] sales = {}; // No sales data
        double expectedTotal = 0.0;
        double actualTotal = HolidayBonus.calculateTotalHolidayBonus(sales);

        assertEquals(expectedTotal, actualTotal, 0.001, 
            "Empty sales should result in a total bonus of 0.");
    }
}
