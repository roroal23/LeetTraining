package LeetTraining.hashtable;
import java.util.*;

public class LT_3160_FindTheNumberOfDistinctColorsAmongBalls {
	
	/**You are given an integer limit and a 2D array queries of size n x 2.
	 * There are limit + 1 balls with distinct labels in the range [0, limit]. Initially, all balls are
	 *  uncolored. For every query in queries that is of the form [x, y], you mark ball x with the color
	 *  y. After each query, you need to find the number of colors among the balls.
	 *  Return an array result of length n, where result[i] denotes the number of colors after ith query.
	 *  Note that when answering a query, lack of a color will not be considered as a color.
	 * @param limit
	 * @param queries
	 * @return
	 */
	
	public int[] queryResults(int limit, int[][] queries) {
		Map<Integer, Integer> ballsWithColor = new HashMap<>();//Map<ball:color>, color != 0
		Map<Integer, Integer> colorCount = new HashMap<>();//Map<Color:count>
        int[] colorsAfterQuery = new int[queries.length];//Distinct color after ith query

        for(int i = 0; i < queries.length; i++){
            int ball = queries[i][0];
            int newColor = queries[i][1];
            if(ballsWithColor.containsKey(ball)) {//If the ball already has color
            	int currentColor = ballsWithColor.get(ball);
            	int currentCount = colorCount.get(currentColor);
            	if(currentCount == 1)
            		colorCount.remove(currentColor);
            	else 
            		colorCount.put(currentColor, currentCount - 1);
            }
            ballsWithColor.put(ball, newColor);
            int newCount = colorCount.getOrDefault(newColor, 0);
            colorCount.put(newColor, newCount + 1);
            colorsAfterQuery[i] = colorCount.size();
        }       
        return colorsAfterQuery;
    }
	
	
//	public int[] queryResults(int limit, int[][] queries) {
//        Map<Integer, Integer> ballColor = new HashMap<>();
//        Map<Integer, Integer> colorCount = new HashMap<>();
//        int[] counts = new int[queries.length];
//        int ball;
//        int color;
//        Integer count;
//        Integer lastColor;
//        Integer lastCount;
//        for(int i = 0; i < queries.length; i++){
//            ball = queries[i][0];
//            color = queries[i][1];
//            lastColor = ballColor.get(ball);
//            if(lastColor != null){//La bola tenia color antes
//                lastCount = colorCount.get(lastColor);
//                if(lastCount == 1)
//                    colorCount.remove(lastColor);
//                else//Reducimos en 1 la cuenta
//                    colorCount.put(lastColor, lastCount - 1);
//            }
//            ballColor.put(ball, color);//Cambiamos el color
//            count = colorCount.get(color);
//            if(count == null)
//                count = 0;
//            colorCount.put(color, count + 1);
//            counts[i] = colorCount.size();
//        }       
//        return counts;
//    }
	
	
	
	
	
	
	
	
	
	
	
	
}
