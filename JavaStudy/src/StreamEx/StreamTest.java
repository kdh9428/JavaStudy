package StreamEx;

import java.util.*;

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

        Map<String, String> a = new HashMap<>();
        List list = new ArrayList();
        a.put("k","apple");

        list.add(a);
        a.put("k", "banana");
        System.out.println(a);
        System.out.println(list.toString());
        list.add(a);
        System.out.println("테슽 ++++");

        list.stream().forEach(System.out::println);
        a.forEach((a1, a2)-> System.out.println("key"+a1+" ,"+"value : "+ a2));


        }
    }

