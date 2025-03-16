package LeetTraining.binarySearch;

import java.util.Arrays;

public class LT_3356_ZeroArrayTransformationII {
	//Based on LT 3355
	
	/*
	 * We need to find the minimum k queries to let nums become a zero Array
	 * In LT 3355 we found an algorithm that finds if n queries create a zero array in o(n)
	 * If we try each query incrementally the complexity would increase since we would need to compute
	 * the prefix sum on each iteration (which is the linear part about the algorithm) and we would lose
	 * the benefits of the prefix sum approach, simulating each query would be as efficient as this.
	 * We try using a binary search to find the k first queries, potentially leading to O(nlogn) complexity
	 */
	
	public static int minZeroArray(int[] nums, int[][] queries) {
		
        int left = 0;
        int right = queries.length;
        int minimumQueries = -1;
        while(left <= right) {
        	System.out.println("Left: " + left + "right: " + right );
        	int mid = left + (right - left) / 2;
        	boolean isZeroArray = isZeroArrayWithKQueries(nums, queries, mid);
        	if(isZeroArray){//If it is a Zero Array, we try with a lower k
        		minimumQueries = mid;
        		right = mid - 1;
        	}
        	else //If it is not a Zero Array, we try with a greater k
        		left = mid + 1;
        }
        return minimumQueries;
    }
	
	private static boolean isZeroArrayWithKQueries(int[] nums, int[][] queries, int k) {
		System.out.println("Evaluando: " + k);
		int[] diffArr = new int[nums.length + 1];//Create a difference array
		for(int i = 0; i < k; i++) {//Loop through the first k queries
			diffArr[queries[i][0]] += queries[i][2];//Update the start of the range
			diffArr[queries[i][1] + 1] -= queries[i][2];//Signal the range has ended
		}
		//We compute the prefixSum and we check the condition at the same time
		System.out.println("diffArr:" + Arrays.toString(diffArr));
		boolean allZeroOrLess = nums[0] - diffArr[0] <= 0;
		int i = 1;
		while(i < nums.length && allZeroOrLess) {//We stop if we find one value that is more than 0
			diffArr[i] = diffArr[i-1] + diffArr[i];//Prefix sum
			if(nums[i] - diffArr[i] > 0)//Check condition
				allZeroOrLess = false;//Stop loop
			i++;
		}
        return allZeroOrLess;
    }
	
	public static void main(String[] args) {
		int[] nums = {4, 3, 2, 1};
        int[][] queries = {{1, 3, 2}, {0, 2, 1}};
//		int[] nums = {2, 0, 2};
//        int[][] queries = {{0, 2, 1}, {0, 2, 1}, {1, 1, 3}};
//		int[] nums = {5};
//		int[][] queries = {{0, 0, 5}, {0, 0, 1}, {0, 0, 3}, {0, 0, 2}};
//		int[] nums = {7, 6, 8};
//		int[][] queries = {{0, 0, 2}, {0, 1, 5}, {2, 2, 5}, {0, 2, 4}};
        System.out.println(minZeroArray(nums, queries));
		
	}
}
