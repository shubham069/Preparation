package com.Sorting;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p = {3,5,2,8,1,4};
		QuickSort sort = new QuickSort();
		sort.quickSort(p, 0, 5);
		//System.out.println("\n"+pIndex);
		for(int a:p)
			System.out.print(a+" ");
	}
	public void quickSort(int[] A, int start, int end){
		if(start<end){
			int pIndex = partition(A, start, end);
			quickSort(A, start, pIndex-1);
			quickSort(A, pIndex, end);
		}
		
	}
	
	public int partition(int[] A, int start, int end){
		int pivot = A[end];
		int pIndex = start;
		int tmp;
		for(int i=start; i<end;i++){
			if(A[i]<=pivot){
				tmp = A[i];
				A[i]=A[pIndex];
				A[pIndex]= tmp;
				pIndex++;
			}
		}
		//tmp=A[pIndex];
		//A[pIndex]= pivot;
		
		A[end]= A[pIndex];
		A[pIndex]= pivot;
		
		return pIndex;
	}
	
}
