package StreamEx;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamAPIExample {
	public static void main(String[] args) {

		System.out.println(
			Stream.of(1,3,3,5,5)
			.filter( i -> i >2)
			.map(i -> i *2)
			.map(i -> "# "+i)
			.collect(toList())
			);
		
		System.out.println(
			Stream.of(1,3,3,5,5)
			.filter( i -> i >2)
			.map(i -> i *2)
			.map(i -> "# "+i)
			.collect(toSet())
			);

		System.out.println(
			Stream.of(1,3,3,5,5)
			.filter( i -> i >2)
			.map(i -> i *2)
			.map(i -> "# "+i)
			.collect(joining())
			);

		System.out.println(
			Stream.of(1,3,3,5,5)
			.filter( i -> i >2)
			.map(i -> i *2)
			.map(i -> "# "+i)
			.collect(joining(", "))
			);

		System.out.println(
				Stream.of(1,3,3,5,5)
						.filter( i -> i >2)
						.map(i -> i *2)
						.map(i -> "# "+i)
						.collect(joining(", ", "[","]"))
		);

		System.out.println(
				Stream.of(1,3,3,5,5)
						.filter( i -> i >2)
						.map(i -> i *2)
						.map(i -> "# "+i)
						.distinct()
						.collect(joining(", ", "[","]"))
		);

		System.out.println(
				Stream.of(1,3,3,5,5)
						.filter( i -> i >2)
						.map(i -> i *2)
						.map(i -> "# "+i)
						.distinct()
						.collect(toList())
		);

		final Integer i1 = 128;
		System.out.println(
				Stream.of(1, 2, 3, 4, 5,128)
						.filter(i -> i.equals(i1))
						.findFirst()
		);

		System.out.println(
				Stream.of(1, 2, 3, 4, 5,128)
						.filter(i -> i > 3)
						.count()
		);

		final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		for (Integer i : numbers){
			System.out.println("i = "+ i);
		}
		System.out.println( 
				Stream.of(1, 2, 3, 4, 5,128)
						.filter(i -> i > 3)
						.count()
		);
	}
}
