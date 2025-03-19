package LeetTraining.hashtable;
import java.util.*;

public class LT_2206_DivideArrayIntoEqualPairs {
	public static boolean divideArray(int[] nums) {
        Map<Integer, Integer> frecMap = new HashMap<>();
        int currentFrec;
        for(int i = 0; i < nums.length; i++) {//For each element in nums
        	currentFrec = frecMap.getOrDefault(nums[i], 0);
        	frecMap.put(nums[i], currentFrec + 1);//We count its frecuency
        }
        boolean canDivide = true;//All elements can be divided into pairs
        Iterator<Integer> it = frecMap.values().iterator();
        while (it.hasNext() && canDivide) {//We stop if we find one elements that has odd frecuenct
			canDivide = it.next() % 2 == 0;
		}
        return canDivide;
    }
}
