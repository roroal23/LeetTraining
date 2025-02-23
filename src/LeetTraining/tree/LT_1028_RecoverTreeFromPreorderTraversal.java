package LeetTraining.tree;

import java.util.*;

public class LT_1028_RecoverTreeFromPreorderTraversal {
	/**
	 * Definition for a binary tree node.
	 */
	
	public static TreeNode recoverFromPreorder(String traversal) {
		Stack<TreeNode> stack = new Stack<>();
		int i = 0;
		
		while(i < traversal.length()) {//Recorro todo el string
			int depth = 0;
			while(i < traversal.length() && traversal.charAt(i) == '-') {
				depth++;//Por cada guion que se encuentre la profundidad aumenta en 1
				i++;
			}
			int value = 0;
			while(i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
				value = 10 * value + (traversal.charAt(i) - '0'); //Construir el valor a partir de sus digitos
				i++;
			}
			
			while(stack.size() > depth)//Si hay mas nodos de los necesarios (ramas llenas), los quitamos
				stack.pop();
			TreeNode node = new TreeNode(value);
			if(!stack.isEmpty()) {//Añade el nodo como hijo izq o der
				TreeNode parent = stack.peek();
				if(parent.left == null)//Si se puede siempre se añade como izquierdo primero
					parent.left = node;
				else if(parent.right == null)//sino como hijo derecho
					parent.right = node;
			}
			stack.push(node);//Añadimos el nodo a la pila
		}
		//Dado que el nivel nunca va a ser menor que 0, el nodo inicial siempre se quedara en la pila
		return stack.getFirst(); 
	}
//	
//	private static int[] nodeValDepth (String traversal, int i) {
//		//I apunta al primer dash
//		int dashes = 0;
//		while(i < traversal.length() && traversal.charAt(i) == '-') {
//			dashes++;
//			i++;
//		}
//		int val = traversal.charAt(i) - '0';
//		int[] valDepth = {dashes, val};
//		return valDepth;
//	}
	
	public static void main(String[] args) {
		String traversal = "1-2--3--4-5--6--7";
		System.out.println(recoverFromPreorder(traversal));
	}

}

