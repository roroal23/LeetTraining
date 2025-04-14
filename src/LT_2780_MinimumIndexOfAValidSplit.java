
import java.util.*;

public class LT_2780_MinimumIndexOfAValidSplit {
	
	public static int minimumIndex(List<Integer> nums) {
		Map<Integer, Integer> frecuencies = new HashMap<>();
		for(int number: nums) {
			frecuencies.put(number, frecuencies.getOrDefault(number, 0) + 1);
		}
		int dominantNumber = -1;//It is garanteed that there is a dominant number
		int maxFrec = 0;
		for(Map.Entry<Integer, Integer> entry: frecuencies.entrySet()) {
			int frec = entry.getValue();
			if(frec > maxFrec) {
				dominantNumber = entry.getKey();
				maxFrec = frec;
			}
		}
		System.out.println(dominantNumber);
		int n = nums.size();
		int minPartition = Integer.MAX_VALUE;
		int leftFrec = 0;//Number of x in [0,i]
		int rightFrec = maxFrec;//Number of x in [i+1, n-1]
		for(int i = 0; i < n-1; i++) {
			if(nums.get(i) == dominantNumber) {
				leftFrec++;
				rightFrec--;
			}
			//Left side size is (i+1)-0 = i + 1
			//Right side size is ((n-1) + 1)-(i+1) = n - (i+1)
//			System.out.println("l: " + leftFrec + " r: " + rightFrec);
			int leftSize = i + 1;
			int rightSize = n - leftSize;
//			System.out.println("lsize:" + leftSize + " rSize:" + rightSize);
			if(2*leftFrec > leftSize && 2*rightFrec > rightSize ) 
				minPartition = Math.min(minPartition, i);
		}
		if(minPartition == Integer.MAX_VALUE)
			return -1;
		return minPartition;
    }
	
	public static void main(String[] args) {
//		int[] numsArr = {3,3,3,3,7,2,2};
//		int[] numsArr = {2,1,3,1,1,1,7,1,2,1};
		int[] numsArr = {1,2,2,2};
		List<Integer> nums = new ArrayList<>();
		for(int num: numsArr)
			nums.add(num);
		System.out.println(minimumIndex(nums));
	}
}
