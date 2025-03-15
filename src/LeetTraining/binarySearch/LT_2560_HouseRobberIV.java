package LeetTraining.binarySearch;

public class LT_2560_HouseRobberIV {

	/*
	 * There are several consecutive houses along a street, each of which has some money inside. There is also 
	 * a robber, who wants to steal money from the homes, but he refuses to steal from adjacent homes.
	 * The capability of the robber is the maximum amount of money he steals from one house of all the houses 
	 * he robbed.
	 * You are given an integer array nums representing how much money is stashed in each house. More formally, 
	 * the ith house from the left has nums[i] dollars.
	 * You are also given an integer k, representing the minimum number of houses the robber will steal from. 
	 * It is always possible to steal at least k houses.
	 * Return the minimum capability of the robber out of all the possible ways to steal at least k houses.
	 */
	
	public static int minCapability(int[] nums, int k) {
        int[] minMax = getMinMax(nums);
        int left = minMax[0];
        int right = minMax[1];
        int minCapability = 0;
        while(left <= right) {
        	int mid = left + (right - left)/2;
        	boolean canSteal = canSteal(nums, k, mid);
        	if(canSteal) {//If we can steal k non-adyacent houses with that maxValue, we save it and try with a lower value
        		minCapability = mid;
        		right = mid - 1;
        	}
        	else {//If we can't steal, we try with a greater value
        		left = mid + 1;
        	}
        }
   
		return minCapability;
    }
	
	
	private static int[] getMinMax(int[] nums) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		return new int[] {min, max};
	}
	
	//Check if at least k houses, that are equal or less than maxMoney and non adyacent, can be stolen
	private static boolean canSteal(int[] nums, int k, int maxMoney) {
		int robbedHouses = 0;
		int i = 0;
		while(i < nums.length && robbedHouses < k) {
			if(nums[i] <= maxMoney) {//If theits value is less than maxMoney, we steal it
				robbedHouses++;//We add it to the accum
                i++;//We make sure there are no adyacents houses by skipping the adyacent house to the one we rob
			}
			i++;
		}
		return robbedHouses >= k;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		int k = 2;
		System.out.println(minCapability(nums, k));

	}

}
