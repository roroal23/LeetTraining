package LeetTraining.hashtable;
import java.util.*;


public class LT_2342_MaxSumOfAPairWithEqualSumOfDigits {
	
	public class Pair<K,V>{
		K key;V value;
		public Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}
		public K getKey() {return key; }
		public V getValue() {return value;}
	}
	
	public int maximumSum(int[] nums) {
        Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();
        Pair<Integer, Integer> pair;
        int sum;
        int max = -1;
        for(int i = 0; i < nums.length; i++){
            sum = digitsSum(nums[i]);
            pair = getMaxPair(map.get(sum), nums[i]);
            map.put(sum, pair);
            if(pair.getKey() != -1 && pair.getValue() != -1){
                max = Math.max(max, pair.getKey() + pair.getValue());
            }
        }       
        return max;
    }

    private int digitsSum(int x){
        int sum = 0;
        while(x > 0){
            sum += x % 10;
            x = x / 10;
        }
        return sum;
    }

    private Pair<Integer, Integer> getMaxPair(Pair<Integer, Integer> pair, int z){
        if(pair == null)
            return new Pair<>(z, -1);
        int x = pair.getKey();   
        int y = pair.getValue(); 
        int max1 = Math.max(x, Math.max(y, z));//Maximo de los tres
        int max2;
        if (max1 == x)//Si es x, el maximo esta entre y e z
            max2 = Math.max(y, z);
        else if (max1 == y) //Si es y, el maximo esta entre x e z
            max2 = Math.max(x, z);
        else //Si el z, el maximo esta entre x e y
            max2 = Math.max(x, y);
        return new Pair<>(max1, max2);
    }
}
