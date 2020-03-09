package Collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CollectionsHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * HashSet(순서X,중복X) 
		 * Set인터페이스를 구현한 대표적인 컬렉션 클래스 
		 * 순서를 유지하려면, LinkedHashSet 클래스를 사용하면 된다.
		 */
		Object[] objArr = {"1",new Integer(1),"2","2","3","4"}; //1은 문자열 Integer(1)은 인티저 객체이기 때문에 중복 가능 
		Set set = new HashSet();
		
		for(int i=0;set.size() < 6; i++)
			set.add((int)(Math.random()*45+1));
		
		//Set을 정렬하기 위해서 List형으로 변경
		List list = new LinkedList(set);
		
		//정렬
		Collections.sort(list);
		
		System.out.println(list);
		
		//빙고판 예제 11-22
		
		Set set1 = new LinkedHashSet();
		int[][] board = new int[5][5];
		
		while(set1.size() <25) {
			set1.add((int)(Math.random()*50)+1+"");
		}
		
		Iterator it = set1.iterator();
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length;j++) {
				board[i][j] = Integer.parseInt((String)it.next());
				System.out.print((board[i][j] < 10 ? " 0" : " ")+board[i][j]);
			}
			System.out.println();
		}
		
		
		HashSet hashset = new HashSet();
		
		hashset.add(new Person("David", 10));
		hashset.add(new Person("David", 10));
		
		System.out.println(hashset);
		
	}
	
static class Person{
		String name;
		int age;
		
		public Person(String name , int age) {
			this.name = name;
			this.age = age;
		}
		
		public boolean equals(Object obj) {
			if(obj instanceof Person) {
				Person tmp = (Person) obj;
				return name.equals(tmp.name) && age == tmp.age;
			}
			return false;
		}
		
		public int hashCode() {
			
//		return (name+age).hashCode();
		return Objects.hash(name,age); //jdk1.8
		}
		
		public String toString() {
			return name + ":" + age;
		}
	}
	

}
