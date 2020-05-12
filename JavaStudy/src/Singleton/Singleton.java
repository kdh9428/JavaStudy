package Singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Singleton {
    public static void main(String[] args) {

        System.out.println("start==========================================");
        System.out.println(OldSingleton.NAME);

        System.out.println("1=============================================");
        final OldSingleton oldSingleton1 = OldSingleton.SINGLETON;
        System.out.println("2=============================================");
        final OldSingleton oldSingleton2 = OldSingleton.SINGLETON;

        OldSingleton singleton = OldSingleton.SINGLETON;
        System.out.println("oldSingleton1 == oldSingleton2 : "+ (oldSingleton1 == oldSingleton2));

        System.out.println();
        System.out.println("start==========================================");
        System.out.println(LazySingleton.NAME);

        System.out.println("1=============================================");
        final LazySingleton lazySingleton1 = LazySingleton.getInstance();
        System.out.println("2=============================================");
        final LazySingleton lazySingleton2 = LazySingleton.getInstance();

        System.out.println("lazySingleton1 == lazySingleton2 : " +(lazySingleton1 == lazySingleton2));

        List<String> ls = Arrays.asList("Box", "Simple", "Complex", "Robot", "testttesttt");

        BinaryOperator<String> stringBinaryOperator = (s1,s2)->{
            if (s1.length() > s2.length())
                return s1;
            else
                return s2;
        };

        String str = ls.parallelStream()
                    .reduce("", (s1, s2)->{
                        if (s1.length() > s2.length()) {
                            System.out.println("테스트 확인하기 :" + s1);
                            return s1;
                        }else{
                            System.out.println("테스트 확인하기 :" + s2);
                            return s2;
                        }
                            });

        System.out.println(str);

        List<String> s1 = Arrays.asList("Toy", "Rot", "Box");
        List<String> s2 = Arrays.asList("A", "B", "C", "BB", "A");
        List<String> s3 = Arrays.asList("AB", "BB", "CC", "A", "BB");

        Stream.of(s1, s2, s3)
                .distinct()
                .forEach(System.out::println);
        Stream.of(s1, s2, s3)
                .filter(s ->{
                    System.out.println("filter was colled."+s);

                    return s.equals("A");
                }).forEach(s -> System.out.println(s));

        final List<List<String>> ss = Arrays.asList(s1, s2, s3);

        final List<List<String>> testCode1 = Arrays.asList(s1, s2, s3);
        System.out.println("Start ==========================");
//        List<List<String>> testList1 =
                testCode1.stream().filter(t -> {
                    System.out.println(t);
                    boolean s = false;
                    for (String as : t){
                        s =as.contains("B");
                        System.out.println(as +" 확인 B: "+t+" : "+ s);
                    }
                    return s;
                })
                .forEach(System.out::println);
//        System.out.println(testList1);

        System.out.println("Start1 ===========================");
        testCode1.stream().filter(s -> {
            System.out.println("s.get(0) = "+s.get(0)+" , "+s.get(0).contains("B"));
            System.out.println("s.get(1) = "+s.get(1)+" , "+s.get(1).contains("B"));
            System.out.println("s.get(2) = "+s.get(2)+" , "+s.get(2).contains("B"));
            System.out.println("==============s.contains(\"B\")=================");
            System.out.println(s+" = " + s.contains("B"));
            return s.contains("B");
        }).peek(s -> System.out.println("============"+s)).forEach(s-> System.out.println("s==========s"+s));



        List<List<String>> test = new ArrayList<>();
        System.out.println("테스트1============= List<String> sa : ss");
        for (List<String> sa : ss){
            if (sa.contains("A")) {
                System.out.println(sa);
                test.add(sa);
            }
            else
                System.out.println("A아님");
        }
        System.out.println("테스트2=============");

        ss.stream()
                .filter(s -> s.stream().allMatch(ad -> ad.contains("B")))
                .forEach(System.out::println);

        Stream<String> stream1 = s1.stream();
        Stream<String> stream2 = s2.stream();
        Stream<String> stream3 = s3.stream();

        System.out.println("테스트3=============");
        List<String> str1Addstr2 = Stream.concat(stream1,stream2)
                .filter(s -> s.contains("B"))
                .collect(Collectors.toList());
        System.out.println(str1Addstr2);
        System.out.println("테스트4=============");
        List<List<String>> listWithStream = ss.stream()
                                        .filter(s -> s.contains("A"))
                                        .collect(Collectors.toList());
        System.out.println(listWithStream);
        System.out.println("테스트5=============");
        String aaa1 = "aa";
        String aaa2 = "가나";
        System.out.println("aa : " +aaa1.length());
        System.out.println("가나 : " +aaa2.length());


        System.out.println("3====================");
        List<String> test1 = new ArrayList<>();

        for (List<String> sdf : ss){
            for (String ass : sdf){
                if(ass.contains("A")){
                    test1.add(ass);
                }
            }
        }
        System.out.println("test1 : " +test1);
        s1.stream().filter(string -> string.contains("T")).forEach(System.out::println);

    }
}



class OldSingleton{

    public static final String NAME = new String("OldSingleton");

    public static final OldSingleton SINGLETON = new OldSingleton();

    private OldSingleton(){
        System.out.println("test Hi!");
    }

    public void greet(final String name){
        System.out.println("Hello"+ name + "!");
    }
}

class LazySingleton{
    protected static final String NAME = new String("LazySingleton");

    private static final class LazySingletionHolder{
        private static final LazySingleton INSTANCE = new LazySingleton();
    }
    public static LazySingleton getInstance(){
        return LazySingletionHolder.INSTANCE;
    }
    private LazySingleton() {
        System.out.println("test Hi!gg");
    }
    public void greet(final String name){
        System.out.println("Hello"+ name + "!");
    }
}