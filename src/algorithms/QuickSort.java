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
	 * 
	 * @param mySortingList
	 * @param left
	 * @param right
	 * @return median(left, right, (left + right)/2)
	 */
	private static int choosePivot(SortingList mySortingList, int left, int right){
		int first = mySortingList.getVal(left);
		int middle = mySortingList.getVal((left + right)/2);
		int last = mySortingList.getVal(right);
		
		if ( (first <= middle) && (middle <= last) ){
			return (left + right)/2;
		}
		else if( (first <= last) && (last <= middle) ){
			return right;
		}
		else{
			return left;
		}
	}
	
	
	/**
	 * 
	 * @param mySortingList
	 * @param left
	 * @param right
	 * @param pivotIndex
	 * @return newPivot
	 */
	private static int partition(SortingList mySortingList, int left, int right, int pivotIndex){
		int pivot = mySortingList.getVal(pivotIndex);
		mySortingList.swap(right, pivotIndex);
		int newPivot = left;
		for (int i = left; i < right; i++){
			if (mySortingList.getVal(i) < pivot){
				mySortingList.swap(i, newPivot);
				newPivot++;
			}
		}
		mySortingList.swap(right, newPivot);
		return newPivot;
	}
	

	/**
	 * 
	 * @param mySortingList
	 * @param left
	 * @param right
	 */
	public static void quicksort(SortingList mySortingList, int left, int right){
		if (left < right){
			int pivot = choosePivot(mySortingList, left, right);
			int newPivot = partition(mySortingList, left, right, pivot);
			quicksort(mySortingList, left, newPivot - 1);
			quicksort(mySortingList, newPivot + 1, right);
		}
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SortingList test = new SortingList();
		System.out.println(test.toString());
		System.out.println(test.checkSort());
		quicksort(test, 0, test.getLen()-1);
		System.out.println(test.toString());
		System.out.println(test.checkSort());
	}

}
