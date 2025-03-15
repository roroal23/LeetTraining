package LeetTraining.dynamicProgramming;
import java.util.*;

public class LT_873_LengthOfLongestFibonacciSubsequence {
	public int lenLongestFibSubseq(int[] arr) {
		int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        // Mapear cada número a su índice
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int prev = arr[i] - arr[j]; 
                
                if (prev < arr[j] && indexMap.containsKey(prev)) {
                    int k = indexMap.get(prev);
                    int len = dp.getOrDefault(k * n + j, 2) + 1; 
                    dp.put(j * n + i, len);
                    maxLen = Math.max(maxLen, len);
                } else {
                    dp.put(j * n + i, 2);
                }
            }
        }

        return maxLen >= 3 ? maxLen : 0;
	}
}
