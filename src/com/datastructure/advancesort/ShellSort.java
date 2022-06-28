package com.datastructure.advancesort;

public class ShellSort {

	public static void main(String[] args) {

		int maxSize = 10;
		ArraySh arr = new ArraySh(10);
		for(int j = 0; j < maxSize; j++) {
			long n = (int)(java.lang.Math.random()*99);
			arr.insert(n);
		}

		arr.display();
		arr.shellSort();
		arr.display();
		
	}
	
	
	
}


class ArraySh {
	private long[] theArray;
	private int nElements;
	
	
	public ArraySh(int max) {
		theArray= new long[max];
		nElements = 0;
	}
	
	public void insert(long value) {
		theArray[nElements] = value;
		nElements++;
	}
	
	public void display() {
		System.out.print("A = ");
		for(int j = 0; j < nElements; j++) {
			System.out.print(theArray[j] + " ");
		}
		System.out.println(" ");
	}
	
	
	public void shellSort() {
		int inner, outer;
		long temp;
		
		int h = 1;
		while (h != 0 && h <= nElements/3) {
			h = h*3 + 1;
			while(h > 0) {
				for(outer = h; outer < nElements; outer++) {
					temp = theArray[outer];
					inner = outer;
						while(inner > h -1 && theArray[inner-h] >= temp) {
							theArray[inner] = theArray[inner-h];
							inner -= h;
						}
					theArray[inner] = temp;
				}
				h = (h - 1)/3;
			}
		}
	}
	
	
	
	
	
	
	
	
}