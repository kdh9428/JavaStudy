package OptionalEx;

import java.util.Optional;

public class OptionalEx1 {

    public static void main(String[] args) {

        Optional<String> os1 = Optional.of(new String("Toy1")); //of는 null 허용하지 않음
        Optional<String> os2 = Optional.ofNullable(new String("Toy2")); //ofNullable은 null을 허용한다.

        if (os1.isPresent()) //isPresent는 os1참조변수에 데이터가 존재하는지 안하는지 확인
            System.out.println(os1.get());

        if (os2.isPresent())
            System.out.println(os2.get());

        Optional<String> os3 = Optional.of(new String("Toy1"));
        Optional<String> os4 = Optional.ofNullable(new String("Toy2"));

        os3.ifPresent(s -> System.out.println(s)); // ifPresent 만약에 존재한다면 true
        os4.ifPresent(System.out::println);

        Optional<String> os5 = Optional.of("Optional String");
        Optional<String> os6 = os5.map(s -> s.toUpperCase()); //toUpperCase() 문자열을 대문자로 변환한다.
        System.out.println(os6.get());

        //Optional.map()
        Optional<String> os7 = os5.map(s -> s.replace(' ','_'))//replace 문자 치환한다.
                .map(s -> s.toLowerCase()); //toLowerCase 문자열을 소문자로 변환한다.
        System.out.println(os7.get());

        Optional<String> os8 = Optional.empty();    //empty로 null 지정
        Optional<String> os9 = Optional.of("So Basic");

        String s1 = os8.map(s -> s.toString())
                    .orElse("Empty");   //orElse메서드는 Null일 경우에 지정된 값을 반환

        String s2 =os9.map(s -> s.toString())
                        .orElse("Empty");
        
        System.out.println(s1);
        System.out.println(s2);


    }
}

class ContInfo{
    String phone;
    String adrs;

    public ContInfo(String phone, String adrs) {
        this.phone = phone;
        this.adrs = adrs;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdrs() {
        return adrs;
    }

    public void setAdrs(String adrs) {
        this.adrs = adrs;
    }
}
