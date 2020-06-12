package DateAndTime;

import java.time.*;

public class DateAndTime {

    public static void main(String[] args) {
        Instant start = Instant.now();

        System.out.println("시작 : "+ start.getEpochSecond());

        System.out.println("Time flies like an arrow.");

        Instant end = Instant.now();
        System.out.println("타임 끝 : "+ end.getEpochSecond());

        Duration between = Duration.between(start, end); //두 시각의 차 계산

        System.out.println("밀리 초 단위 차이 : " + between.toMillis());

        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDate local = LocalDate.of(2012, 12, 31);
        System.out.println(local);
        LocalDate localDate = local.minusDays(2);
        LocalDate localDate1 = localDate.plusDays(2);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalTime d = LocalTime.now();
        System.out.println(d);

        LocalTime mt = d.minusHours(1);
        mt = mt.plusMinutes(60);
        System.out.println(mt);

        LocalTime start1 = LocalTime.of(14,24,35);
        System.out.println("이용 시작 시각 : "+ start1);

        LocalTime end1 = LocalTime.of(17,31,19);
        System.out.println("종료 시각 : "+ end1);

        Duration between1 = Duration.between(start1,end1);
        System.out.println("총 이용 시간 : "+ between1);

    }
}
