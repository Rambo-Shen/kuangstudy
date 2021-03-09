package learning.thread;



/**
 * learning thread 
 * 
 * @author Rambo,Shen
 * @version 1.0
 */
public class ThreadLearning {
    

    public static void main(String[] args) {
        //开启mythread1

        MyThread1 myThread1 = new MyThread1();
        // myThread1.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main---"+i);
        }

        //多线程下载图片
        MyThread2 myThread21 = new MyThread2("https://www.baidu.com/img/flexible/logo/pc/result.png","1.png");
        MyThread2 myThread22 = new MyThread2("https://avatars.githubusercontent.com/u/74522405?s=60&v=4","2.png");
        MyThread2 myThread23 = new MyThread2("https://maven.apache.org/images/maven-logo-black-on-white.png","3.png");

        // myThread21.start();
        // myThread22.start();
        // myThread23.start();


        //runnable接口实现多线程
        
        Thread thread = new Thread(new MyThread3());
        // thread.start(); 

        //并发问题
        MyThread4 myThread4 = new MyThread4();
        // new Thread(myThread4, "rambo").start();
        // new Thread(myThread4, "jackie").start();
        // new Thread(myThread4, "leo").start();

        //Running for Rabbit and Turtle
        Race race = new Race();
        new Thread(race,"Rabbit").start();
        new Thread(race,"Turtle").start();
    }

    
}
