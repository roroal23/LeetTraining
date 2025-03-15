package LeetTraining.arrays;

public class LT_3105_LongestStrictlyIncreasingOrDecreasingSubarray {
	
	//12-3: POTENCIAL DE SLIDING WINDOW
	
	public int longestMonotonicSubarray(int[] nums) {
        int max = 0;
        int longitud;
        int j;
        for(int i = 0; i < nums.length; i++){
            j = i + 1;
            longitud = 1;
            boolean crec = true;
            boolean dec = true;
            while((crec || dec) && j < nums.length){
                crec = crec && nums[j - 1] < nums[j];
                dec = dec && nums[j - 1] > nums[j];
                j++;
                if(crec || dec)
                    longitud++;
            }
            if(longitud > max)
                max = longitud;
        }

        return max;
    }
}
