package LeetTraining.design;
import java.util.*;

public class LT_2349_DesignNumberContainerSystem {

	class NumberContainers {
	    //Map <index, number> mapea cada indice que se agrega con su numero
	    Map<Integer, Integer> container;
	    //Map<number, indexes> mapea cada numero con los indices en los que aparece
	    //Los indices se almacenan en un TreeSet, una Set ordenado
	    //Garantiza insercion, borrado y busqueda en tiempos log(n). Nos interesa que sea ordenado para encontrar el indice 
	    //menor en cada llamada de find(), ademas nos interesa que el borrado sea rapido para eleiminarlo cada vez que se 
	    //cambie un numero en un indice ya ocupado, por lo que es mejor que una priorityqueue en ese aspecto (borrado O(n)).
	    //La insercion es igual que en un priority queue
	    Map<Integer, TreeSet<Integer>> numIndexes;
	    public NumberContainers() {
	        container = new HashMap<>();
	        numIndexes = new HashMap<>();
	    }
	    public void change(int index, int number) {
	        Integer lastNum = container.put(index, number); //1. Guardamos lastNum y almaceno number en container
	        if(lastNum != null){//Si habia un numero en ese indice
	            //2. Eliminamos ese indice de lastNum en numIndexes
	            TreeSet<Integer> lastSet = numIndexes.get(lastNum);
	            lastSet.remove(index);//Eliminar ese indice del set de lastNum
	            if(lastSet.isEmpty()){//Si esta vacia, se elimina la llave lastNum
	                numIndexes.remove(lastNum);
	            }
	        }
	        //3. Anado el indice de number en numIndexes
	        TreeSet<Integer> set = numIndexes.get(number);
	        if(set == null){//Si es la primera insercion de number en container
	            set = new TreeSet<>();
	            numIndexes.put(number, set);
	        }
	        set.add(index);
	    }
	    
	    public int find(int number) {
	        TreeSet<Integer> set = numIndexes.get(number);
	        if(set == null)//El numero no esta en container
	            return -1;
	        //Es seguro que al array no esta vacio por como definimos change
	        return set.first();
	    }
	    
	}

	/**
	 * Your NumberContainers object will be instantiated and called as such:
	 * NumberContainers obj = new NumberContainers();
	 * obj.change(index,number);
	 * int param_2 = obj.find(number);
	 */
	
}
