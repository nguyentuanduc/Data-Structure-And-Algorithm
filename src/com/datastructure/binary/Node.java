package com.datastructure.binary;

public class Node {

	int iData;
	double dData;
	Node leftChild;
	Node rightChild;
	
	public void displayNode() {
		System.out.print('{');
		System.out.print(iData);
		System.out.print(',');
		System.out.print(dData);
		System.out.print('}');

	}
}
