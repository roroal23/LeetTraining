package LeetTraining.hashtable;
import java.util.*;

public class LT_1726_TupleWithSameProduct {
	public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productos = new HashMap<>();
        Integer prod;
        Integer frec;
        int cuenta = 0;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                prod = nums[i] * nums[j];
                frec = productos.get(prod);
                productos.put(prod, frec == null?1:(frec+1));
            }
        }
        for(Integer frecuencia: productos.values()){
            if(frecuencia > 1)
                cuenta += frecuencia*(frecuencia -1)*4;
        }
        return cuenta;
    }
}
