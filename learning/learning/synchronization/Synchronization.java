package learning.synchronization;



/**
 * 线程同步
 * @author Rambo,Shen
 */
public class Synchronization {

    public static void main(String[] args) {
        // ticket();
        drawing();
    }

    public static void drawing() {
        Account account = new Account(100, "Citi");
        Drawing drawing1 = new Drawing(account, 10);
        Drawing drawing2 = new Drawing(account, 20);
        new Thread(drawing1,"rambo").start();
        new Thread(drawing2,"taylor").start();

    }

    public static void ticket() {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket, "rambo").start();
        new Thread(buyTicket, "jackie").start();
        new Thread(buyTicket, "leo").start();
    }
}
