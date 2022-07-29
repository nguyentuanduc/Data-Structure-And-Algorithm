package com.datastructure.simplesort;


public class Selection {

	public static void main(String[] args) {

		int maxSize = 10;
		ArraySelection arr = new ArraySelection(maxSize);
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
		arr.selectionSort();
		arr.display();
	}

	
}


class ArraySelection {
	private long[] a;
	private int nElems;
	
	
	public ArraySelection(int max) {
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
	
	
	public void selectionSort() {
		int n = nElems;
		int j = 0;
		while( j < n) {
			
			for(int i = j + 1; i < n; i++) {
				if(a[j] < a[i]) {
					j = i;
				}
			}
			long temp =  a[j];
			a[j] =  a[n -1];
			a[n-1] = temp;
			
			j = 0;
			n--;
		}
	}
	
	
	
	
	
	
	
	
	
	
}
