package learning.communication;

/**
 * communication
 * 线程通信
 * 生产者消费者模式
 * 管程法/信号灯法（flag）
 * @author Rambo,Shen
 */
public class Communication {

    public static void main(String[] args) {
        Containner containner = new Containner();
        new Thread(new Productor(containner)).start();
        new Thread(new Consumer(containner)).start();

    }
}

/**
 * Consumer
 */
class Consumer implements Runnable{

    Containner containner;
    Consumer(Containner containner){
        this.containner = containner;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Consumer consumes Product "+containner.pop().id);

        }
    }
    
}

/**
 * Productor
 */
class Productor implements Runnable{
    Containner containner;
    Productor(Containner containner){
        this.containner = containner;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            containner.push(new Product(i));
            System.out.println("Productor products Product "+i);
        }
    }
}

/**
 * Product
 */
class Product {

    int id;
    Product(int id){
        this.id = id;
    }
    
}

/**
 * Containner 
 */
class Containner  {
    Product [] products = new Product[10];
    int count = 0;
    public synchronized void push(Product product) {
        if(count == products.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products[count] = product;
        count++;
        this.notifyAll();
    }
    public synchronized Product pop() {
        if(count == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        count--;
        this.notifyAll();
        return products[count];
    }


    
}