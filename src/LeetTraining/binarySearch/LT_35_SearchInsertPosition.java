package LeetTraining.binarySearch;

import java.util.Arrays;

public class LT_35_SearchInsertPosition {
	/*
	 * Given a sorted array of distinct integers and a target value, return the index if the target is found. 
	 * If not, return the index where it would be if it were inserted in order.
	 * You must write an algorithm with O(log n) runtime complexity.
	 */
	public static int searchInsert(int[] nums, int target) {
		System.out.println(Arrays.toString(nums) + " " + target);
		int left = 0;
		int right = nums.length - 1;
		int mid;
		while(left <= right) {
			System.out.println("left" + left + "right" + right);
			mid = left + (right - left)/2;
			if(nums[mid] == target)
				return mid;
			else if(nums[mid] < target)//If the value is less than target, continue to the right
				left = mid + 1;
			else//If the value is more than target, continue to the left
				right = mid - 1;	
			
		}
		return left;
    }
}
