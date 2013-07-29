
package algorithms;

import ListTools.SortingList;

/**
 * 
 * @author John H Moore	  john@jhmwebdesign.com
 * 
 * Java implementation of mergesort
 *
 */
public class MergeSort {

	/**
	 * 
	 * @param myArray -> array to be sorted
	 * @param start -> starting index for sorting
	 * @param end -> ending index for sorting
	 * 
	 * More specifically, myArray is sorted between myArray[start] and myArray[end]
	 */
	public static void mergesort(int[] myArray, int start, int end){
		/**
		 * lEnd -> left end (i.e. end of left half of myArray)
		 * rEnd -> right end (i.e. end of right half of myArray)
		 */
		int lEnd;
		int rEnd;
		if (end > 1){
			lEnd = end/2;
			rEnd = end - lEnd;

			mergesort(myArray, start, lEnd);
			mergesort(myArray, start + lEnd, rEnd);

			merge(myArray, start, lEnd, rEnd);

		}
	}
	
	
	/**
	 * 
	 * @param myArray -> array to be sorted
	 * @param start -> starting index for sorting
	 * @param lLength -> length of left half of myArray
	 * @param rLength -> length of right half of myArray
	 */
	private static void merge(int[] myArray, int start, int lLength, int rLength){
		/**
		 * temp -> temporary array used for sorting
		 * l -> left index
		 * r -> right index
		 * t -> temp index
		 * i -> index used for coppying temp back to myArray in sorted order
		 */
		int temp[] = new int[lLength + rLength];
		int l = 0;
		int r = 0;
		int t = 0;
		int i;

		while ( (l < lLength) && (r < rLength) ){
			if (myArray[start + l] < myArray[start + lLength + r]){
				temp[t++] = myArray[start + (l++)];
			}
			else{
				temp[t++] = myArray[start + lLength + (r++)];
			}
		}

		while (l < lLength){
			temp[t++] = myArray[start + (l++)];
		}

		while (r < rLength){
			temp[t++] = myArray[start + lLength + (r++)];
		}

		for (i = 0; i < lLength + rLength; i++){
			myArray[start + i] = temp[i];
		}
	}

	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		SortingList test = new SortingList();
		int[] testList = test.getList();
		int testLen = test.getLen();
		System.out.println(test.toString());
		System.out.println(test.checkSort());
		mergesort(testList, 0, testLen);
		System.out.println(test.toString());
		System.out.println(test.checkSort());
	}
}
