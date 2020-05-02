package Collections;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		solution(5,24);
		
		System.out.println(factorial(10));
	}
	
	static public String solution(int a, int b) {
		String answer = "";
		String c = "2016-"+a+"-"+b;
		System.out.println(c);
		
		Date d = new Date();
		
		SimpleDateFormat aa= new SimpleDateFormat("yyyy-M-D");
		
		return answer;
	}
	
	public static long factorial(long aa) {
		if(aa<=1) {
			System.out.println("끄으읏");
			
			return aa;
		}
			
		
		return aa*factorial(aa-1);
	}
}
