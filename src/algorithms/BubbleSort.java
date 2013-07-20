package algorithms;


import ListTools.SortingList;

public class BubbleSort {
	
	public static void bubble(int[] myArray){
		int temp;
		int inner;
		int outer;
		for (outer = myArray.length; outer > 0; outer--){
			for (inner = 0; inner < outer-1; inner++){
				if (myArray[inner] > myArray[inner+1]){
					temp = myArray[inner];
					myArray[inner] = myArray[inner+1];
					myArray[inner+1] = temp;
				}
			}
		}
		
	}

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
