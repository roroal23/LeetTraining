package LeetTraining.math;

public class LT_2579_CountTotalNumberOfColoredCells {
	public long coloredCells(int n) {
        return 2*((long)n*(n-1)) + 1;
    }
}
