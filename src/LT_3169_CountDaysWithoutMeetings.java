import java.util.Arrays;
import java.util.*;

public class LT_3169_CountDaysWithoutMeetings {
	
	/*
	 * You are given a positive integer days representing the total number of days
	 * an employee is available for work (starting from day 1). You are also given
	 * a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents
	 * the starting and ending days of meeting i (inclusive).
	 * Return the count of days when the employee is available for work but no meetings
	 * are scheduled.
	 * Note: The meetings may overlap.
	 */

	public static int countDays(int days, int[][] meetings) {

		TreeMap<Integer, Integer> diffMap = new TreeMap<>();//Ordered map, used for a difference array approach
		int start;
		int end;
		for(int[] meeting: meetings) {//We only add the days where a meeting starts/begins on the map
			start = meeting[0];
			end = meeting[1];
			diffMap.put(start, diffMap.getOrDefault(start, 0) + 1);//A new meeting is added
			diffMap.put(end + 1, diffMap.getOrDefault(end + 1, 0) - 1);
		}
		int prevDay = 1;
		int availableDays = 0;
		int activeMeetings = 0;
		for (Map.Entry<Integer, Integer> entry : diffMap.entrySet()) {
			int currentDay = entry.getKey();
			if (activeMeetings == 0) {//The days between prevDays and currentDay - 1 are available
				availableDays += currentDay - prevDay;
			}
			activeMeetings += entry.getValue();//We add the meetings 
			prevDay = currentDay;
		}
		if(activeMeetings == 0 && prevDay <= days)
			availableDays += days - prevDay + 1;

		return availableDays;
	}
	
	
	
//	public static int countDays(int days, int[][] meetings) {
//     
//		int[] diffArr = new int[days + 2];//We skip day 0
//		int start;
//		int end;
//		for(int[] meeting: meetings) {
//			start = meeting[0];
//			end = meeting[1];
//			diffArr[start] -= 1;
//			diffArr[end + 1] += 1;
//		}
//		System.out.println(Arrays.toString(diffArr));
//		for(int i = 2; i < diffArr.length; i++) {
//			diffArr[i] = diffArr[i-1] + diffArr[i];
//		}
//		System.out.println(Arrays.toString(diffArr));
//		int availableDays = 0;
//		for(int i = 1; i < diffArr.length - 1; i++) {
//			if(diffArr[i] >= 0)
//				availableDays++;
//		}
//		
//		return availableDays;
//    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int days = 10;
//		int[][] meetings = {{5,7},{1,3},{9,10}};
//		int days = 5;
//		int[][] meetings = {{2,4},{1,3}};
		int days = 6;
		int[][] meetings = {{1,6}};
		System.out.println(countDays(days, meetings));
	}

}
