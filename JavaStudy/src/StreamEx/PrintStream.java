package StreamEx;

public class PrintStream {
    private int number = 999;

    public static void main(String[] args) {
        new PrintStream().test1();
        new PrintStream().test2();
    }

    @Override
    public String toString() {
    return new StringBuffer("PrintStream{")
                    .append("number = ")
                    .append(number)
                    .append("}")
                    .toString();
    }

    public static <T> String toString(T value){
        return "The value is "+ String.valueOf(value);
    }

    private void test1(){
        final int number = 100;

        testClosure("Anonymous Class", new Runnable() {
            @Override
            public void run() {
                System.out.println(PrintStream.this.number);
            }
        });
        testClosure("Lambda Expression",() -> {
//            int number = 1023;
            System.out.println(number);
        });
    }


    private void test2(){
        final int number = 100;

        testClosure("Anonymous Class2", new Runnable() {
            @Override
            public void run() {
                System.out.println("toString() : "+this.toString());
            }

        });
        testClosure("Anonymous Class2", new Runnable() {
            @Override
            public void run() {
                System.out.println("this.toString() : "+PrintStream.this.toString());
            }
        });
        testClosure("Lamdba Expression2",() -> System.out.println("Lamdba this.toString() : "+ this.toString()));
    }

    private void test3(){
        final int number = 100;

        testClosure("Anonymous Class2", new Runnable() {
            @Override
            public void run() {
                System.out.println("this.toString() : "+ toString());
            }
        });
        testClosure("Lamdba Expression2",() -> System.out.println("Lamdba this.toString() : "+toString("Test")));
    }

    private static void testClosure(final String name, final Runnable runnable){
        System.out.println("========="+name+"=========");
        runnable.run();
    }
}
