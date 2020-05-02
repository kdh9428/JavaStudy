package xyz.springboot.user;

public class test2 {
    private static test2 s;
    private static int width;

    private test2(){
        System.out.println("싱글톤 확인");
    }
    public static test2 getInstance(){
        if(s ==null){
            System.out.println("처음 생성된 인스턴스");
            s=new test2();
        }else{
            System.out.println("이미 생성된 인스턴스");
        }
        return s;
    }

    /**
     * @return the width
     */
    public static int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public static void setWidth(int width) {
        test2.width = width;
    }

}