package OptionalEx;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;
import java.util.function.BiFunction;

public class OptionalEx2 {
    public static void main(String[] args) {

        ContInfo1 ci =  new ContInfo1("321-321-*321", "Republic of Korea");
        Company cp = new Company("YaHo co.", ci);
        Friend frn = new Friend("Lee su", cp);
        showCompAddr(Optional.of(frn));
        
        String a = "asdf";
    	String b = "asdfd";
    	
    	BiFunction<String, String, Boolean> test = String::equals;
    	
    	BiFunction<String, String, Boolean> test1 = (a1, b1) -> a.contentEquals(b);
    	
    	System.out.println("test===============");
    	System.out.println(test1.apply(a, b));
    	
    }

    public static void showCompAddr(Optional<Friend> f){
        String addr = f.map(a1 -> {
        	System.out.println(a1);
        	return a1.getCom();
        })
                        .map(a1 -> {
                        
                        	System.out.println("test : "+ a1);
                        	return a1.getCInfo();
                        })
                        .map(ContInfo1::getPhone)
                        .orElse("There's no Null..");
        System.out.println(addr);
    }
    
	


}

@AllArgsConstructor
class Friend{
    String name;
    Company com;
    
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	Company getCom() {
		return com;
	}
	void setCom(Company com) {
		this.com = com;
	}
    
}

@AllArgsConstructor
@Data
class Company {
    String cName;
    ContInfo1 cInfo;

}
@AllArgsConstructor
@Data
class ContInfo1 {  // '회사 정보'에 속하는 '회사 연락처'
    String phone;  // null 일 수 있음
    String adrs;
}