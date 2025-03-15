package LeetTraining.binarySearch;

public class LT_2226_MaximumCandiesAllocatedToKChildren {

	/*You are given a 0-indexed integer array candies. Each element in the array denotes a
	 * pile of candies of size candies[i]. You can divide each pile into any number of sub 
	 * piles, but you cannot merge two piles together.
	 * You are also given an integer k. You should allocate piles of candies to k children 
	 * such that each child gets the same number of candies. Each child can be allocated 
	 * candies from only one pile of candies and some piles of candies may go unused.
	 * Return the maximum number of candies each child can get.
	 */
	public static int maximumCandies(int[] candies, long k) {
		//We use a binary search, to get the maximum number of candies
		int left = 1; //We start at 1 
		int right = getMaxPile(candies);//We end at the max pile size
		int maxCandies = 0;
		while(left <= right) {
        	System.out.println("Left: " + left + "right: " + right );
        	int mid = left + (right - left) / 2;
        	System.out.println("Prueba: " + mid);
        	boolean canAllocate = canAllocateCandy(candies, mid, k);
        	System.out.println(canAllocate);
        	if(canAllocate){//If we can allocate, we save it and try with a greater k
        		maxCandies = mid;
        		left = mid + 1;
        	}
        	else {//If we can't allocate, we try with a lower k
        		right = mid - 1;
        	}
        }
		return maxCandies;
	}
	
	private static boolean canAllocateCandy(int[] candies, int pileSize, long k) {
		long piles = 0;//piles of size PileSize (kids that recieve candy)
		int i = 0;
		//For each pile in candies, we try to get divide it into x piles of size PileSize
		//x = candies[i] // pileSize
		while(i < candies.length && piles < k) {//We stop if all kids recieve candy or there are no piles left
			if(candies[i] >= pileSize)
				piles += candies[i] / pileSize;
			i++;
		}
		return piles >= k;
	}

	public static int getMaxPile(int[] candies) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < candies.length; i++) {
			max = Math.max(max, candies[i]);
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//candies = [5,8,6], k = 3, 5
		//candies = [2,5], k = 11, 0
//		int[] candies = {5,8,6};
//		int k = 3;
		int[] candies = {2,5};
		int k = 11;
		System.out.println(maximumCandies(candies, k));
		
		
	}

}


