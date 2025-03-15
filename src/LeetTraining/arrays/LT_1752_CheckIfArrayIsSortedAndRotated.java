package LeetTraining.arrays;

public class LT_1752_CheckIfArrayIsSortedAndRotated {
	public boolean check(int[] nums) {
        int x = 0;
        boolean isRotated = false;//Existe
        while(!isRotated && x < nums.length){
            isRotated = check(nums, x);
            x++;
        }
        return isRotated;
    }

    private boolean check(int[] nums, int x){
        int i = 0;
        boolean all = true;//Para todo
        while(all && i < nums.length -1){
            all = nums[(i + x) % nums.length] <= nums[(i + x + 1)% nums.length];
            i++;
        }
        return all;
    }
}
