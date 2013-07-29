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
	 * 
	 * @param mySortingList
	 */
	public static void bubblesort(SortingList mySortingList){
		/**
		 * inner -> iterator for inner for-loop
		 * outer -> iterator for outer for-loop
		 */
		int inner;
		int outer;
		for (outer = mySortingList.getLen(); outer > 0; outer--){
			for (inner = 0; inner < outer-1; inner++){
				if (mySortingList.getVal(inner) > mySortingList.getVal(inner + 1)){
					mySortingList.swap(inner, inner+1);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SortingList test = new SortingList(10);
		System.out.println(test.toString());
		System.out.println(test.checkSort());
		bubblesort(test);
		System.out.println(test.toString());
		System.out.println(test.checkSort());
	}

}
