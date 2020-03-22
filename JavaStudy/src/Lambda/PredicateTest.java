package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredicateTest {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,5,7,9,11,12,113);
		int s;
		
		s = sum(dd -> dd%2 == 0, list);
		System.out.println("짝수의 합" + s);
		
		s = sum(a -> a%2 != 0, list);
		System.out.println("홀수의 합 "+ s);
		
		s = aaa((a,b) -> a<b ,list);
		System.out.println("b가 a보다 큰것만 더한다. "+ s);
		
		Supplier<Integer> spr = () -> {
			Random rand = new Random();
			return rand.nextInt(10);
		};
		
		List<Integer> list1 = makeIntList(spr, 10);
		System.out.println(list1);
		
		List<Integer> list2 = makeIntList(spr, 20);
		System.out.println(list2);
	}
	
	static int sum(Predicate<Integer> p, List<Integer> lst) {
		int s = 0;
		for(int n : lst) {
			if(p.test(n))
				s+=n;
		}
		return s;
	}
	
	static int aaa(BiPredicate<Integer, Integer> p, List<Integer> sss) {
		int s = 0;
		for(int n : sss){
			if(p.test(10, n))
				System.out.println(n);
				s+=n;
		}
		
		return s;
	}
	
	public static List<Integer> makeIntList(Supplier<Integer> s, int n){
		List<Integer> list = new ArrayList<>();
			
		for(int i = 0; i< n ; i++)
			list.add(s.get());
		
		return list;
	}
}
