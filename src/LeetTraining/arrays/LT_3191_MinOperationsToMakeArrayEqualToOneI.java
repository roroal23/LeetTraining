package LeetTraining.arrays;

import java.util.Arrays;

public class LT_3191_MinOperationsToMakeArrayEqualToOneI {
	public static int minOperations(int[] nums) {
		int operations = 0;
		for(int i = 0; i < nums.length; i++) {//We loop thorugh the array looking for the first 0 we can find
//			System.out.println(i + Arrays.toString(nums));
			if(nums[i] == 0) {//If we find a 0, we make a operation
				if(i <= nums.length - 3) {//There are at least 3 elements left to flip
					nums[i] = 1 - nums[i];//We flip them
					nums[i+1] = 1 - nums[i+1];
					nums[i+2] = 1 - nums[i+2];
					operations++;
				}
				else {//We stop if we can't flip 3 elements
					return -1;//It is impossible to make the array equal to one
				}
			}
		}
		return operations;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,1,1,1,0,0};
		System.out.println(minOperations(nums));
	}
}
