package DateAndTime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Zoned {

    public static void main(String[] args) {

        ZoneId paris = ZoneId.of("Asia/Seoul");

        System.out.println(paris);

        ZoneId.getAvailableZoneIds()
                .stream()
                .filter(s -> s.endsWith("Seoul"))
                .sorted()
                .forEach(System.out::println);

        LocalDateTime dateTime = LocalDateTime.of(2015,12,31,12,34,56);

        ZonedDateTime time = LocalDate.now().atStartOfDay(paris);
        ZonedDateTime time1 = dateTime.atZone(paris);
        System.out.println(time1);
        System.out.println(time);


        ZonedDateTime a1 = ZonedDateTime.now();
        ZonedDateTime a2 = ZonedDateTime.of(2020,05,12,01,53,11,25134200,paris);
        System.out.println("==============================");
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a1.toLocalDateTime());

        ZonedDateTime here = ZonedDateTime.now();
        System.out.println("현재 날짜 시간 : " +here);

        ZonedDateTime paris1 = ZonedDateTime.of(

                here.toLocalDateTime(), ZoneId.of("Europe/Paris")
       );

        Duration diff = Duration.between(here, paris1);
        System.out.println("한국과 유럽/파리의 시차는? : " + diff);

        ZonedDateTime departure = ZonedDateTime.of(
                LocalDateTime.of(2017,12,9,14,25), ZoneId.of("Asia/Seoul"));
        System.out.println("Arrival : "+departure);

        ZonedDateTime arrival = ZonedDateTime.of(
                LocalDateTime.of(2017,12,9,17,25), ZoneId.of("Europe/Paris"));
        System.out.println("Arrival : "+arrival);

        System.out.println("서울에서 파리까지 걸리는 비행 시간 : "+Duration.between(departure, arrival));

        DateTimeFormatter fm1 = DateTimeFormatter.ofPattern("yyyy-MM-d, HH: m:s VV");
        DateTimeFormatter fm2 = DateTimeFormatter.ofPattern("yyyy-MM-d, H: mm:s VV");
        System.out.println(departure.format(fm1));
        System.out.println(departure.format(fm2));
    }
}
