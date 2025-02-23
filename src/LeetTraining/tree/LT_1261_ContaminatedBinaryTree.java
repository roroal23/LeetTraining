package LeetTraining.tree;

import java.util.HashSet;
import java.util.Set;

public class LT_1261_ContaminatedBinaryTree {
	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	/*
	 * Given a binary tree with the following rules:

    root.val == 0
    For any treeNode:
        If treeNode.val has a value x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
        If treeNode.val has a value x and treeNode.right != null, then treeNode.right.val == 2 * x + 2

	 */
	public class FindElements {
		Set<Integer> values;//Almaceno los valores añadidos en el arbol
		public FindElements(TreeNode root) {
	        values = new HashSet<>();
	        root.val = 0;//Inicializo la raiz a 0
			setSonValue(root);	
		}
			
		public void setSonValue(TreeNode node) {
			values.add(node.val);//Me añado al set
	        int y = node.val * 2;
			if(node.left != null) {//Si tengo hijo izquierdo, le asigno valor
				node.left.val = y + 1;
				setSonValue(node.left);//Llamo con mi hijo izq
			}
			if(node.right != null) {//Si tengo hijo derecho, le asigno valor
				node.right.val = y + 2;
				setSonValue(node.right);//Llamo con mi hijo der
			}	
		}

		public boolean find(int target) {
			return values.contains(target);//Esta contenido en el set?
		}
	}
}
