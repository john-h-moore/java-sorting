package algorithms;

import ListTools.SortingList;

/**
 * 
 * @author John H Moore	  john@jhmwebdesign.com
 * 
 * Java implementation of quicksort
 *
 */
public class QuickSort {
	
	/**
	 * Swap array elements
	 * @param myArray
	 * @param i
	 * @param j
	 */
	private static void swap(int[] myArray, int i, int j){
		int temp = myArray[i];
		myArray[i] = myArray[j];
		myArray[j] = temp;
	}
	
	/**
	 * Choose pivot
	 * @param myArray
	 * @param left
	 * @param right
	 * @return index of median of first, last, and middle elements of myArray
	 */
	private static int choosePivot(int[] myArray, int left, int right){
		/**
		 * first -> myArray[left]
		 * middle -> myArray[(left + right)/2];
		 * last -> myArray[right]
		 * return index of median(first, middle, last)
		 */
		int first = myArray[left];
		int middle = myArray[(left + right)/2];
		int last = myArray[right];
		if ( (first <= middle) && (middle <= last) ){
			return (left + right)/2;
		}
		else if ( (first <= last) && (last <= middle) ){
			return right;
		}
		else{
			return left;
		}
	}
	
	
	/**
	 * Partition
	 * @param myArray
	 * @param left
	 * @param right
	 * @param pivotIndex
	 * @return index of new pivot
	 */
	private static int partition(int[] myArray, int left, int right, int pivotIndex){
		/**
		 * pivot -> pivot value
		 * newPivot -> initialized to left, incremented when swapping two elements in the for-loop
		 */
		int pivot = myArray[pivotIndex];
		swap(myArray, right, pivotIndex);
		int newPivot = left;
		for (int i = left; i < right; i++){
			if (myArray[i] < pivot){
				swap(myArray, i, newPivot);
				newPivot++;
			}
		}
		swap(myArray, right, newPivot);
		return newPivot;
	}
	
	
	/**
	 * 
	 * @param myArray
	 * @param left
	 * @param right
	 */
	public static void quicksort(int[] myArray, int left, int right){
		/**
		 * while myArray > 1 elements, call quicksort recursively
		 */
		if (left < right){
			int pivot = choosePivot(myArray, left, right);
			int newPivot = partition(myArray, left, right, pivot);
			quicksort(myArray, left, newPivot - 1);
			quicksort(myArray, newPivot + 1, right);
		}
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SortingList test = new SortingList();
		int[] testList = test.getList();
		System.out.println(test.toString());
		System.out.println(test.checkSort());
		quicksort(testList, 0, testList.length-1);
		System.out.println(test.toString());
		System.out.println(test.checkSort());
	}

}
