package LeetTraining.arrays;
import java.util.*;

public class LT_1524_NumberSubarraysWithOddSum {
	public static int numOfSubarrays(int[] arr) {
		long sum = 0;
		int numOddAcc = 0;
		int numEvenAcc = 0;
		int oddSubarrays = 0;
		int max = (int)Math.pow(10,9) + 7;
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if(sum % 2 == 1) {//impa
				numOddAcc++;
				oddSubarrays += 1 + numEvenAcc;
			}
			else { 
				numEvenAcc++;
				oddSubarrays += numOddAcc;
			}
			if(oddSubarrays == max)
				oddSubarrays = 0;
		}
		return oddSubarrays;
	}
	
	//APROBADA	
//		boolean[] isSumOddArr = new boolean[arr.length];
//		int sum = 0;
//		int oddSums = 0;
//		for(int i = 0; i < arr.length; i++) {
//			sum += arr[i];
//			isSumOddArr[i] = sum % 2 == 1;
//			if(isSumOddArr[i]) 
//				oddSums++;
//			for(int j = 0; j < i; j++) {
//				if((isSumOddArr[j] && !isSumOddArr[i]) || (!isSumOddArr[j] && isSumOddArr[i]))
//					oddSums++;
//			}
//		}
//		return (oddSums % ((int)Math.pow(10,9) + 7));
//	}
//		int[] accumSum = new int[arr.length];
//		int sum = 0;
//		int oddSums = 0;
//		for(int i = 0; i < arr.length; i++) {
//			sum += arr[i];
//			accumSum[i] = sum;
//			if(sum % 2 == 1)
//				oddSums++;	
//			for(int j = 0; j < i; j++) {
//				int previousSum = accumSum[j];
//				if((sum - previousSum) % 2 == 1)
//					oddSums++;
//			}
//		}
//		return  (oddSums % ((int)Math.pow(10,9) + 7));
//	}
//      Map<Integer, Integer> accumSum = new HashMap<>();       
//      int sum = 0;
//      for(int i = 0; i < arr.length; i++) {//Itero sobre todos los elementos
//      	sum += arr[i];
//      	accumSum.put(i, sum);//Almaceno la suma acumulada hasta el momento i
//      }
//      System.out.println(accumSum);
//      int oddSums = 0;
//      for(int i = 0; i < accumSum.size(); i++) {//Itero sobre todas las sumas acumuladas
//      	int actualSum = accumSum.get(i);
//      	System.out.println("ActualSum: " + actualSum + " -----------");
//      	if(actualSum % 2 == 1)
//      		oddSums++;
//      	//Si es par, busco impares y si es impar busco pares. Es decir actual - previous sea impar
//      	for(int j = 0; j < i; j++){
//      		int previousSum = accumSum.get(j);
//      		System.out.println("Previous sum: " + previousSum);
//      		if((actualSum - previousSum) % 2 == 1) //Si su diferencia es impar aumento el contador
//      			oddSums++;
//      	}
//      }
//    }
	
	public static void main(String[] args) {
		int[] arr = {1,3,5};
		System.out.println("Total:" + numOfSubarrays(arr));
	}
	
	
}
