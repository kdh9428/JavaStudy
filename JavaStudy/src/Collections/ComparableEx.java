package Collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ComparableEx {

	
	public static void main(String[] args) {
		Set<Person> asdd = new TreeSet<>();
//        asdd.add(new Person("aa",13));
//        asdd.add(new Person("as",16));
//        asdd.add(new Person("acv",1));
//        asdd.add(new Person("ac",3));
//        asdd.add(new Person("acd",4));
//        asdd.add(new Person("asc",20));

        for(Iterator<Person> itr = asdd.iterator(); itr.hasNext();){
            System.out.println(itr.next().toString());
        }
        
        Set<Integer> a = new TreeSet<>();
        a.add(132);
        a.add(11);
        a.add(3);
        a.add(131);
        for(int s : a)
        	System.out.println(s);
        
        Set<Person> te = new TreeSet<>(new PersonComparator());
        te.add(new Person("aa",13));
        te.add(new Person("as",16));
        te.add(new Person("acv",1));
        te.add(new Person("ac",3));
        te.add(new Person("acd",4));
        te.add(new Person("asc",20));
        System.out.println(te);

	}
}




class Person implements Comparable<Person>{
    private String name;
    private int age;
    
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public int setAge() {
    	return age;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return name+ " : "+age;
    }
    @Override
    public int compareTo(Person p) {
    	System.out.println(this.age+" 확인 : "+p);
    	int a = this.age - p.age;
    	System.out.println(a);
        return a;
    }
}

class PersonComparator implements Comparator<Person>{
    @Override
    public int compare(Person p1, Person p2) {
        return p2.setAge() - p1.setAge();
    }
}