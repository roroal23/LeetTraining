package LeetTraining.math;

public class LT_1780_CheckIfNumberIsSumOfPowersOfThree {
	
	/* 12 = 110
	 * 13 = 111 x
	 * 27 = 1000
	 * 30 = 1010
	 * 31 = 1011 x 
	 *
	 */
	
	public boolean checkPowersOfThree(int n) {
		return false;
	}

	/*SOLUCION CON BACKTRACKING
	 * Complejidad: O(2^n), 
	 * siendo n los exponentes tales que 3^n sea menor que el numero dado*/
	
//	public boolean checkPowersOfThree(int n) {
//		return backtracking(n, -1, 0);
//    }
//	
//	private boolean backtracking(int n, int minExp, int sum) {
//		if(sum > n)
//			return false;
//		if(sum == n)
//			return true;
//		boolean found = false;
//		int exp = minExp + 1;
//		int newSum;
//		while(!found && (newSum = sum + (int)Math.pow(3, exp) ) <= n) {
//			found = backtracking(n, exp, newSum);
//			exp++;
//		}
//		return found;
//	}

}
