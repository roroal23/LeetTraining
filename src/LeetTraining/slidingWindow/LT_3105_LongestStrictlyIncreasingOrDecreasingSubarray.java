package LeetTraining.slidingWindow;

public class LT_3105_LongestStrictlyIncreasingOrDecreasingSubarray {
	
	/*15-3: IMPROVEMENTS over sliding window
	 * Remove left since it is not used in any part of the code, just set the value
	 * Unify both loops
	 */
	
	/**You are given an array of integers nums. Return the length of the longest subarray of nums which is
	 *  either strictly increasing or strictly decreasing.
	 * @param nums
	 * @return
	 */
	public int longestMonotonicSubarray(int[] nums) {
		int max = 1;
		int incLength = 1;
		int decLength = 1;
		for(int right = 1; right < nums.length; right++) {
			if(nums[right - 1] < nums[right]){//If its strictly increasing, increase subarray length
				incLength++;
				decLength = 1;//Restart his opposite counter
			}
			else if(nums[right - 1] > nums[right]){//If its strictly decrasing, increase subarray length
				decLength++;
				incLength = 1;//Restart his opposite counter
			}
			else { //If it the same, restart both length counters
				incLength = 1;
				decLength = 1;
			}
			max = Math.max(max, incLength);
			max = Math.max(max, decLength);
		}
		return max;
	}
	
	
	
	//12-3: POTENTIAL SLIDING WINDOW
	//13-3: Done
//	public int longestMonotonicSubarray(int[] nums) {
//		//We look for each of their length using a sliding window
//		int incLength = longestIncreasingSubarray(nums);
//		int decLength = longestDecreasingSubarray(nums);
//		return Math.max(incLength, decLength);
//	}
//	
//	//We look for the length of strictly INCREASING subarray
//	private int longestIncreasingSubarray(int[] nums) {
//		int max = 1;
//		int incLength = 1;
//		int left = 0;
//		for(int right = 1; right < nums.length; right++) {
//			if(nums[right - 1] < nums[right])//If its strictly increasing, increase subarray length
//				incLength++;
//			else {//If its not strictly increasing, move the left and restart the length counter
//				left = right;
//				incLength = 1;
//			}
//			max = Math.max(max, incLength);
//		}
//		return max;
//	}
//	
//	//We look for the length of strictly DECREASING subarray
//	private int longestDecreasingSubarray(int[] nums) {
//		int max = 1;
//		int decLength = 1;
//		int left = 0;
//		for(int right = 1; right < nums.length; right++) {
//			if(nums[right - 1] > nums[right])//If its strictly decrasing, increase subarray length
//				decLength++;
//			else {//If its not strictly decreasing, move the left and restart the length counter
//				left = right;
//				decLength = 1;
//			}
//			max = Math.max(max, decLength);
//		}
//		return max;
//	}
	
	
//	public int longestMonotonicSubarray(int[] nums) {
//        int max = 0;
//        int longitud;
//        int j;
//        for(int i = 0; i < nums.length; i++){
//            j = i + 1;
//            longitud = 1;
//            boolean crec = true;
//            boolean dec = true;
//            while((crec || dec) && j < nums.length){
//                crec = crec && nums[j - 1] < nums[j];
//                dec = dec && nums[j - 1] > nums[j];
//                j++;
//                if(crec || dec)
//                    longitud++;
//            }
//            if(longitud > max)
//                max = longitud;
//        }
//
//        return max;
//    }
}
