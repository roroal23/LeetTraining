package LeetTraining.hashtable;
import java.util.*;

public class LT_1726_TupleWithSameProduct {
	
	/**Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d) such that 
	 * a * b = c * d where a, b, c, and d are elements of nums, and a != b != c != d.
	 * @param nums
	 * @return
	 */
	//Based on the formula: for each frec > 1, count += frec * (frec - 1)*4;
	//We can say each time that a new pair appears, the count is increased by 8 times the last frec
	public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> products = new HashMap<>();
        int totalCombinations = 0;
        for(int i = 0; i < nums.length - 1; i++){//For each possible pair we get their product
            for(int j = i + 1; j < nums.length; j++){
                int product = nums[i] * nums[j];
                int frecuency = products.getOrDefault(product, 0);//We get the frecuency that the product has appeared
                products.put(product, frecuency + 1);
                totalCombinations += frecuency*8;//For each new pair, there are (8 times the last frec) more combinations
            }
        }
        return totalCombinations;
    }
	
	
	
	
//	public int tupleSameProduct(int[] nums) {
//        Map<Integer, Integer> productos = new HashMap<>();
//        Integer prod;
//        Integer frec;
//        int cuenta = 0;
//        for(int i = 0; i < nums.length - 1; i++){
//            for(int j = i + 1; j < nums.length; j++){
//                prod = nums[i] * nums[j];
//                frec = productos.get(prod);
//                productos.put(prod, frec == null?1:(frec+1));
//            }
//        }
//        for(Integer frecuencia: productos.values()){
//            if(frecuencia > 1)
//                cuenta += frecuencia*(frecuencia -1)*4;
//        }
//        return cuenta;
//    }
}
