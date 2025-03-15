package LeetTraining.dynamicProgramming;

public class LT_1749_MaximumAbsoluteSumOfAnySubarray {
	public int maxAbsoluteSum(int[] nums) {
        int maxEnding = 0;
        int maxSum = 0;
        int minEnding = 0;
        int minSum = 0;

        for(int i = 0; i < nums.length; i++){
            maxEnding = Math.max(0, maxEnding + nums[i]);
            minEnding = Math.min(0, minEnding + nums[i]);
            maxSum = Math.max(maxSum, maxEnding);
            minSum = Math.min(minSum, minEnding);
        }
        return Math.max(maxSum, -minSum);
    }
}
