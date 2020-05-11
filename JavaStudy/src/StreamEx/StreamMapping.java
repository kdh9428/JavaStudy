package StreamEx;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMapping {
    public static void main(String[] args) {
        Stream.of("My_AGE","YOUR_LIFE")
                .flatMap(s -> Arrays.stream(s.split("_")))
                .forEach(System.out::println);

        ReportCard[] cards = {
                new ReportCard(70, 80, 90),
                new ReportCard(90, 80, 70),
                new ReportCard(80, 80, 80)
        };

        double as = Arrays.stream(cards)
                .flatMapToInt(r -> IntStream.of(r.getEng(), r.getKor(), r.getMath()))
                .average().getAsDouble();
        System.out.println("avg : " + as);

    }
}

@Data
@AllArgsConstructor
class ReportCard{
    private int kor;
    private int eng;
    private int math;
}