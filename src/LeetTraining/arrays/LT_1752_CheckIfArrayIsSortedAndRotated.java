package LeetTraining.arrays;

public class LT_1752_CheckIfArrayIsSortedAndRotated {
	
	
	
	/**Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated
	 *  some number of positions (including zero). Otherwise, return false. 
	 *  There may be duplicates in the original array.
	 *  Note: An array A rotated by x positions results in an array B of the same length such that
	 *   B[i] == A[(i+x) % A.length] for every valid index i.
	 * @param nums
	 * @return
	 */
	public boolean check(int[] nums) {
        int x = 0;
        boolean foundRotated = false;
        while(!foundRotated && x < nums.length) {//We loop through all possible rotations until we one that is sorted
        	foundRotated = check(nums, x);
        	x++;
        }
        return foundRotated;
    }

	//We check if the elements rotated by x positions, are sorted in non-decreasing order
    private boolean check(int[] nums, int x){
    	int n = nums.length;
        int i = 0;//The first element would be nums[i+x]
        boolean isSorted = true;
        while(isSorted && i < n - 1) {//All elements must be sorted
        	isSorted = nums[(i + x) % n] <= nums[(i + x + 1) % n];
        	i++;
        }
        return isSorted;
    }
}
