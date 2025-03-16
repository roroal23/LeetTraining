package LeetTraining.binarySearch;

public class LT_2594_MinimumTimeToRepairCars {

	//The minimum time (ideally) would be to have a 1 rank mechanic repair 1 car: 1
	//The maximum time needed to repair the cars will be if the highest ranked mechanic repairs
	//all the cars by himself: rank * cars^2
	
	public static long repairCars(int[] ranks, int cars) {
        int highestRank = 1;
        for(int i = 0; i < ranks.length; i++) {//We look for the mechanic with highest rank
        	highestRank = Math.max(highestRank, ranks[i]);
        }
        //We will make a binary search ranging from 1 to maxRank * cars^2
        long left = 1;
        long right = (long) highestRank*cars*cars;
        long minTime = right;
        while(left <= right) {
        	long mid = left + (right - left) / 2;
        	boolean canRepair = repairCarsInTime(ranks, cars, mid);
        	if(canRepair) {//If they can repair, we save it and try with smaller time
        		minTime = mid;
        		right = mid - 1;
        	}
        	else {//If the can't repair then in time, we try with a longer time
        		left = mid + 1;
        	}
        }
		return minTime;
    }
	
	//We check if the cars can be repaired by all the mechanics simultaneously in less than or in maxTime
	private static boolean repairCarsInTime(int[] ranks, int cars, long maxTime) {
		long repaired = 0;
		for(int i = 0; i < ranks.length && repaired < cars; i++) {//For each mechanic
			repaired += (long)Math.sqrt(maxTime/ranks[i]);//We add as many cars as they can repair in maxTime
		}
		return repaired >= cars;
	}
	
	public static void main(String[] args) {
		int[] ranks = {4,2,3,1};
		int cars = 10;
		System.out.println(repairCars(ranks, cars));
	}
}
