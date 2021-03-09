package learning.thread;
/**
 * @author Rambo,Shen
 */
public class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("my thread 1 is running!---"+i);
        }
        
        super.run();
    }
}
