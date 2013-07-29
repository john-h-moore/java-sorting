package ListTools;

import java.util.Random;
import java.util.Arrays;

/**
 * 
 * @author John H Moore	  john@jhmwebdesign.com
 *
 * The main purpose of the SortingList class is primarily educational (for me).
 * Everything done in the SortingList class could be done simply by copying and pasting
 * a few code snippets into the various sorting algorithm classes for testing purposes.
 * Instead, I'm using SortingLists as a chance to practice working with multiple classes
 * and packages in one project.
 *
 */
public class SortingList {
	/**
	 * len -> length of the SortingList's numList
	 * numList -> an array of integers
	 * myMin -> user-defined minimum value
	 * myMax -> user-defined maximum value
	 */
	private int len;
	private int[] numList;
	int myMin;
	int myMax;
	
	/**
	 * Default constructor
	 * len = 100
	 * myMin = 0
	 * myMax = 100
	 */
	public SortingList(){
		len = 100;
		numList = populateList(len, 0, 100);
	}
	
	/**
	 * 
	 * @param numElems -> len
	 * myMin = 0
	 * myMax = 100
	 */
	public SortingList(int numElems){
		len = numElems;
		numList = populateList(len, 0, 100);
	}
	
	/**
	 * 
	 * @param numElems -> len
	 * @param min -> myMin
	 * @param max -> myMax
	 */
	public SortingList(int numElems, int min, int max){
		len = numElems;
		myMin = min;
		myMax = max;
		numList = populateList(len, myMin, myMax);
	}
	
	/**
	 * Populates numList using numElems, min, and max
	 * @param numElems
	 * @param min
	 * @param max
	 * @return l (populated numList)
	 */
	private static int[] populateList(int numElems, int min, int max){
		Random randNum = new Random();
		int[] l = new int[numElems];
		for (int i = 0; i < numElems; i++){
			l[i] = randNum.nextInt(max - min + 1) + min;
		}
		return l;
	}
	
	/**
	 * Calls Arrays.toString() on numList
	 */
	public String toString(){
		return Arrays.toString(this.numList);
	}
	
	/**
	 * 
	 * @return numList
	 */
	public int[] getList(){
		return this.numList;
	}
	
	/**
	 * 
	 * @return len
	 */
	public int getLen(){
		return this.len;
	}
	
	/**
	 * 
	 * @return true if sorted, false if not sorted
	 */
	public boolean checkSort(){
		for (int i = 1; i < this.len; i++){
			if (this.numList[i] < this.numList[i-1]){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param i -> index
	 * @param v -> value
	 */
	public void setVal(int i, int v){
		this.numList[i] = v;
	}
	
	/**
	 * 
	 * @param i
	 * @param j
	 * swap numList[i] and numList[j]
	 */
	public void swap(int i, int j){
		int temp = this.numList[i];
		this.numList[i] = this.numList[j];
		this.numList[j] = temp;
	}
	
	/**
	 * 
	 * @param i -> index
	 * @return numList[i]
	 */
	public int getVal(int i){
		return this.numList[i];
	}
	
}
