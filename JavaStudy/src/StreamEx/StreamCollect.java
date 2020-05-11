package StreamEx;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamCollect {
    public static void main(String[] args) {
        List<String> s1 = Arrays.asList("Toy", "Rot", "Box");
        List<String> s2 = Arrays.asList("A", "B", "C", "BB", "A");
        List<String> s3 = Arrays.asList("AB", "BB", "CC", "A", "BB");


        List<String[]> list = Stream.of(s1, s2, s3)
                .filter(s -> s.contains("A"))
                .map(s -> s.toArray(String[]::new))
                .peek(s -> System.out.println(s))
                .collect(Collectors.toList());

        Stream<Student> studentStream = Stream.of(
                new Student("나자바", true, 1, 1, 300, Student.sex.여),
                new Student("가나다", false, 1, 1, 250, Student.sex.여),
                new Student("김자바", true, 1, 1, 200, Student.sex.남),
                new Student("이지미", false, 1, 2, 50, Student.sex.여),
                new Student("나자바", false, 1, 3, 100, Student.sex.여),

                new Student("가나다", false, 2, 1, 250, Student.sex.여),
                new Student("김자바", true, 2, 1, 200, Student.sex.남),
                new Student("이지미", false, 2, 2, 50, Student.sex.여),
                new Student("나자바", false, 2, 3, 100, Student.sex.여)
        );

        Map<Boolean, List<Student>> studentBySex = studentStream
                .collect(Collectors.partitioningBy(s -> s.getIsSex() == Student.sex.여));

        List<Student> maleStudent = studentBySex.get(false);
        maleStudent.stream().forEach(System.out::println);

        studentBySex.get(true).stream().forEach(System.out::println);

    }
}