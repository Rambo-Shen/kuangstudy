package learning.synchronization;
/**
 * A thread to buy ticket
 */
public class BuyTicket implements Runnable{
    private int num = 10;
    private boolean flag = true;
    @Override
    public void run() {
        while(flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private synchronized void buy() throws InterruptedException {
        if(num<=0){
            flag = false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+" buy Ticket "+num--);
    }
    
}
