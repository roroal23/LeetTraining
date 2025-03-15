package LeetTraining.design;
import java.util.*;
public class LT_1352_ProductOfTheLastKNumbers {

	class ProductOfNumbers {
	    int nElem;
	    int lastZeroIndex;
	    Map<Integer, Integer> map;

	    public ProductOfNumbers() {
	        nElem = 0;
	        lastZeroIndex = -1;
	        map = new HashMap<>();
	        map.put(0, 1);
	    }
	    
	    public void add(int num) {
	        if (num == 0) {
	            lastZeroIndex = nElem;
	            map.put(++nElem, 1);
	        } else {
	            int lastProd = map.get(nElem);
	            map.put(++nElem, lastProd * num);
	        }
	    }
	    
	    public int getProduct(int k) {
	        if (lastZeroIndex >= nElem - k) return 0;
	        return map.get(nElem) / map.get(nElem - k);
	    }
	}


	/**
	 * Your ProductOfNumbers object will be instantiated and called as such:
	 * ProductOfNumbers obj = new ProductOfNumbers();
	 * obj.add(num);
	 * int param_2 = obj.getProduct(k);
	 */
}
