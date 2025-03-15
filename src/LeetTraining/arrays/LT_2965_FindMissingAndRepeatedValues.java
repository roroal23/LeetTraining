package LeetTraining.arrays;
import java.util.*;
public class LT_2965_FindMissingAndRepeatedValues {
	public int[] findMissingAndRepeatedValues(int[][] grid) {
		int n = grid.length;
		int size = n * n;
		boolean[] seen = new boolean[size + 1];
		int repeated = 0;//a
		int missing = 0;//b

		int val;
		int sum = 0;//Suma de los valores del array, y
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				val = grid[i][j];
				sum += val;
				if(seen[val])//Si ya esta marcado como visto es el repetido
					repeated = val;
				seen[val] = true;
			}
		}
		int expectedSum = (size*(size+1))/2;//La suma de 1 a n^2, y'
		missing = repeated - sum + expectedSum;//b = a - (y' - y)
		return new int[] {repeated, missing};
	}
}
