package overriding;

public class OverridingExample {
    public static void main(String[] args) {
        Student student = new Student();
        student.name = "jhahn";
        student.age = 25;
        student.job= "백수";
        student.print();
        student.study();
    }
}
