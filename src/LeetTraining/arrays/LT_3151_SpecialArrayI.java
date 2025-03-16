package LeetTraining.arrays;

public class LT_3151_SpecialArrayI {

	/**
	 * An array is considered special if the parity of every pair of adjacent elements is different. In other
	 * words, one element in each pair must be even, and the other must be odd.
	 * @param nums You are given an array of integers nums. 
	 * @return	Return true if nums is a special array, otherwise, return false.
	 */
	public static boolean isArraySpecial(int[] nums) {
		//Since non-adjacent elements must have the same parity we check if the elements in odd position and even
		//position have the same parity. We make 2 loops, so potentially we would loop through half the elements
		//if one of the evens has a different parity from its peers.
		
		boolean sameParity = true;//We stop if one element has a different parity from its peers (odd/even positions)
		int parityOfEvenPos = nums[0] % 2;//Parity that even position should have
		for(int i = 0; i < nums.length && sameParity; i += 2)//Loop for even positision
			sameParity = (nums[i] % 2) == parityOfEvenPos;
		for(int i = 1; i < nums.length && sameParity; i += 2)//Loop for odd position
			sameParity = ((nums[i] + 1) % 2) == parityOfEvenPos;
		return sameParity;
	}
}
