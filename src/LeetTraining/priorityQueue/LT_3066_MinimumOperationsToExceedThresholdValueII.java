package LeetTraining.priorityQueue;

import java.util.PriorityQueue;

public class LT_3066_MinimumOperationsToExceedThresholdValueII {
	 public int minOperations(int[] nums, int k) {
	        PriorityQueue<Long> queue = new PriorityQueue<>();
	        for(int i = 0; i < nums.length; i++){
	            queue.add((long) nums[i]);
	        }
	        int n = 0;
	        while(queue.peek() < k && queue.size() >= 2){
	            long x = queue.poll(); //Menor1
	            long y = queue.poll(); //Menor 2
	            queue.add(x*2 + y);
	            n++;
	        }
	        return n;
	    }
}
