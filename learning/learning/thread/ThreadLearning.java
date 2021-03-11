package learning.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * learning thread 
 * new Thread()/runnable/callable
 * 
 * @author Rambo,Shen
 * @version 1.1
 */
public class ThreadLearning {
    

    public static void main(String[] args) {
        //开启mythread1
        // thread();
        

        //多线程下载图片
        // download();


        //runnable接口实现多线程
        // runnable();
        

        //并发问题
        // problem();
        

        //Running for Rabbit and Turtle
        // race();
        

        //callable
        /**
         * 可以定义返回值
         * 可以抛出异常
         */
        // callable();
       
        //stop
        // stop();

        //倒计时
        // try {
        //     // timer(10);
        //     // timer2(200);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        //yield
        // yield();
        
        //join
        // try {
        //     join();
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

        //state
        // try {
        //     state();
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

        //priority
        // priority();
        
        //用户线程
        /**
         * jvm等待用户线程结束
         * 不用考虑守护线程
         */
        daemon();
    }

    private static void daemon() {
        new Thread(new MyThread3(),"user").start();
        Thread thread = new Thread(new DaemonThread());
        thread.setDaemon(true);
        thread.start();
    }

    public static void priority() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());

        Thread t1 = new Thread(new MyThread3(),"P1");
        Thread t2 = new Thread(new MyThread3(),"P3");
        Thread t3 = new Thread(new MyThread3(),"P5");
        Thread t4 = new Thread(new MyThread3(),"P7");
        Thread t5 = new Thread(new MyThread3(),"P9");

        t1.setPriority(1);
        t2.setPriority(3);
        t3.setPriority(5);
        t4.setPriority(7);
        t5.setPriority(9);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

    public static void state() throws InterruptedException {
        Thread thread = new Thread(new MyThread3(),"rambo");
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        while(thread.getState() != Thread.State.TERMINATED){
            Thread.sleep(100);
            System.out.println(thread.getState());
        }
        System.out.println(thread.getState());

    }

    public static void join() throws InterruptedException {
        Thread thread = new Thread(new MyThread3(),"rambo");
        thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main---"+i);
            if(i==50){
                thread.join();
            }
        }
    }

    public static void yield() {
        new Thread(new MyThread3(),"rambo").start();
        new Thread(new MyThread3(),"shen").start();
    }

    public static void timer2(int seconds) throws InterruptedException {
        Date startTime = new Date(System.currentTimeMillis());
        Date endTime = new Date(System.currentTimeMillis());
        while(true){
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(endTime));
            Thread.sleep(1000);            
            endTime = new Date(System.currentTimeMillis());
            if(endTime.getTime() >= startTime.getTime()+seconds*1000){
                break;
            }
        }
    }

    public static void timer(int seconds) throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            System.out.println(seconds--);
            if(seconds<0){
                break;
            }
        }
    }

    public static void stop() {
        MyThread3 myThread3 = new MyThread3();
        new Thread(myThread3).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main "+i);
            if(i == 900){
                myThread3.stop();
            }
        }
    }

    public static void thread() {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main---"+i);
        }
    }

    public static void download() {
        MyThread2 myThread21 = new MyThread2("https://www.baidu.com/img/flexible/logo/pc/result.png","1.png");
        MyThread2 myThread22 = new MyThread2("https://avatars.githubusercontent.com/u/74522405?s=60&v=4","2.png");
        MyThread2 myThread23 = new MyThread2("https://maven.apache.org/images/maven-logo-black-on-white.png","3.png");

        myThread21.start();
        myThread22.start();
        myThread23.start();
    }

    public static void runnable() {
        Thread thread = new Thread(new MyThread3());
        thread.start(); 
    }

    public static void problem() {
        MyThread4 myThread4 = new MyThread4();
        new Thread(myThread4, "rambo").start();
        new Thread(myThread4, "jackie").start();
        new Thread(myThread4, "leo").start();
    }

    public static void race() {
        Race race = new Race();
        new Thread(race,"Rabbit").start();
        new Thread(race,"Turtle").start();
    }

    public static void callable() {
        MyCallable myCallable1 = new MyCallable("https://www.baidu.com/img/flexible/logo/pc/result.png","1.png");
        MyCallable myCallable2 = new MyCallable("https://avatars.githubusercontent.com/u/74522405?s=60&v=4","2.png");
        MyCallable myCallable3 = new MyCallable("https://maven.apache.org/images/maven-logo-black-on-white.png","3.png");

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Boolean> result1 = executorService.submit(myCallable1);
        Future<Boolean> result2 = executorService.submit(myCallable2);
        Future<Boolean> result3 = executorService.submit(myCallable3);
        try {
            boolean b1 = result1.get();
            boolean b2 = result2.get();
            boolean b3 = result3.get();
            System.out.println(b1);
            System.out.println(b2);
            System.out.println(b3);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdownNow();
    }

    
}
