package LeetTraining.arrays;

public class LT_3151_SpecialArrayI {
	
	
	public static boolean isArraySpecial(int[] nums) {
        //Potencialmente revisamos la mitad de los casos
        boolean mismaParidad = true;
        int paridadPares = nums[0] % 2;
        int i = 0;
        while(mismaParidad && i < nums.length){//Pares
            mismaParidad = (nums[i] % 2) == paridadPares; 
            i += 2;
        }
        i = 1;
        while(mismaParidad && i < nums.length){//Impares
            mismaParidad = ((nums[i] + 1) % 2) == paridadPares; 
            i += 2;
        }
        return mismaParidad;
    }
}
