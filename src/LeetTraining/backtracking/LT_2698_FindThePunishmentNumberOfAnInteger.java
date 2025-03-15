package LeetTraining.backtracking;

public class LT_2698_FindThePunishmentNumberOfAnInteger {
	public int punishmentNumber(int n) {
        int suma = 0;
        for(int i = 1; i <= n; i++){
            int sqr = i*i;
            if(punishDigit(i, 0, Integer.toString(sqr)))
                suma += sqr;
            //Llamamos a la funcion recursiva con: 
            //i, suma inicializada a 0 y el cuadrado de i como cadena
                
        }
        return suma;
    }

    private boolean punishDigit(int i, int sum, String s){
        if(s.isEmpty())//Si el string es vacio (longitud 0), revisa si la suma de las particiones es igual a i
            return sum == i;
        if(sum > i)
        //Si la suma es mayor del cuadrado se descarta esta rama de la recursion
        //Puede ser igual si en la cadena quedan ceros Ej: 100 -> 10,0
            return false;
        boolean found = false;
        int j = 1;
        while(!found && j <= s.length()){//Iteramos sobre todas las particiones posible de el string
            int partValue = Integer.valueOf(s.substring(0,j)); //Tomamos el valor numerico de la primera parte
            String rest = s.substring(j, s.length()); //Guardamos el resto de la cadena
            found = punishDigit(i, sum + partValue, rest);
            j++;
        }
        return found;
    }
}
