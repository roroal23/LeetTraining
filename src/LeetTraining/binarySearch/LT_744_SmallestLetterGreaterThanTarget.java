package LeetTraining.binarySearch;

public class LT_744_SmallestLetterGreaterThanTarget {
	public static char nextGreatestLetter(char[] letters, char target) {
		int left = 0;
		int right = letters.length - 1;
		int nextGreatest = 0;
		while(left <= right) {
			int mid = left + (right - left)/2;
			if(letters[mid] > target) {
				nextGreatest = mid;//We save the greatest letter at the moment
				right = mid - 1;//Move to the left to find a smaller letter to the one we found
			}
			else {
				left = mid + 1;//Move to the right to find a letter greater than character
			}			
		}
		return letters[nextGreatest];
	}
}
