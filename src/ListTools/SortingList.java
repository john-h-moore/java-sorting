package ListTools;
import java.util.Random;
import java.util.Arrays;

public class SortingList {
	private int len;
	private int[] numList;
	int myMin;
	int myMax;
	
	public SortingList(){
		len = 100;
		numList = populateList(len, 0, 100);
	}
	
	public SortingList(int numElems){
		len = numElems;
		numList = populateList(len, 0, 100);
	}
	
	public SortingList(int numElems, int min, int max){
		len = numElems;
		myMin = min;
		myMax = max;
		numList = populateList(len, myMin, myMax);
	}
	
	private static int[] populateList(int numElems, int min, int max){
		Random randNum = new Random();
		int[] l = new int[numElems];
		for (int i = 0; i < numElems; i++){
			l[i] = randNum.nextInt(max - min + 1) + min;
		}
		return l;
	}
	
	public String toString(){
		return Arrays.toString(this.numList);
	}
	public int[] getList(){
		return this.numList;
	}
	
	public int getLen(){
		return this.len;
	}
	
	public boolean checkSort(){
		for (int i = 1; i < this.len; i++){
			if (this.numList[i] < this.numList[i-1]){
				return false;
			}
		}
		return true;
	}
}
