package LeetTraining.binarySearch;

public class LT_1351_CountNegativeNumberInSortedMatrix {
	/*
	 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, 
	 * return the number of negative numbers in grid.
	 */
	//O(m + n) solution
	//The first negative found on each row forms a kind of staircase, so we start from the left bottom corner
	//and 'climb' that staircase, going upwards and leftwards each time
	public static int countNegatives(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int i = m - 1;//We will start from the bottom and move up eachtime
		int j = 0;//We will start from the left and move to the right eachtime
		int count = 0;
		while(i >= 0) {
			while(j < n && grid[i][j] >= 0)//Move to the right until we find a negative number
				j++;
			count += n - j;
			i--;//Move up and keep the value of the right index, since we wont find a negative number on the left
		}
		return count;
	}
	
	//m*logn solution
	public static int countNegativesBS(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int count = 0;
		for(int i = 0; i < m; i++) {//For each row we make a binary search
			int left = 0;
			int right = n - 1;
			int negativePos = -1;
			while(left <= right) {
				int mid = left + (right - left)/2;
				if(grid[i][mid] < 0) {
					negativePos = mid;//If the num is negative, we try going to the left
					right = mid - 1;
				}
				else {//If not we got the right
					left = mid + 1;
				}
			}
			if(negativePos != -1)
				count += n - negativePos;
		}
		return count;
	}
}
