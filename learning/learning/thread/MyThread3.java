package learning.thread;
/**
 * runnable thread
 * stop:
 *  利用次数，不建议死循环
 *  设置flag
 *  不要用stop/destroy等jdk方法
 * yield
 * @author Rambo,Shen
 */
public class MyThread3 implements Runnable {
    private boolean flag = true;
    private int i = 0;
    @Override
    public void run() {
        
        while(flag){
            System.out.println(Thread.currentThread().getName()+" thread 3 is running!---"+i++);
            if(i%10 == 0 ){
                if(Thread.currentThread().getName().equals("rambo")){
                    Thread.yield();
                    System.out.println(Thread.currentThread().getName()+" yield");
                }else if(Thread.currentThread().getName().equals("shen")){

                }
                
            }
            if(i==50){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(i>100){
                stop();
            }
        }       
    }
    public void stop() {
        this.flag = false;
    }
}
