package LeetTraining.slidingWindow;

public class LT_3208_AlternatingGroupsII {

	public static int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        int left = 0;

        for (int right = 1; right < n + k - 1; right++) {
            if (colors[right % n] == colors[(right - 1) % n]) 
                left = right;
            if (right - left + 1 >= k) 
                count++;
        }

        return count;
    }
	
		
		
//		int n = colors.length;
//		int inicial = -1;//Busco un par de casillas de color igual para empezar
//        for(int i = 0; i < colors.length && inicial == -1; i++) {
//        	int left = (i - 1 + n) % n;
//        	if(colors[left] == colors[i])
//        		inicial = i;
//        }
//       //Si no hay empiezo en cualquiera, en 0 por facilidad
//        int maxAltLength = 1;
//        //Busco el numero maximo de conjuntos alternado
//        System.out.println("Inicial: " + inicial);
//        int j = inicial + 1;
//        boolean alternated = true;
//        while(maxAltLength <= n && alternated) {
//        	j = j % n;
//        	int left = (j - 1 + n)%n;
//        	System.out.println("Pos:" +j + " Left: " + colors[left] + " Me: " + colors[j] + " Count: " + maxAltLength);
//        	alternated = colors[left] != colors[j];
//        	if(alternated)
//        		maxAltLength++;
//        	j++;
//        }
//        return maxAltLength - k + 1;
//    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] colors = {0,1,0,0,1,0,1};
		int k = 6;
		System.out.println(numberOfAlternatingGroups(colors, k));
	}

}
