package overloading;

public class Overloadingtest {

    // test() 호출
    void test(){
        System.out.println("매개변수 없음");
    }

    // test에 매개변수로 int형 2개 호출
    void test(int a, int b){
        System.out.println("매개변수 "+ a + "와 " + b);
    }

    // test에 매개변수 double형 1개 호출
    void test(double d){
        System.out.println("매개변수 " + d);
    }
}
