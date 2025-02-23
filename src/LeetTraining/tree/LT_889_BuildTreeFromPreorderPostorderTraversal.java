package LeetTraining.tree;

import java.util.Stack;

public class LT_889_BuildTreeFromPreorderPostorderTraversal {
	
	/*
	 * Idea inicial:
	 * Agregar los nodos de preorder hasta que el ultimo nodo añadido se encuentre en la posicion 
	 * actual de postorder, en ese caso retroceder al padre hasta que no se encuentren nodos añadidos
	 * en postorder, luego cambiar de rama y repetir.
	 */
	
	public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
		int i = 0;//Recorre preorder
		int j = 0;//Recorre postorder
		Stack<TreeNode> stack = new Stack<>();
		while(i < preorder.length) {
			TreeNode node = new TreeNode(preorder[i]);//Crea el nodo con el valor actual de preorder
			if(!stack.isEmpty()) {//Si hay un nodo en la pila, el nodo actual es su hijo
				TreeNode parent = stack.peek();
				if(parent.left == null)//Si no tiene hijo izq se agrega
					parent.left = node;
				else if(parent.right == null)//Si tiene hijo izq, se agrega como derecho
					parent.right = node;
			}
			stack.add(node);//Se agrega a la pila
			while(stack.size() > 1 && stack.peek().val == postorder[j]) {
				//Mientras el ultimo nodo de la pila este en postoder, hay que retroceder hacia el padre
				stack.pop();
				j++;
			}
			i++;
		}
		//Ya que stack.size() > 1, al final solo queda el primer nodo añadido a esta (la raiz)
		return stack.getFirst();
	}
	 
	public static void main(String[] args) {
		int[] preorder = {1,2,4,5,3,6,7};
		int[] postorder = {4,5,2,6,7,3,1};
		TreeNode root = constructFromPrePost(preorder, postorder);
		TreePrinter.printTree(root);
	}
}
