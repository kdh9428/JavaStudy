package StreamEx;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MethodReferenceExam {

    public static void main(String[] args) {
        Arrays.asList(1, 2, 3, 4, 5)
                .forEach(i -> System.out.println(i));

        System.out.println(
        Arrays.asList(new BigDecimal("10.0"), new BigDecimal("23"), new BigDecimal("5"))
                .stream()
//                .sorted((a1,a2) -> a1.compareTo(a2))
//                .sorted(BigDecimalUtil::compare)
                .sorted(BigDecimal::compareTo)
                .collect(Collectors.toList())
        );

        String targetString = "Ces";
        System.out.println(
        Arrays.asList("A","B","C","D")
                .stream()
//                .anyMatch(x -> x.equals("C"))
                .anyMatch("C"::equals)
        );

        methodReference1();
    }


    private static void methodReference1(){
        /*First Class Function */
        /*
        Function can be passed as a parameter to another function.
        Using Lambda Expression
        * */
        System.out.println(testFirstClassFunction(3, i -> String.valueOf(i * 2)));

        /*
        * Using Method Reference
        * */
        System.out.println(testFirstClassFunction(3, MethodReferenceExam::doubleThenToString));


        /*
        * A function can be returned as the result of another function.
        * */

        /*
        Using Lambda Expression.
        * */

        Function<Integer, String> fl = getDoubleThenToString();
        String resultFromFl = fl.apply(10);
        System.out.println(resultFromFl);

        /*
        * Using Method Reference
        * */

        final  Function<Integer, String> fmr = getDoubleThenToStringNethodReference();
        String resultFromFmr = fmr.apply(10);
        System.out.println(resultFromFmr);

        System.out.println("==========================================================");
        /**
        * A function can be stored in the data structure.
        * */
        /*
        *  Using Lambda Expression
        * */

        final List<Function<Integer, String>> fsl = Arrays.asList(i -> String.valueOf(i * 2));
        for(final Function<Integer, String> f : fsl){
            String result = f.apply(3);
            System.out.println(result);
        }

        /*
        * Using Method Reference
        * */
        final List<Function<Integer,String>> fsMr = Arrays.asList(MethodReferenceExam::doubleThenToString);
        for(final Function<Integer, String> f : fsl){
            String result = f.apply(3);
            System.out.println(result);
        }

        /*
        * Using Lambda Expression
        * */
        final Function<Integer, String> fl2 = i -> String.valueOf(i * 2);
        String resultFl2 = fl2.apply(5);
        System.out.println(resultFl2);

        /*
        *  Method Reference
        * */

        final Function<Integer, String> fmr2 = MethodReferenceExam::doubleThenToString;
        String resultFmr2 = fmr2.apply(5);
        System.out.println(resultFmr2);

        /*
        * Both Lambda Expression and Method Reference
        * */
        List<Function<Integer, String>> fsBoth = Arrays.asList(i -> String.valueOf(i * 2),MethodReferenceExam::doubleThenToString,MethodReferenceExam::addHashPrefix);

        System.out.println("==========================================================");
        for (Function<Integer, String> fs: fsBoth) {
            String result = fs.apply(7);
            System.out.println(result);
        }


        final List<Function<Integer,String>> list = new ArrayList<>();
        list.add(MethodReferenceExam::doubleThenToString);
        list.add(MethodReferenceExam::additionThenToString);
        System.out.println("========================"+list.get(0).apply(10)
                +"\n 더하기"+ list.get(1).apply(10)
        );

        for(final Function<Integer, String> f : fsl){
            String result = f.apply(3);
            System.out.println(result);
        }


    }

    private static String addHashPrefix(int number){
        return "#" + number;
    }

    private static Function<Integer, String> getDoubleThenToStringNethodReference() {
        return MethodReferenceExam::doubleThenToString;
    }

    private static String doubleThenToString(int i){
        return String.valueOf(i * 2);
    }

    private static String additionThenToString(int i){
        return String.valueOf(i + 5);
    }

    private static String testFirstClassFunction(int n, Function<Integer, String> function){
        return "The result is " + function.apply(n);
    }

    private static Function<Integer, String> getDoubleThenToString(){
        return i -> String.valueOf(i * 2);
    }

}

class BigDecimalUtil{
    public static int compare(BigDecimal a1, BigDecimal a2){
        return a1.compareTo(a2);
    }
}