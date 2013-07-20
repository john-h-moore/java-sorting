package algorithms;

import java.util.Arrays;

import ListTools.SortingList;

public class MergeSort {


	public static void mergesort(int[] myArray, int start, int end){
		int lEnd;  // left end (i.e. end of left half of array)
		int rEnd;  // right end (i.e. end of right half of array)
		if (end > 1){
			lEnd = end/2;
			rEnd = end - lEnd;

			mergesort(myArray, start, lEnd);
			mergesort(myArray, start + lEnd, rEnd);

			merge(myArray, start, lEnd, rEnd);

		}
	}
	

	private static void merge(int[] myArray, int start, int lLength, int rLength){
		int temp[] = new int[lLength + rLength];  // temp array for sorting
		int l = 0; // left index
		int r = 0; // right index
		int t = 0; // temp index
		int i; // Use for copying temp back to myArray

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

	public static void main(String[] args){
		SortingList test = new SortingList();
		int[] testList = test.getList();
		int testLen = test.getLen();
		System.out.println(Arrays.toString(testList));
		System.out.println(test.checkSort());
		mergesort(testList, 0, testLen);
		System.out.println(Arrays.toString(testList));
		System.out.println(test.checkSort());
	}
}
