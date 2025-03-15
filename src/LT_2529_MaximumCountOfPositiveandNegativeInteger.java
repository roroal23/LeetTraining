
public class LT_2529_MaximumCountOfPositiveandNegativeInteger {

	public static int maximumCount(int[] nums) {
        return 0;
    }
	
//	SOLCUION LNEAL
//	public static int maximumCount(int[] nums) {
//        int numNeg = 0;
//        int zeros = 0;
//        int i = 0;
//        while(i < nums.length && nums[i] <= 0) {
//        	if(nums[i] == 0)
//        		zeros++;
//        	else
//				numNeg++;
//        	i++;
//        }
//        int numPos = nums.length - numNeg - zeros;
//        return Math.max(numNeg, numPos);
//    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-3,-2,-1,0,0,1,2};
		System.out.println(maximumCount(nums));
	}

}
