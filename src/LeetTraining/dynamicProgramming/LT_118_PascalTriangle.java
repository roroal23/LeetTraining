package LeetTraining.dynamicProgramming;

import java.util.*;

public class LT_118_PascalTriangle {
	
	/*
	 * La regla para obtener el valor de cada triangulo es:
	 * - 1 a los lados del triangulo (extremos de cada lista)
	 * - Para cualquier valor intermedio el valor se obtiene sumando el elemento arriba suyo y 
	 * el elemento a a la izquierda del de arriba.
	 * a[n][m] = a[n-1][m] + a[n-1][m-1]
	 */
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<>(numRows);//Habran numRows listas
		for(int n = 0; n < numRows; n++) {
			List<Integer> list = new ArrayList<>(n + 1);//Se conoce el tamano de cada lista
			triangle.add(list);
			for(int m = 0; m < n + 1; m++) {
				if(m == 0 || m == n)
					list.add(1);//1 a los extremos
				else {
					List<Integer> listAbove = triangle.get(n-1);//Extraigo la lista de arriba
					list.add(listAbove.get(m) + listAbove.get(m-1));//Aplico la relacion de reccurencia
				}
			}
		}
		return triangle;
        
    }

	public static void main(String[] args) {
		System.out.println(generate(5));
	}

}
