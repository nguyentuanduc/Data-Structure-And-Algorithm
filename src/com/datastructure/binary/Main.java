package com.datastructure.binary;

public class Main {

	public static void main(String[] args) {
		Tree tree = new Tree();
		
		tree.insert(15, 15);
		tree.insert(13, 13);
		tree.insert(25, 25);
		tree.insert(9, 9);
		tree.insert(14, 14);
		tree.insert(7, 7);

		tree.insert(21, 21);
		tree.insert(23, 23);

		//tree.getRoot().displayNode();
		//tree.inOrder(tree.getRoot());
		//trasel(tree.getRoot());
		tree.display();
	}
	
/*	public static void trasel(Node root) {
		if(root != null && root.leftchild != null) {
			Node left = root.leftchild;
			left.displayNode();
			
			trasel(root.leftchild);
		}
		
		if( root != null && root.rightchild != null) {
			Node right = root.rightchild;
			right.displayNode();
			trasel(root.rightchild);
		}
		
		//trasel(root.rightchild);
		
	}*/

}
