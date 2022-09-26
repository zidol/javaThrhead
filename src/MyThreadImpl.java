public class MyThreadImpl implements Runnable {

    @Override
    public void run() {
        int j;
        for (j = 0; j <= 200; j++) {
            System.out.print(j + "\t");
        }
    }
}
