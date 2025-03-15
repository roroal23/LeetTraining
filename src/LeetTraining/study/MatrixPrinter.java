package LeetTraining.study;

public class MatrixPrinter {
	public static String matrixToString(int[][] m) {
		String res = "";
		for(int i = 0; i < m.length; i++) {
			res += "|";
			for(int j = 0; j < m[0].length; j++) {
				res += m[i][j];
				if(j < m[0].length - 1)//Evita ponerle coma al ultimo
					res += ", ";
			}
			res += "|";
			if(i < m.length - 1)
				res += "\n";
		}
		return res;
	}
}
