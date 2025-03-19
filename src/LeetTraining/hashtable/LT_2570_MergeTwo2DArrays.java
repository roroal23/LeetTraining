package LeetTraining.hashtable;
import java.util.*;
public class LT_2570_MergeTwo2DArrays {
	
	public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		TreeSet<Integer> ids = new TreeSet<>();
		int sum;
		for(int i = 0; i < nums1.length; i++) {
			sum = map.getOrDefault(nums1[i][0], 0);//Si ya se encuentra insertado el id, recupero su suma
			map.put(nums1[i][0], sum + nums1[i][1]);//Inserto en el mapa
			ids.add(nums1[i][0]);
		}
		for(int i = 0; i < nums2.length; i++) {
			sum = map.getOrDefault(nums2[i][0], 0);//Si ya se encuentra insertado el id, recupero su suma
			map.put(nums2[i][0], sum + nums2[i][1]);//Inserto en el mapa
			ids.add(nums2[i][0]);
		}
		int[][] res = new int[map.size()][2];
		int id;
		for(int i = 0; i < map.size(); i++) {
			id = ids.pollFirst();
			res[i] = new int[] {id, map.get(id)};
		}
		return res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
