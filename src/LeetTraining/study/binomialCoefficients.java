package LeetTraining.study;

public class binomialCoefficients {

	public static int binomial(int m, int n) {
		//INICIALIZACION
		//Matriz cuadrada de tamano n
		int[][] pascal = new int[n][n];
		//Lado izq inicializado a 0
		for(int i = 0; i < n; i++)
			pascal[i][0] = 1;
		//Diagonal principal
		for(int j = 0; j < n; j++)
			pascal[j][j] = 1;
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j != i && j < n; j++) {
				//El elemento actual es igual a la suma del de arriba y al de arriba izquierda
				pascal[i][j] = pascal[i-1][j] + pascal[i-1][j-1];
			}
		}
		System.out.println(MatrixPrinter.matrixToString(pascal));
		return pascal[n-1][m-1];
		
	}

	public static void main(String[] args) {
		System.out.println(binomial(4, 10));
	}

}

