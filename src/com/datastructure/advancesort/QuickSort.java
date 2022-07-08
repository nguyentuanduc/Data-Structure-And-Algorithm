package com.datastructure.advancesort;

public class QuickSort {

	public static void main(String[] args) {

		int maxSize = 10;
		ArrayIns arr = new ArrayIns(maxSize);
		for(int j = 0; j < maxSize; j++) {
			long n = (int)(java.lang.Math.random()*199);
			arr.insert(n);
		}		
		arr.display();
		arr.quickSort();
		arr.display();
	}
	
	
	
	

}
	class ArrayIns {
		private long[] theArray;
		private int nElements;
		
		public ArrayIns(int max) {
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
			int rightPtr = right ;
			
			while(true) {
				// when item equal pivot while will be stop, not error out of index
				while(theArray[++leftPtr] < pivot); 
				
				while(rightPtr > 0 && theArray[--rightPtr] > pivot);
				
				if(leftPtr >= rightPtr) {
					break;
				} else {
					swap(leftPtr, rightPtr);
				}
			}
			swap(leftPtr, right); //code of book is wrong
			return leftPtr;
		}
		
		public void recQuickSort(int left, int right) {
			if(right - left <= 0) {
				return;
			} else {
				long pivot = theArray[right];
				
				int partition = partitionIt(left, right, pivot);
				recQuickSort(left, partition - 1);
				recQuickSort(partition + 1, right);
			}
		}
		
		
		public void quickSort() {
			recQuickSort(0, nElements - 1);
		}
	}
	
	
	
	
	

