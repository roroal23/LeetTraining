package LeetTraining.arrays;

import java.util.*;

public class LT_2161_PartitionArrayAccordingToPivot {
	public static int[] pivotArray(int[] nums, int pivot) {
		int[] lessPivot = new int[nums.length];
		int lessLength = 0;
		int[] morePivot = new int[nums.length];
		int moreLength = 0;
		int pivotLength = 0;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] < pivot) {
        		lessPivot[lessLength] = nums[i];
        		lessLength++;
        	}
        	else if(nums[i] > pivot) {
        		morePivot[moreLength] = nums[i];
        		moreLength++;
        	}
        	else 
        		pivotLength++;
        }
        
        int[] partition = new int[nums.length];
        int i = 0;
        System.out.println(lessLength);
        for(int j = 0; j < lessLength; j++) {
        	System.out.println("Less: i: " + i + "j: " + j + "Elemento:" + lessPivot[j]);
        	partition[i] = lessPivot[j];
        	i++;
        }
        System.out.println(pivotLength);
        for(int j = 0; j < pivotLength; j++) {
        	System.out.println("Less: i: " + i + "j: " + j + "Elemento: " + pivot);
        	partition[i] = pivot;
        	i++;
        }
        System.out.println(moreLength);
        for(int j = 0; j < moreLength; j++) {
        	System.out.println("Less: i: " + i + "j: " + j+ "Elemento:" + morePivot[j]);
        	partition[i] = morePivot[j];
        	i++;
        }
        
		return partition;
    }
	
	public static void main(String[] args) {
		int[] nums = {9,12,5,10,14,3,10};
		int pivot = 10;
		int[] res = pivotArray(nums, pivot);
		System.out.println(Arrays.asList(res));
	}
}
