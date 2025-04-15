package LeetTraining.binarySearch;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LT_1351_CountNegativeNumberInSortedMatrix_Test {

	@Test
	void test() {
        int[][] grid = {{4,3,2,1},
        				{3,2,1,-1},
        				{1,1,-1,-2},
        				{-1,-1,-2,-3}};
        assertEquals(7, LT_1351_CountNegativeNumberInSortedMatrix.countNegatives(grid), "");
    }
	
	@Test
	void testBS() {
        int[][] grid = {{4,3,2,1},
        				{3,2,1,-1},
        				{1,1,-1,-2},
        				{-1,-1,-2,-3}};
        assertEquals(7, LT_1351_CountNegativeNumberInSortedMatrix.countNegativesBS(grid), "");
    }
	
	
}
