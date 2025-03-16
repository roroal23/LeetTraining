package LeetTraining.arrays;

public class LT_1800_MaximumAscendingSubarraySum {
	
	//16-3: Solution based on sliding window
	/**Given an array of positive integers nums, return the maximum possible sum of an strictly
	 * increasing subaaray in nums.
	 * @param nums
	 * @return
	 */
	public int maxAscendingSum(int[] nums) {
		int currentSum = nums[0];
		int maxSum = currentSum;
		for(int right = 1; right < nums.length; right++) {
			if(nums[right - 1] < nums[right]) //If its strictly increasing we add the element to the sum
				currentSum += nums[right];
			else {//If its not, we restart the counter and move right one position, 'removing' the last subarray
				currentSum = nums[right];
			}
			maxSum = Math.max(maxSum, currentSum);
		}
		return maxSum;
	}
	
//	public int maxAscendingSum(int[] nums) {
//        int max = 0;
//        int suma;
//        int j;
//        boolean crec;
//        for(int i = 0; i < nums.length; i++){
//            suma = nums[i];
//            j = i + 1;
//            crec = true;
//            while(crec && j < nums.length){
//                crec = crec && nums[j - 1] < nums[j];
//                if(crec)
//                    suma += nums[j];
//                j++;
//            }
//            if(suma > max)
//                max = suma;
//        }
//
//        return max;
//    }
}
