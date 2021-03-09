package learning.thread;

public class MyThread3 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("my thread 3 is running!---"+i);
        }        
    }
}
