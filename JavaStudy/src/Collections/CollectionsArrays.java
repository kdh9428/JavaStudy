package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CollectionsArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 1차원 배열의 출력 toString()
		 * 다차원 배열의 출력 deeptoString()
		 */		
		
		int []arr = {0,1,2,3,4};
		int []arr2 = {0,1,2,3,4};
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
		System.out.println(Arrays.equals(arr, arr2));
		
		
		/* 
		 * 배열의 복사 : copyOf(), copyOfRange()
		 *  System.arraycopy()는 배열을 생성해서 복사해야 한다.
		 */ 
		
		
		/* 배열 채우기 : fill(), setAll() */
		
		
		/* 배열을 List로 변환 : asList(Object...) 
		 *
		 * */
		List list = Arrays.asList(new Integer[] {1,2,3,4,5});
		List list1 = Arrays.asList(new Integer[] {1,2,3,4,5});
//		list.add(6); //UnsupportedOperationException 예외 발생. asList는 읽기 전용으로 반환한다. list의 크기를 변경할 수 없음.
		System.out.println(list);
		List list3 = new ArrayList(Arrays.asList(1,2,3,4,5)); //asList를 생성해서 사용해야 한다.
		list3.add(6);
		System.out.println(list3);
		
		/* 배열의 정렬과 검색 - sort(), binarySearch() */
		
		int []aar = {3,2,0,1,4,6}; //정렬 되지 않은 배열
		int idx = Arrays.binarySearch(aar, 2); //idx =-5 잘못된 결과 , 배열에 2가 없으면 음수 반환(정렬되지 않은 상태에서 binarySearch를 했기 때문)
		System.out.println(idx);
		Arrays.sort(aar);//배열 정렬
		System.out.println(aar);
		int idx1 = Arrays.binarySearch(aar, 2); //idx =2 배열의 저장된 2값의 위치를 반환한다.
		System.out.println(idx1);
		
		/*
		 * 순차 검색 - 처음부터 순서대로 검색한다. 
		 * 이진검색(이분검색, binary Search) - 범위를 전반으로 나눠가면 검색(정렬 필수)
		 */
		
		
		/*
		 * 배열과 컬렉션의 정렬 기준 
		 * 객체를 정렬하는데 필요한 메서드를 정의한 인터페이스 (정렬 기준을 제공) 
		 * Comparable - 기본 정렬기준을 구현하는데 사용. 
		 * Comparator - 기본 정렬기준 외에 다른 기준으로 정렬하고자할 때 사용
		 */
		
		
		Student[] sArr = {
				new Student(100, "abc"),
				new Student(300, "aaa"),
				new Student(400, "ccc"),
				new Student(200, "bbb"),
				new Student(500, "csf"),
		};
		Arrays.sort(sArr);
		System.out.println(Arrays.toString(sArr));
		
		Arrays.sort(sArr, new NameAscending());
		System.out.println(Arrays.toString(sArr));
	}
	
static class NameAscending implements Comparator{
	
	public int compare(Object o1, Object o2) {
		
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		
//		return s1.name.compareTo(s2.name);
		return s2.name.compareTo(s1.name);
	}
		
}
	
static class Student implements Comparable{
	int score;
	String name;
	
	public Student(int score, String name) {
		this.score = score;
		this.name = name;
	}
	
	@Override
	public int compareTo(Object obj) {
		//정수로 정렬
		Student s2 = (Student) obj;
		
//		return this.score - s2.score;
		return s2.score-this.score;
	}
	
	public String toString() {
		return score + " , " +name;
	}
}

}
