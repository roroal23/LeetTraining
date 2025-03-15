package LeetTraining.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LT_2467_MostProfitablePath {
	
	/*Pasos para resolver el problema:
	 * Convertir el array de aristas en un "arbol" comprensible
	 * - Crear un mapa de nodo y lista de nodos adyacentes (hijos y padre)
	 * - Recorrer la matriz y llenarlo
	 * Encontrar el camino de bob hacia la raiz y guardar en que momento visito cada nodo
	 * - Es unico y implica subir hacia sus padre recursivamente
	 * Hacer una busqueda en profundidad tomando en cuenta los nodos recorridos por bob
	 * 
	 */
	
	
	public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
		
		//PASO 1: LISTA DE PARES A ARBOL
		Map<Integer, ArrayList<Integer>> tree = new HashMap<>();
		for(int i = 0; i < edges.length; i++) {//Recorro todos los pares
			//Debo añadir cada nodo del par en la lista de adyacencia del opuesto
			int nodo1 = edges[i][0];
			int nodo2 = edges[i][1];
			ArrayList<Integer> adyacentesNodo1 = tree.get(nodo1);//Obtengo los adyacentes del nodo1
			if(adyacentesNodo1 == null) {//Si todavia no esta en el arbol creo la lista y lo agrego
				adyacentesNodo1 = new ArrayList<>();
				tree.put(nodo1, adyacentesNodo1);
			}
			adyacentesNodo1.add(nodo2);//Añado nodo2 a los adyacentes del nodo1
			
			ArrayList<Integer> adyacentesNodo2 = tree.get(nodo2);//Obtengo los adyacentes del nodo2
			if(adyacentesNodo2 == null) {//Si todavia no esta en el arbol creo la lista y lo agrego
				adyacentesNodo2 = new ArrayList<>();
				tree.put(nodo2, adyacentesNodo2);
			}
			adyacentesNodo2.add(nodo1);//Añado nodo1 a los adyacentes del nodo2
		}
		
		//PASO 2: RECORRIDO DE BOB
		//Dado que no tenemos un arbol propiamente dicho, lo mas natrual seria generar los caminos posibles hasta encontrar
		//el que llegue a Bob. Usaremos una busqueda en profundidad
		
		ArrayList<Integer> bobPath = new ArrayList<>();
		deepSearchBob(tree, 0, -1, bob, bobPath);
		//Para cada nodo del camino relleno su valor y el tiempo en que se obtuvo
		Map<Integer, Integer> bobTime = new HashMap<>();
		for(int i = 0; i < bobPath.size(); i++) {
			int node = bobPath.get(i);
			bobTime.put(node, i);
		}
		
		return deepSearchAlice(tree, 0, -1, 0, bobTime, amount);
    }
	
	private boolean deepSearchBob(Map<Integer, ArrayList<Integer>> tree, int node, int parent, int bob, ArrayList<Integer> bobPath) {
		bobPath.add(node);//Me añado al camino
		if(node == bob)//Si soy Bob hemos acabado la busqueda
			return true;
		ArrayList<Integer> adyacentes = tree.get(node);//Nodos adyacentes a mi
		Iterator<Integer> it = adyacentes.iterator();
		int nextNode;
		boolean foundBob = false;//Si alguna rama encuentra a bob deberiamos parar
		while(it.hasNext() && !foundBob) {
			nextNode = it.next();
			if(nextNode != parent)//Evitamos "subir" por la rama
				foundBob = deepSearchBob(tree, nextNode, node, bob, bobPath);
		}
		bobPath.remove(bobPath.size() - 1);//Si no soy parte del camino, me elimino
		return foundBob;
	}
	
	private int deepSearchAlice(Map<Integer, ArrayList<Integer>> tree, int node,
			int parent, int time, Map<Integer, Integer> bobTime, int[] amounts) {
		int gananciaNodo = 0;
		if(!bobTime.containsKey(node))//si bob no pasa, alice se queda con el nodo
			gananciaNodo = amounts[node];
		else {//si bob pasa, comparamos los tiempos
			int bobNodeTime = bobTime.get(node);
			if(time < bobNodeTime)//Si alice gana a bob, se queda con el nodo
				gananciaNodo = amounts[node];
			else if(time == bobNodeTime)//si llegan a la vez se reparten
				gananciaNodo = amounts[node]/2;
			//si alice llega despues no gana/pierde nada
		}
		int maximaGanancia = Integer.MIN_VALUE;
		boolean isLeaf = true;
		ArrayList<Integer> adyacentes = tree.get(node);
		for(Integer nextNode : adyacentes) {
			if(nextNode != parent) {
				isLeaf = false;
				int posibleGanancia = deepSearchAlice(tree, nextNode, node, time + 1, bobTime, amounts);
				if(posibleGanancia > maximaGanancia)
					maximaGanancia = posibleGanancia;
			}
		}
		if(isLeaf)
			maximaGanancia = 0;
		return gananciaNodo + maximaGanancia;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
	}
}
