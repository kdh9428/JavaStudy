package StreamEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HigherOrderFunctionExam {

    public static void main(String[] args) {
        final Function<Function<Integer, String>, String> f = g -> g.apply(10);

        System.out.println(f.apply(i -> "#"+i));

        final Function<Integer, Function<Integer, Integer>> f2 = i -> i2 -> i + i2;

        System.out.println(
                f2.apply(1).apply(9)
        );

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(map(list, i -> " #"+i));

        System.out.println(
        list.stream()
                .map(integer -> "#"+ integer)
                .collect(Collectors.toList())
        );

        Function<Integer, Function<Integer, Function<Integer, Integer>>> func = i1 -> i2 -> i3 -> i1 + i2 + i3;
        Function<Integer, Function<Integer, Integer>> func10 = func.apply(10);
        System.out.println(
                "func10.apply(2).apply(3) : "+func10.apply(2).apply(3)
        );
    }
    private static <T, R> List<R> map(List<T> list, Function<T, R> mapper){
        final List<R> result = new ArrayList<>();
        for (final T t : list) {
            result.add(mapper.apply(t));
        }
        return result;
    }
}
