package LeetTraining.math;
import java.util.*;


public class LT_2523_ClosestPrimeNumbersInRange {
	public static int[] closestPrimes(int left, int right) {
        boolean[] numbers =  new boolean[right + 1];//Ignoro el cero y el 1
        int maxDivisor = (int)Math.sqrt(right) + 1;
        //La posicion de i equivale al numero
        for(int i = 2; i <= maxDivisor; i++) {
        	if(!numbers[i]) {//Si el numero no esta marcado
	        	for(int j = i*2; j < numbers.length; j += i) {//Me muevo por los multiplos de i
	        		numbers[j] = true;
	        	}
        	}
        }
        List<Integer> primes = new ArrayList<>();//Lista de primos ordenada implicitamente
        for(int i = left; i < numbers.length; i++) {
        	if(!numbers[i])
        		primes.add(i);
        }
        System.out.println(primes);
        int minDistance = Integer.MAX_VALUE;
        int pos = -1;
//        for(int i = 0; i < primes.size() - 1; i++) {
        for(int i = primes.size() - 1; i > 0; i--) {
        	int x = primes.get(i);
        	int y = primes.get(i-1);
        	System.out.println("Pareja: " + x + ", " + y);
        	System.out.println("Distancia: " + (x-y));
        	if(x - y < minDistance) {
        		minDistance = x - y;
        		pos = i;
        	}
        }
        
		if(pos == -1)
			return new int[] {-1,-1};
		else 
			return new int[] {primes.get(pos-1), primes.get(pos)};
    }
	
	public static void main(String[] args) {
		int[] res = closestPrimes(19, 31);
		System.out.println(res[0] + ", " +  res[1]);
	}
}
