package StreamEx;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class StreamExampleParallel {

    public static void main(String[] args) {

//        final int[] sum = {0};
//        IntStream.range(0, 100)
//                .forEach(i -> sum[0] += i);
//        System.out.println("sum : " + sum[0]);
//
//        final int[] sum2 = {0};
//        IntStream.range(0, 100)
//                .parallel()
//                .forEach(i -> sum2[0] += i);
//        System.out.println("parallel sum(with side-effect) : " + sum2[0]);
//
//        System.out.println("stream sum (with side-effect)" +
//                IntStream.range(0, 100)
//                        .sum()
//        );
//
//        System.out.println("parallel stream sum (no with side-effect)" +
//                IntStream.range(0, 100)
//                        .parallel()
//                        .sum()
//        );
//
//
//        final long start = System.currentTimeMillis();
//        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
//                .stream()
//                .map(i -> {
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    return  i;
//                })
//                .forEach(i -> System.out.println(i));
//        System.out.println(System.currentTimeMillis()-start);
//
//        System.out.println("=============================================");
//        final long start1 = System.currentTimeMillis();
//        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
//                .parallelStream()
//                .map(i -> {
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    return  i;
//                })
//                .forEach(i -> System.out.println(i));
//        System.out.println(System.currentTimeMillis()-start1);
//
//    System.out.println("=============================================");
//        final long start3 = System.currentTimeMillis();
//        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
//                .parallelStream()
//                .map(i -> {
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    return  i;
//                })
//                .forEach(i -> System.out.println(i));
//        System.out.println(System.currentTimeMillis()-start3);

        System.out.println("=============================================");
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","0");
        final long start4 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
                .parallelStream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return  i;
                })
                .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis()-start4);

        System.out.println("=============================================");
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","3");
        final long start5 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
                .parallelStream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return  i;
                })
                .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis()-start5);

        System.out.println("=============================================");
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","1");
        final long start6 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
                .parallelStream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return  i;
                })
                .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis()-start6);
    }
}
