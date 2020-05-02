package xyz.springboot.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MethodReference {
    

	public static void main(String[] args) {
    	
    	List<Integer> ls = Arrays.asList(1,3,4,7,8);
    	
    	ls = new ArrayList<Integer>(ls);
    	
    	Consumer<List<Integer>> cs = new Consumer<List<Integer>>() {
    		
    		@Override
    		public void accept(List<Integer> l) {
    			Collections.reverse(l);
    		}
    	};
    	
    	ls.forEach(System.out::println);
    	JustSort justSort = new JustSort();
    	
    	Collections.reverse(ls);
    	System.out.println("테스트"+ls);
    	
    	Consumer<List<Integer>> c = l -> Collections.reverse(l);
    	c.accept(ls);
    	System.out.println(ls);
    	
    	Consumer<List<Integer>> c2 = Collections::reverse;
    	c2.accept(ls);
    	System.out.println(ls);
    	
    	Consumer<List<Integer>> c3 = asdf -> justSort.sort(asdf);
    	c3.accept(ls);
    	System.out.println(ls);
    	
    	Consumer<List<Integer>> c4 = justSort::sort;
    	c4.accept(ls);
    	System.out.println(ls);
    	
    	Collections.sort(ls,new Comparator<Integer>() {
    		@Override
    		public int compare(Integer o1, Integer o2) {
    			
    			return o1.compareTo(o2);
    		}
		});
    	System.out.println(ls);
    	
    	List<Fruit> fruits = Arrays.asList(new Fruit("apple","red"),new Fruit("melon","green"),new Fruit("banana","yellow"),new Fruit("fc","red"),new Fruit("appl","red"));
    	
    	
    	List<Fruit> appleList = extractFruitList(fruits, new Predicate<Fruit>() {
			
			@Override
			public boolean test(Fruit fruit) {
				return "apple".equals(fruit.getName());
			}
		});

//    	System.out.println(appleList.get(0).getName());
    	
    	List<Fruit> redList = extractFruitList(fruits, a -> "red".equals(a.getColor()));
    	for(Fruit a : redList)
    		System.out.println(a.getName());
    }
	
	static List<Fruit> extractFruitList(List<Fruit> fruits, Predicate<Fruit> predicate){
		List<Fruit> resultList = new ArrayList<Fruit>();
		for(Fruit fruit : fruits) {
			if(predicate.test(fruit)) {
				resultList.add(fruit);
			}
		}
		return resultList;
	}
	
	
}

class Fruit{
	
	private String name;
	private String color;
	
	public Fruit(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getColor() {
		return color;
	}

	void setColor(String color) {
		this.color = color;
	}
	
}