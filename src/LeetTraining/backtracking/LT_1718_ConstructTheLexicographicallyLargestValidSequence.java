package LeetTraining.backtracking;

public class LT_1718_ConstructTheLexicographicallyLargestValidSequence {
	public int[] constructDistancedSequence(int n) {
        int[] arr = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];
        backtrack(arr, used, 0, n);
        return arr;
    }

    private boolean backtrack(int[] arr, boolean[] used, int i, int n) {
        if(i == arr.length)//Si llegamos al final retorna true
            return true;
        if(arr[i] != 0)//Si la posicion ya se uso avanza a la siguiente
            return backtrack(arr, used, i + 1, n);
        
        for(int num = n; num > 0; num--){
            if(!used[num]){//Si no se ha usado la posicion
                if(num == 1){
                    arr[i] = 1; used[1] = true;//Agregar 1 en la primera posicion posible
                    if(backtrack(arr, used, i+1, n))
                        return true;
                    arr[i] = 0; used[1] = false;//Si no funciona deshacer lo hecho
                }
                else if(i + num < arr.length && arr[i + num] == 0){
                    arr[i] = num; arr[i + num] = num; used[num] = true;//Colocar la pareja de numeros en el array
                    if(backtrack(arr, used, i + 1, n))
                        return true;
                    arr[i] = 0; arr[i + num] = 0;used[num] = false;//Si no funciona deshacer lo hecho
                }
            }
        }
        return false;
    }
}
