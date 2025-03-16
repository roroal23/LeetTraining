package LeetTraining.hashtable;
import java.util.*;

public class LT_2364_CountNumberOfBadPairs {
	
	public long countBadPairs(int[] nums) {
        //1. Almacenar en un mapa todos los nums[i]-i posibles junto con su frecuencia
        //Save all possible nums[i
        Map<Integer, Integer> map = new HashMap<>();//Map<nums[i] - i, frec>
        Integer sub;
        Integer frec;
        long goodPairs = 0;
        for(int i = 0; i < nums.length; i++){
            sub = nums[i] - i;
            frec = map.get(sub);
            if(frec == null)
                frec = 0;
            map.put(sub, frec + 1);
            goodPairs += (long)frec;
        }
        
        long totalPairs = ((long) nums.length*(nums.length-1))/2;
        return totalPairs - goodPairs;
    }
	
//	public long countBadPairs(int[] nums) {
//        //1. Almacenar en un mapa todos los nums[i]-i posibles junto con su frecuencia
//        Map<Integer, Integer> map = new HashMap<>();//Map<nums[i] - i, frec>
//        Integer sub;
//        Integer frec;
//        long goodPairs = 0;
//        for(int i = 0; i < nums.length; i++){
//            sub = nums[i] - i;
//            frec = map.get(sub);
//            if(frec == null)
//                frec = 0;
//            map.put(sub, frec + 1);
//            goodPairs += (long)frec;
//        }
//        
//        long totalPairs = ((long) nums.length*(nums.length-1))/2;
//        return totalPairs - goodPairs;
//    }
}
