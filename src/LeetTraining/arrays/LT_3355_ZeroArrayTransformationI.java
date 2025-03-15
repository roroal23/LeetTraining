package LeetTraining.arrays;
import java.util.Arrays;

public class LT_3355_ZeroArrayTransformationI {
	public static boolean isZeroArray(int[] nums, int[][] queries) {
		int[] diffArr = new int[nums.length + 1];//Create a difference array
		int left;
		int right;
		int x;
		for(int i = 0; i < queries.length; i++) {//Loop through each query
			left = queries[i][0];
			right = queries[i][1];
//			x = queries[i][2];
			x = 1;//On this problem each querie decrements by 1
			diffArr[left] += x;//Update the start of the range in diffArr by adding the value
			diffArr[right + 1] -= x;//Signal that the range has ended by substracting the values in diffArr
//			System.out.println(Arrays.toString(diffArr));
		}
		//After covering all queries, we make a prefix sum to compute what the real updates to the values will be
		//We must loop through the array calculating y(i) = y(i-1) + x(i)
		for(int i = 1; i < diffArr.length; i++) {
			diffArr[i] = diffArr[i-1] + diffArr[i];	
		}
		//We verify the condition for this problem: nums can be tranformed on a Zero Array after processing all queries
		//Meaning that after applying all the queries, all values in nums must be zero (or less than zero if not all queries
		//are necessarry to get that value to zero). So for each element in nums, nums[i], we must check that:
		//nums[i] - diffArr[i] <= 0
		boolean allZeroOrLess = true;
		int i = 0;
		while(i < nums.length && allZeroOrLess) {
			if(nums[i] - diffArr[i] > 0)//We stop if we find one value that is greater than 0
				allZeroOrLess = false;
			i++;
		}
		
		
//		System.out.println(Arrays.toString(diffArr));
        return allZeroOrLess;
    }
	
	//This can be further optimized if we calculate the prefix sum and check for the condition on the same loop
	//We would stop computing the sum if one value doesnt satisfy the condition, potentially reducing some iterations
	
	public static boolean isZeroArrayOptimized(int[] nums, int[][] queries) {
		int[] diffArr = new int[nums.length + 1];//Create a difference array
		for(int i = 0; i < queries.length; i++) {//Loop through each query
			diffArr[queries[i][0]] += 1;//Update the start of the range in diffArr by adding the value
			diffArr[queries[i][1] + 1] -= 1;//Signal that the range has ended by substracting the values in diffArr
		}
		System.out.println(Arrays.toString(diffArr));
		//After covering all queries, we make a prefix sum to compute what the real updates to the values will be
		//At the same time we check the condition: nums[i] - diffArr[i] <= 0
		//We check the condition on 0 outside the loop, since the loop must at start at 1, due to the prefix sum
		//Since the last value of diffArr after prefix sum will always be 0, we skip it (we stop at nums.length = diffArr.length - 1)
		boolean allZeroOrLess = nums[0] - diffArr[0] <= 0;
		int i = 1;
		while(i < nums.length && allZeroOrLess) {//We stop if we find one value that is more than 0
//			System.out.println(i + ": " + Arrays.toString(diffArr));
			diffArr[i] = diffArr[i-1] + diffArr[i];//Prefix sum
			if(nums[i] - diffArr[i] > 0)//Check condition
				allZeroOrLess = false;//Stop loop
			i++;
		}

        return allZeroOrLess;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,0,1};
		int[][] queries = {{0,2}};
		System.out.println(isZeroArrayOptimized(nums, queries));
	}
}
