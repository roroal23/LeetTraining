package LeetTraining.arrays;

import java.util.*;
public class LT_2033_MinimumOperationToMakeAUniValueGrid {
	/*You are given a 2D integer grid of size m x n and an integer x. In one operation,
	 *  you can add x to or subtract x from any element in the grid.
	 *  A uni-value grid is a grid where all the elements of it are equal.
	 *  Return the minimum number of operations to make the grid uni-value. 
	 *  If it is not possible, return -1.
	 */
	public static int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        //We must check that all remainders of 'modulo x' must be the same
        //So we can transform them into a set value
        //Ex: 5, 3, 11, x = 2, all have modulo 1, so they can be transformed into 5 by adding/substracting 2 repeatedly
        int remainder = grid[0][0] % x;//The remainder of the 1st element
        for(int i = 0; i < grid.length; i++) {//We add all the elements from the grid to the list
        	for(int j = 0; j < grid[0].length; j++) {
        		int element = grid[i][j];
        		if(element % x != remainder)//If an element has different remainder we can not transform it
        			return -1;
        		list.add(element);
        	}
        }
		list.sort(null);//We order the elements on the list
		int median = list.get(list.size()/2);//We get the median
		System.out.println(median);
		int operations = 0;
		for(int element: list) {//For each element of the list, we add the number of operations needed to transform it into the median
			operations += Math.abs(element - median) / x;
		}
		return operations;
    }
	
	public static void main(String[] args) {
//		int[][] grid = {{2,4},{6,8}};
//		int x = 2;
		int[][] grid = {{1,5},{2,3}};
		int x = 1;
		System.out.println(minOperations(grid, x));
	}
}
