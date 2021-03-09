package learning.thread;

/**
 * Race
 */
public class Race implements Runnable {

    private boolean isOver = false;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (Thread.currentThread().getName().equals("Rabbit") && i == 70) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (isOver) {
                break;
            } else {
                if(Thread.currentThread().getName().equals("Rabbit")){
                    i++;
                }
                System.out.println(Thread.currentThread().getName() + " forwards " + i + " steps");
            }

        }
        if (!isOver) {
            isOver = true;
            System.out.println("Winner is " + Thread.currentThread().getName() + "!");
        }
    }

}