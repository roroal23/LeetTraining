
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Prueba {
	public static boolean divideArray(int[] nums) {
		PriorityQueue<Integer> colaOrdenada=new PriorityQueue<>();
		fillingQueue(nums, colaOrdenada, 0);
		System.out.println(colaOrdenada);
		while(!colaOrdenada.isEmpty()) {
			System.out.println(colaOrdenada.poll());
		}
		boolean divitionOk=true;
		Iterator<Integer> it=colaOrdenada.iterator();
		while(it.hasNext() && divitionOk) {
			int elemen1=it.next();
            int elemen2;
			if(it.hasNext()) {
                elemen2=it.next();
                if(elemen1 != elemen2){
				    divitionOk=false;
                }
			}
            if(it.hasNext())
                elemen1=it.next();
            if(it.hasNext())
                elemen2=it.next();
		}
		return divitionOk;
	}
	private static void fillingQueue(int [] nums,PriorityQueue<Integer> colaOrdenada, int i) { //
		if(i>=nums.length) {
			return;
		}
		colaOrdenada.add(nums[i]);
		fillingQueue(nums, colaOrdenada, i+1);
	}
	
	public static void main(String[] args) {
		int []nums= {3,2,3,2,2,2};
		divideArray(nums);
	}
}
