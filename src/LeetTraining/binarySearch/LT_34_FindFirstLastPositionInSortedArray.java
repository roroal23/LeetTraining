package LeetTraining.binarySearch;

public class LT_34_FindFirstLastPositionInSortedArray {
	/*
	 * Given an array of integers nums sorted in non-decreasing order, 
	 * find the starting and ending position of a given target value.
	 * If target is not found in the array, return [-1, -1].
	 * You must write an algorithm with O(log n) runtime complexity
	 */
	public static int[] searchRange(int[] nums, int target) {
        /*My idea is to make 2 binary searches, on each search instead of stopping when a target is found, we save it
         * and continue to the left/right respectively, the loop will end due to left > right, and we will have the
         * leftmost/rightmost element saved
         */
		int left = 0;
		int right = nums.length - 1;
		int mid;
		int leftmost = -1;
		while(left <= right) {
			mid = left + (right - left)/2;
			if(nums[mid] == target)
				leftmost = mid;
			if(nums[mid] >= target)//If the number is more than/equal to the target, move to the left
				right = mid - 1;				
			else 
				left = mid + 1;
		}
		left = 0;
		right = nums.length - 1;
		int rightmost = -1;
		while(left <= right) {
			mid = left + (right - left)/2;
			if(nums[mid] == target)
				rightmost = mid;
			if(nums[mid] > target)//If the number is more than the target, move to the left
				right = mid - 1;				
			else //If the number is less than/equal to the target, move to the right
				left = mid + 1;
		}
		return new int[]{leftmost, rightmost};
    }
}
