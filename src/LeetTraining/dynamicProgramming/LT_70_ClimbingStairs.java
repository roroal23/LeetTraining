package LeetTraining.dynamicProgramming;

public class LT_70_ClimbingStairs {
	/*
	 * Si llamamos x(n) a la forma de subir n escalones tomandos pasos de 1 o 2 escalones:
	 * x(1) = 1
	 * x(2) = 2
	 * x(3) = 3 = x(1) + x(2)
	 * x(4) = 5 = x(3) + x(2)
	 * Luego podemos establecer la relacion de recurrencia
	 * x(n) = x(n-1) + x(n-2), n > 2, x(1) = 1, x(2) = 2
	 * Dado que se deberan calcular los mismos valores muchas veces es conveniente almacenarlos:
	 * Ej: x(5) = x(4) + x(3) = (x(3) + x(2)) + (x(2) + x(1)) = (x(2) + x(1) + x(2)) + (x(2) + x(1))
	 * Además como los i de x(i), son valores seguidos y menores al n dado, podemos almacenarlos en  un array
	 */
	
	public static int climbStairs(int n) {
        if(n < 3)//Si n es menor que 3 (0,1 o 2) no es necesario computar
        	return n;
        int[] waysToClimb = new int[n + 1];//Ignoramos el indice 0
        waysToClimb[1] = 1;//Condiciones iniciales
        waysToClimb[2] = 2;
        for(int i = 3; i <= n; i++) {//Recorro todos los i hasta n, computando los valores
        	waysToClimb[i] = waysToClimb[i-1] + waysToClimb[i-2];//Aplico la relacion de recurrencia
        }
		return waysToClimb[n];
    }

	public static void main(String[] args) {
		System.out.println(climbStairs(5));
	}

}
