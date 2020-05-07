package StreamEx;

import MethodReference.Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {

        final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
            Integer result = null;
        for (final Integer number : numbers) {
            if (number > 3 && number< 9){
                Integer newNumber = number * 2;
                if (newNumber > 20) {
                    result = newNumber;
                    break;
                }
            }
        }
        System.out.println(result);

        System.out.println(
        numbers.stream()
                .filter(number -> number > 3 && number < 9)
                .map(number -> number * 2)
                .filter(number -> number > 10)
                .findFirst()
        );
    }
}
