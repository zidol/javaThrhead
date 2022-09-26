package overriding;

public class Student extends People implements Prepare {
    String job;

    @Override
    public void print() {
        System.out.println("이름은 "+this.name + "이고, 나이는" + this.age + "입니다."); //새롭게 추가된 부분
        System.out.println(this.name+"은 "+this.job+" 입니다.");
    }

    @Override
    public void study() {
        System.out.println("cs 면접 공부합니다.");
        System.out.println("알고리즘 공부를 합니다.");
    }
}

