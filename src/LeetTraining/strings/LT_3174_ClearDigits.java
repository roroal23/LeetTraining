package LeetTraining.strings;

public class LT_3174_ClearDigits {
	public String clearDigits(String s) {
        char[] arr = new char[s.length()];
        int j = 0;//"Puntero" del array
        for(int i = 0; i < s.length(); i++){//Recorrido lineal por s
            arr[j] = s.charAt(i);
            if(arr[j] - '0' >= 0 && arr[j] - '0' <= 9)
                j = j - 2;//"Borrar" el numero y su letra mas a la izquierda
            j++;
        }
        return new String(arr, 0, j);
    }
}
