
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
	 * @param mySortingList
	 * @param start
	 * @param end
	 */
	public static void mergesort(SortingList mySortingList, int start, int end){
		/**
		 * lEnd -> end of the left half
		 * rEnd -> end of the right half
		 */
		int lEnd;
		int rEnd;
		if (end > 1){
			lEnd = end/2;
			rEnd = end - lEnd;
			mergesort(mySortingList, start, lEnd);
			mergesort(mySortingList, start + lEnd, rEnd);
			merge(mySortingList, start, lEnd, rEnd);
		}
	}
	
	
	/**
	 * 
	 * @param mySortingList
	 * @param start
	 * @param lLength
	 * @param rLength
	 */
	public static void merge(SortingList mySortingList, int start, int lLength, int rLength){
		/**
		 * temp[] -> temporary array
		 * l -> iterator for left half
		 * r -> iterator for right half
		 * t -> iterator for temp array
		 */
		int temp[] = new int[lLength + rLength];
		int l = 0;
		int r = 0;
		int t = 0;
		
		while ( (l < lLength) && (r < rLength) ){
			if ( mySortingList.getVal(start + l) < mySortingList.getVal(start + lLength + r) ){
				temp[t++] = mySortingList.getVal(start + (l++));
			}
			else{
				temp[t++] = mySortingList.getVal(start + lLength + (r++));
			}
		}
		
		while (l < lLength){
			temp[t++] = mySortingList.getVal(start + (l++));
		}
		
		while (r < rLength){
			temp[t++] = mySortingList.getVal(start + lLength + (r++));
		}
		
		for (int i = 0; i < lLength + rLength; i++){
			mySortingList.setVal(start + i, temp[i]);
		}
	}

	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		SortingList test = new SortingList();
		//int[] testList = test.getList();
		//int testLen = test.getLen();
		System.out.println(test.toString());
		System.out.println(test.checkSort());
		mergesort(test, 0, test.getLen());
		//mergesort2(testList, 0, testLen);
		System.out.println(test.toString());
		System.out.println(test.checkSort());
	}
}
