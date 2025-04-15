package LeetTraining.binarySearch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LT_35_SearchInsertPosition_Test {
	
	@Test
	void testTargetShouldBeAtBeggining() {
        int[] nums = {1, 3, 5, 7, 9};
        int target = 0;
        assertEquals(0, LT_35_SearchInsertPosition.searchInsert(nums, target), "El  0 se debe insertar en el indice 0");
    }
	
	@Test
	void testTargetShouldBeAt2ndPosition() {
        int[] nums = {1,3,5,6};
        int target = 2;
        assertEquals(1, LT_35_SearchInsertPosition.searchInsert(nums, target),"El 2 se debe inserta en el indice 1");
    }
	
}
