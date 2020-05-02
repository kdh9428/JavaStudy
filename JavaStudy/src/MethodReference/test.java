package xyz.springboot.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test {
    public static void main(String[] args) {
           
        String str1 = new String("Test");
        String str2 = new String("Test");

        String str3 ="Test";
        String str4 ="Test";

        System.out.println(str3.hashCode());
        //참조 대상 비교
        if(str1 == str2)
            System.out.println("str1과 str2의 참조 대상이 동일하다.");
        else
            System.out.println("str1과 str2의 참조 대상이 다르다.");

        System.out.println("====================================");
        if(str3 == str4)
            System.out.println("str3과 str4의 참조 대상이 동일하다.");
        else
            System.out.println("str3과 str4의 참조 대상이 다르다.");
        System.out.println("===================================");
        //두 인스턴스 내용 비교
        if(str1.equals(str2))
            System.out.println("str1과 str2의 참조 대상이 동일하다.");
        else
            System.out.println("str1과 str2의 참조 대상이 다르다.");


        System.out.println("===================================");
        tests ts = new tests();
        ts.vs();
        System.out.println("=========================sington=======================");

        test2 te1 = test2.getInstance();
        test2 te2 = test2.getInstance();

        System.out.println(te1.getWidth());
        System.out.println(te2.getWidth());

        te1.setWidth(11);
        System.out.println(te1.getWidth());
        System.out.println(te2.getWidth());

        te2.setWidth(22);
        System.out.println(te1.getWidth());
        System.out.println(te2.getWidth());



    }
}

class INum {
    private int num;
    public INum(int num){
        this.num = num;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.num == ((INum)obj).num)
            return true;
        else
            return false;
    }
}

class tests{

    public void vs(){
        char [] a = {'a','b','c'};
        char [] b = {'a','b','s'};
        List<String> as = Arrays.asList("a","b","c");
        as = new ArrayList<>(as);
        as.add("d");

        System.out.println(as.toString());
       
        System.out.println(Arrays.toString(b));
        for (int c = 0; c<a.length;c++) {
            if(a[c] == b[c])
                System.out.println(a[c]+"와 "+b[c]+"는 같다.");
            else
                System.out.println(a[c]+"와 "+b[c]+"는 다르다");
        }
    }
}