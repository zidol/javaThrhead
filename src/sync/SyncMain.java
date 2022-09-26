package sync;

class Bank {

    private int money = 10000;

//    public synchronized void saveMoney(int save) {
public void saveMoney(int save) {


    //saveMoney 메소드가 실행 되면서 파라미터에 있는 객체를 락을 걸으라는 의미
//    synchronized (this) {
//        int m = getMoney();
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        setMoney(m + save);
//    }

//    int m = getMoney();
//
//    try {
//        Thread.sleep(1000);
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    }
//    setMoney(m + save);

    int m = getMoney();

    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    setMoney(m + save);
}

    public void minusMoney(int minus) {
        int m = getMoney();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setMoney(m - minus);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

class Park extends Thread {

    public void run() {
        synchronized (SyncMain.myBank) {
            System.out.println("start save");
            System.out.println(Thread.currentThread());
            SyncMain.myBank.saveMoney(3000);
            System.out.println("saveMoney(3000) : " + SyncMain.myBank.getMoney());
        }
    }
}

class ParkWife extends Thread {

    public void run() {
        synchronized (SyncMain.myBank) {
            System.out.println("start minus");
            System.out.println(Thread.currentThread());
            SyncMain.myBank.minusMoney(1000);
            System.out.println("minusMoney(1000) : " + SyncMain.myBank.getMoney());
        }
    }
}

public class SyncMain {
    //shared resource
    public static Bank myBank = new Bank();

    public static void main(String[] args) {

        Park p = new Park();
        p.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ParkWife pw = new ParkWife();
        pw.start();
    }
}
