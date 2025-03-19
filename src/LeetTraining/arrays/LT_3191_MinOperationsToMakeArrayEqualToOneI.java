package LeetTraining.arrays;

import java.util.Arrays;

public class LT_3191_MinOperationsToMakeArrayEqualToOneI {
	public static int minOperations(int[] nums) {
		int operations = 0;
		for(int i = 0; i < nums.length; i++) {
			System.out.println(i + Arrays.toString(nums));
			if(nums[i] == 0) {//If we find a 0, we make a operation
				System.out.println("Modify");
				if(i < nums.length - 2) {
					nums[i] = 1 - nums[i];
					nums[i+1] = 1 - nums[i+1];
					nums[i+2] = 1 - nums[i+2];
					operations++;
				}
				else {//We stop if we can't modify 3 elements
					return -1;
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
