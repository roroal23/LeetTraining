package LeetTraining.binarySearch;
import java.util.*;

public class LT_436_FindCorrectInterval {
	/*
	 * You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.
	 * The right interval for an interval i is an interval j such that startj >= endi and startj is minimized. 
	 * Note that i may equal j.Return an array of right interval indices for each interval i. If no right interval 
	 * exists for interval i, then put -1 at index i.
	 */

	public static int[] findRightInterval(int[][] intervals) {
		Map<Integer, Integer> startMap = new HashMap<>();//Map for each start (said to be unique) and its position
		int[] startArr = new int[intervals.length];//Sorted array of starts
		for(int i = 0; i < intervals.length; i++) {
			int start = intervals[i][0];
			startMap.put(start, i);
			startArr[i] = start;
		}
		Arrays.sort(startArr);//Sort the arrays
		int[] correctIntervals = new int[intervals.length];
		for(int i = 0; i < intervals.length; i++) {
			int end = intervals[i][1];
			int left = 0;
			int right = startArr.length -1;
			int minStart = -1;
			boolean foundOneStart = false;
			while(left <= right) {//Make a binary search, looking for a start bigger or equal to our end
				int mid = left + (right - left) /2;
				if(startArr[mid] >= end) {//If we find a right interval, we save it and move to the left
					foundOneStart = true;
					minStart = startArr[mid];
					right = mid - 1;
				}
				else //If not found, we move to the right
					left = mid + 1;
			}
			if(foundOneStart)
				correctIntervals[i] = startMap.get(minStart);
			else 
				correctIntervals[i] = -1;
		}
		return correctIntervals;		
	}

	public static int[] findRightIntervalCuad(int[][] intervals) {
		int[] correctIntervals = new int[intervals.length];
		for(int i = 0; i < intervals.length; i++) {
			int end = intervals[i][1];
			int minStart = Integer.MAX_VALUE;
			int minPos = -1;
			for(int j = 0; j < intervals.length; j++) {
				int start = intervals[j][0];
				if(start >= end && start < minStart) {
					minStart = start;
					minPos = j;

				}
			}
			correctIntervals[i] = minPos;
		}

		return correctIntervals;
	}
}
