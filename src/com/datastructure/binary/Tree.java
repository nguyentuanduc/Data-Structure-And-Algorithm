package com.datastructure.binary;

import java.util.Stack;

public class Tree {

	private Node root;
	
	
	public Node getRoot() {
		return root;
	}
	
	public Tree() {
		root = null;
	}

	public void find(int key) {
		Node current = root;
		while(current.iData != key) {
			if(key < current.iData) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
			if(current == null) {
				current = null;
			}
		}
	}
	
	public void insert(int id, double dd) {
		Node newNode = new Node();
		newNode.iData = id;
		newNode.dData = dd;
		
		if(root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			while(true) {
				parent = current;
				if(id < current.iData) {
					current = current.leftChild;
					if(current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if(current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	public void inOrder(Node localRoot) {
		if(localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + "  ");
			inOrder(localRoot.rightChild);
		}
	}
	
	public void displayTree() {  
        Stack globalStack = new Stack();  
        globalStack.push(root);  
        int nBlanks = 32;  
        boolean isRowEmpty = false;  
        System.out.println("......................................................");  
        while (isRowEmpty == false) {  
            Stack localStack = new Stack();  
            isRowEmpty = true;  
            for (int j = 0; j < nBlanks; j++) {  
                System.out.print(' ');  
            }  
            while (globalStack.isEmpty() == false) {  
                Node temp = (Node) globalStack.pop();  
                if (temp != null) {  
                    System.out.print(temp.dData);  
                    localStack.push(temp.leftChild);  
                    localStack.push(temp.rightChild);  
   
                    if (temp.leftChild != null 
                            || temp.rightChild != null) {  
                        isRowEmpty = false;  
                    }  
                } else {  
                    System.out.print("--");  
                    localStack.push(null);  
                    localStack.push(null);  
                }  
                for (int j = 0; j < nBlanks * 2 - 2; j++) {  
                    System.out.print(' ');  
                }  
            }
            System.out.println();  
            nBlanks /= 2;  
            while (localStack.isEmpty() == false) {  
                globalStack.push(localStack.pop());  
            }  
        }
        System.out.println("......................................................");  
    }
	
	
	public void delete(int id) {
		
	}
	
	
	public void display() {
		// 1 display 
	    Stack<Node> stack = new Stack<>();  
	    Stack<Node> localStack = new Stack<>();  

	    stack.push(root);
	    
	    int space = 32;
	    while(stack != null && !stack.empty()) {
	    	for(int i = 0; i < space; i++) {
	    		System.out.print(" ");
	    	}
	    	
	    	while(stack != null && !stack.empty()) {
		    	Node temp = stack.pop();
		    	if(temp != null) {
		    		System.out.print(temp.iData);
		    		
		    		localStack.push(temp.leftChild);
		    		localStack.push(temp.rightChild);
		    	} else {
		    		System.out.print("--");
		    		//return;
		    	}
		    	
		    	for(int i = 0; i < space  * 3; i++) {
		    		System.out.print(" ");
		    	}
	    	}
	    	
	    	System.out.println("");
		    space = space /2;
	    	while(localStack != null && !localStack.empty()) {
	    		stack.push(localStack.pop());
	    	}
	    }
	    
	}
	
}
