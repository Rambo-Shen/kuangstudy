package learning.thread;
/**
 * buy tickets
 */
public class MyThread4 implements Runnable{
    private int ticketsNum = 10;

    @Override
    public void run() {
        while(ticketsNum>0){
            System.out.println(Thread.currentThread().getName()+" buy Ticket "+ticketsNum--);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }     
    }
}
