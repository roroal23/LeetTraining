package LeetTraining.hashtable;
import java.util.*;

public class LT_3160_FindTheNumberOfDistinctColorsAmongBalls {
	public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballColor = new HashMap<>();
        Map<Integer, Integer> colorCount = new HashMap<>();
        int[] counts = new int[queries.length];
        int ball;
        int color;
        Integer count;
        Integer lastColor;
        Integer lastCount;
        for(int i = 0; i < queries.length; i++){
            ball = queries[i][0];
            color = queries[i][1];
            lastColor = ballColor.get(ball);
            if(lastColor != null){//La bola tenia color antes
                lastCount = colorCount.get(lastColor);
                if(lastCount == 1)
                    colorCount.remove(lastColor);
                else//Reducimos en 1 la cuenta
                    colorCount.put(lastColor, lastCount - 1);
            }
            ballColor.put(ball, color);//Cambiamos el color
            count = colorCount.get(color);
            if(count == null)
                count = 0;
            colorCount.put(color, count + 1);
            counts[i] = colorCount.size();
        }       
        return counts;
    }
}
