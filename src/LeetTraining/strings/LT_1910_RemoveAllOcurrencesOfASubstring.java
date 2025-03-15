package LeetTraining.strings;

public class LT_1910_RemoveAllOcurrencesOfASubstring {
	public String removeOccurrences(String s, String part) {
        int j = 0;//Ultima posicion del array
        char[] stack = new char[s.length()];
        for(int i = 0; i < s.length(); i++){
            stack[j] = s.charAt(i);
            if(detectSubstring(stack, part, j))
                j = j - part.length();//Se "eliminan" los caracteres colocados
            j++;
        }
        return new String(stack, 0, j);
    }

    private boolean detectSubstring(char[] stack, String part, int j){
        if(j < part.length() -1)//Si j tiene menos longitud que part no hay forma de que sean iguales
            return false;
        boolean detected = true;
        int i = part.length() - 1;
        while(detected && i >= 0){//Comparamos hasta que haya un caracter diferente
            detected = part.charAt(i) == stack[j];
            j--; i--;
        }
        return detected;
    }
}
