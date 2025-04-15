package LeetTraining.binarySearch;

public class LT_704_BinarySearch {
	
	/*	Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to 
	 * search target in nums. If target exists, then return its index. Otherwise, return -1.
	 * You must write an algorithm with O(log n) runtime complexity. 
	 */
	public static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int mid;
		while(left <= right) {
			mid = left + (right - left)/2;
			if(nums[mid] == target)
				return mid;
			else if(nums[mid] < target)//If the value is less than target, continue to the right
				left = mid + 1;
			else//If the value is more than target, continue to the left
				right = mid - 1;		
		}
		return -1;//If the target is not found return -1
    }
}
