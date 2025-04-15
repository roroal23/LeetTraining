package LeetTraining.binarySearch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LT_704_BinarySearch_Test {
	@Test
	void testTargetAtStart() {
        int[] nums = {1, 3, 5, 7, 9};
        int target = 1;
        assertEquals(0, LT_704_BinarySearch.search(nums, target), "El índice del número 1 debe ser 0");
    }
	@Test
	void testTargetAtMiddle() {
        int[] nums = {1, 3, 5, 7, 9};
        int target = 5;
        assertEquals(2, LT_704_BinarySearch.search(nums, target), "El índice del número 1 debe ser 0");
    }
	
	@Test
	void testTargetAtEnd() {
        int[] nums = {1, 3, 5, 7, 9};
        int target = 9;
        assertEquals(4, LT_704_BinarySearch.search(nums, target), "El índice del número 1 debe ser 0");
    }
}
