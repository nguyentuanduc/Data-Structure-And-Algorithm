package com.datastructure.simplesort;


public class Bubble {

	public static void main(String[] args) {

		int maxSize = 10;
		ArrayBubble arr = new ArrayBubble(maxSize);
		/*for(int j = 0; j < maxSize; j++) {
			long n = (int)(java.lang.Math.random()*99);
			arr.insert(n);
		}*/
		
		arr.insert(7);
		arr.insert(10);
		arr.insert(9);
		arr.insert(1);
		arr.insert(2);
		arr.insert(5);
		arr.insert(8);
		arr.insert(6);
		arr.insert(4);
		arr.insert(3);
		
		arr.display();
		arr.bubbleSort();
		arr.display();
	}

	
}


class ArrayBubble {
	private long[] a;
	private int nElems;
	
	
	public ArrayBubble(int max) {
		a = new long[max];
		nElems = 0;
	}
	
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}
	
	public void display() {
		for(int j = 0; j < nElems; j++) {
			System.out.print(a[j] + " ");
		}
		System.out.println("");
	}
	
	
	public void bubbleSort() {
		long n = nElems;
		int j = 0;
		while( j < n) {
			
			for(int i = j + 1; i < n; i++) {
				long temp = a[j];
				if(temp > a[i]) {
					a[j] = a[i];
					a[i] = temp;
					
				} 
				j++;
			}
			j = 0;
			n  = n - 1;
		}
	}
	
	
	
	
	
	
	
	
	
	
}
