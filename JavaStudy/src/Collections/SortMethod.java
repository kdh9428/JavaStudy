package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SortMethod {
	
	public static void main(String[] args) {
		
		
		List<String> list = Arrays.asList("sss", "bbb", "ccc","aaa");
		list = new ArrayList<>(list);
		
		//정렬 이전에 출력
		for(Iterator<String> a = list.iterator(); a.hasNext();)
			System.out.print(a.next()+"\t");
		System.out.println();
		
		//정렬
		Collections.sort(list);
		
		//정렬 이후 출력
		for(Iterator<String> a = list.iterator();a.hasNext();)
			System.out.print(a.next()+"\t");
		System.out.println();
		
		
		//super T 제네릭
		
		List<Car> li = new ArrayList<Car>();
		li.add(new Car(1200));
		li.add(new Car(3000));
		li.add(new Car(1800));
		li.add(new Car(2154));
		
		//인스턴스를 정렬을 하기 위해선 Comparable 인터페이스를 구현해야한다.
		Collections.sort(li);
		
		for(Iterator<Car> a = li.iterator();a.hasNext();)
			System.out.print(a.next().toString()+"\t");
		System.out.println();
		System.out.println("======");
		List<ECar> lis = new ArrayList<ECar>();
		lis.add(new ECar(123));
		lis.add(new ECar(552));
		lis.add(new ECar(012));
		lis.add(new ECar(32));
		
		Collections.sort(lis);
		
		for(Iterator<ECar> a = lis.iterator();a.hasNext();)
			System.out.print(a.next()+"\t");
			System.out.println();
			
		System.out.println(lis.get(3));
	}
}

class Car implements Comparable<Car>{
	private int disp;
	public Car(int d) {disp=d;}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "배기량 : "+disp;
	}
	@Override
	public int compareTo(Car o) {
		return disp - o.disp;
	}
}

class ECar extends Car{
	private int dd;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ECar의 배기량 : "+dd;
	}
	public ECar(int d) {
		super(d);
		dd = d;
	}
}

