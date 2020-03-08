package Collections;

import java.util.Arrays;

public class CollectionsArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 1차원 배열의 출력 toString()
		 * 다차원 배열의 출력 deeptoString()
		 */		
		
		int []arr = {0,1,2,3,4};
		int [][] arr2D = {{11,12}, {21,22}};
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.deepToString(arr2D));
		
		/*
		 * 1차원 배열의 비교 : equals() 
		 * 다차원 배열의 비교 : deepEquals()
		 */
		
		String [][] str2D = new String[][] {{"aaa","bbb"},{"aaa","bbb"}};
		String [][] str2D2 = new String[][] {{"aaa","bbb"},{"aaa","bbb"}};
		
		System.out.println(Arrays.equals(str2D, str2D2));
		System.out.println(Arrays.deepEquals(str2D, str2D2));
	}

}
