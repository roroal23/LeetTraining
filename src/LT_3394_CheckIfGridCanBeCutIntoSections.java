import java.awt.Frame;
import java.util.*;

public class LT_3394_CheckIfGridCanBeCutIntoSections {

	/*
	 * You are given an integer n representing the dimensions of an n x n grid, with the origin at the 
	 * bottom-left corner of the grid. You are also given a 2D array of coordinates rectangles, where 
	 * rectangles[i] is in the form [startx, starty, endx, endy], representing a rectangle on the grid. 
	 * Each rectangle is defined as follows:
	 * (startx, starty): The bottom-left corner of the rectangle.
	 * (endx, endy): The top-right corner of the rectangle.
	 * Note that the rectangles do not overlap. Your task is to determine if it is possible to make
	 *  either two horizontal or two vertical cuts on the grid such that:
	 *  Each of the three resulting sections formed by the cuts contains at least one rectangle.
	 *  Every rectangle belongs to exactly one section.
	 *  Return true if such cuts can be made; otherwise, return false.
	 */
	
	public static boolean checkValidCuts(int n, int[][] rectangles) {
        
		TreeMap<Integer, Integer> diffMapX = new TreeMap<>();
		TreeMap<Integer, Integer> diffMapY = new TreeMap<>();
		for(int[] rectangle: rectangles) {//The posiiton that can't be divided go from start + 1 to end - 1 
			int leftX = rectangle[0];
			int leftY = rectangle[1];
			int rightX = rectangle[2];
			int rightY = rectangle[3];
			diffMapX.put(leftX + 1, diffMapX.getOrDefault(leftX + 1, 0) + 1);//The non-divisible start at left +1
			diffMapX.put(rightX, diffMapX.getOrDefault(rightX, 0) - 1);//The non-divisible has ended at right - 1 + 1
			
			diffMapY.put(leftY + 1, diffMapY.getOrDefault(leftY + 1, 0) + 1);
			diffMapY.put(rightY, diffMapY.getOrDefault(rightY, 0) - 1);
		}
		System.out.println("x:\n"+ diffMapX);
		System.out.println("y:\n"+ diffMapY);
		return countDivisions(diffMapX) || countDivisions(diffMapY);
    }
	
	private static boolean countDivisions(TreeMap<Integer, Integer> diffMap) {
		int prevDay = 1;
		int possibleDivisions = 0;
		int rectangles = 0;
		for (Map.Entry<Integer, Integer> entry : diffMap.entrySet()) {
			
			int currentDay = entry.getKey();
			System.out.println("Prevday:" + prevDay + " CurrentDay:" + currentDay + "Active:" + possibleDivisions);
			System.out.println(possibleDivisions);
			if (rectangles == 0) {//The days between prevDays and currentDay - 1 are available
				possibleDivisions += currentDay - prevDay;
			}
			if(possibleDivisions >= 2)
				return true;
			rectangles += entry.getValue();//We add the meetings 
			prevDay = currentDay;
		}
		return possibleDivisions >= 2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n = 5;
//		int[][] rectangles = {{1,0,5,2},
//							{0,2,2,4},
//							{3,2,5,3},
//							{0,4,4,5}};
//		int n = 4;
//		int[][] rectangles = {{0,0,1,1},{2,0,3,4},{0,2,2,3},{3,0,4,3}};
//		int n = 4;
//		int[][] rectangles = {{0,2,2,4},{1,0,3,2},{2,2,3,4},{3,0,4,2},{3,2,4,4}};
		int n = 6;
		int[][] rectangles = {{4,0,5,2},
							{0,5,4,6},
							{4,5,6,6}};
		
		
		
		System.out.println(checkValidCuts(n, rectangles));
	}

}
