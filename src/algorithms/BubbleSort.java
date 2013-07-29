package algorithms;

import ListTools.SortingList;

/**
 * 
 * @author John H Moore	  john@jhmwebdesign.com
 * 
 * Java implementation of bubblesort
 *
 */
public class BubbleSort {
	
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
	 * 
	 * @param myArray -> array to be sorted
	 * Takes array as input, sorts in place using bubblesort
	 */
	public static void bubble(int[] myArray){
		/**
		 * inner -> increment inner for-loop
		 * outer -> decrement outer for-loop
		 */
		int inner;
		int outer;
		for (outer = myArray.length; outer > 0; outer--){
			for (inner = 0; inner < outer-1; inner++){
				if (myArray[inner] > myArray[inner+1]){
					swap(myArray, inner, inner+1);
				}
			}
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
		bubble(testList);
		System.out.println(test.toString());
		System.out.println(test.checkSort());
	}

}
