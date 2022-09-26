public class ThreadTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread() + "start");

        MyThread th1 = new MyThread();
        MyThread th2 = new MyThread();

        th1.start();
        th2.start();

        System.out.println(Thread.currentThread() + "end");

        System.out.println(Thread.currentThread() + "start 2");
        MyThreadImpl myThread = new MyThreadImpl();
        Thread thread = new Thread(myThread);
        Thread thread2 = new Thread(myThread);

        thread.start();
        thread2.start();
        System.out.println(Thread.currentThread() + "end 2");

        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        };
        run.run();
    }
}
