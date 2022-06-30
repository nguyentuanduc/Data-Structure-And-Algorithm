package com.datastructure.advancesort;

public class Partition {

	public static void main(String[] args) {

		int maxSize = 16;
		ArrayPar arr = new ArrayPar(maxSize);
		for(int j = 0; j < maxSize; j++) {
			long n = (int)(java.lang.Math.random()*199);
			arr.insert(n);
		}

		arr.display();
		long pivot = 99;
		System.out.print("Pivot us " + pivot);
		int size = arr.size();
		int partDex = arr.partitionIt(0,  size - 1, pivot);
		System.out.println(", Partition is at index " + partDex);
		arr.display();
		
	}
	
}


class ArrayPar {

	private long[] theArray;
	private int nElements;
	
	public ArrayPar(int max) {
		theArray = new long[max];
		nElements = 0;
	}
	
	public void insert(long value) {
		theArray[nElements] = value;
		nElements++;
	}
	
	public int size() {
		return nElements;
	}
	
	public void display() {
		System.out.print("A = ");
		for(int j = 0; j < nElements; j++) {
			System.out.print(theArray[j] + " ");
		}
		System.out.println(" ");
	}
	
	public void swap(int dex1, int dex2) {
		long temp;
		temp = theArray[dex1];
		theArray[dex1] = theArray[dex2];
		theArray[dex2] = temp;
	}
	
	public int partitionIt(int left, int right, long pivot) {
		int leftPtr = left - 1;
		int rightPtr = right + 1;
		
		while(true) {
			while(leftPtr < right && theArray[++leftPtr] < pivot);
			while(rightPtr > left && theArray[--rightPtr] > pivot);
			
			if(leftPtr >= rightPtr) {
				break;
			} else {
				swap(leftPtr, rightPtr);
			}
		}
		
		return leftPtr;
	}
}









