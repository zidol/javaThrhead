package overloading;

public class OverloadingExample {

    public static void main(String[] args) {

        Overloadingtest ob = new Overloadingtest();

        // test() 호출
        ob.test();

        // test(int a, int b) 호출
        ob.test(10, 20);

        // test(double d) 호출
        ob.test(50);

        // test(double d) 호출
        ob.test(123.4);
    }
}
