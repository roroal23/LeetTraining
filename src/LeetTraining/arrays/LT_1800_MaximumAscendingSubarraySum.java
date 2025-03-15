package LeetTraining.arrays;

public class LT_1800_MaximumAscendingSubarraySum {
	public int maxAscendingSum(int[] nums) {
        int max = 0;
        int suma;
        int j;
        boolean crec;
        for(int i = 0; i < nums.length; i++){
            suma = nums[i];
            j = i + 1;
            crec = true;
            while(crec && j < nums.length){
                crec = crec && nums[j - 1] < nums[j];
                if(crec)
                    suma += nums[j];
                j++;
            }
            if(suma > max)
                max = suma;
        }

        return max;
    }
}
