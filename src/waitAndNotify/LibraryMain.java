package waitAndNotify;

import java.util.ArrayList;

class Library {
    public ArrayList<String> shelf = new ArrayList<>();

    public Library() {
        shelf.add("JAVA1");
        shelf.add("JAVA2");
        shelf.add("JAVA3");
//        shelf.add("JAVA4");
//        shelf.add("JAVA5");
//        shelf.add("JAVA6");
    }

    public synchronized String lendBook() throws InterruptedException {
        Thread t = Thread.currentThread();//메서드를 수행하고 있는 쓰레드 정보

        while (shelf.size() == 0) {
            //리소스가 없으면 기다림
            //이 메소드를 수행하고 있는 쓰레드를 run unable 상태로 변경
            System.out.println(t.getName() + " wait start");
            wait();
            System.out.println(t.getName() + " wait end");
        }

        if (shelf.size() > 0) {
            String book = shelf.remove(0);
            System.out.println(t.getName() + " : " + book + " lend");
            return book;
        } else {
            return null;
        }
    }

    public synchronized void returnBook(String book) {
        Thread t = Thread.currentThread();

        shelf.add(book);
//        notify();
        notifyAll();
        System.out.println(t.getName() + " : " + book + " return");
    }
}

class Student extends Thread {

    public Student(String name) {
        super(name);
    }
    public void run() {
        try {
            String title = LibraryMain.library.lendBook();
            if(title == null) {
                System.out.println(getName() + " : 빌리지 못함");
                return;
            }
            //5초뒤 반납
            sleep(5000);
            LibraryMain.library.returnBook(title);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class LibraryMain {

    public static Library library = new Library();
    
    public static void main(String[] args) {
        Student std1 = new Student("std1");
        Student std2 = new Student("std2");
        Student std3 = new Student("std3");
        Student std4 = new Student("std4");
        Student std5 = new Student("std5");
        Student std6 = new Student("std6");

        std1.start();
        std2.start();
        std3.start();
        std4.start();
        std5.start();
        std6.start();


    }
}
