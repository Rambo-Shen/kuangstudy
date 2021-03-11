package learning.proxy;
/**
 * learning static proxy
 * 真实对象（人）和代理对象（婚庆公司）实现同一个接口
 * 代理对象要代理真实对象
 * 代理对象可以做很多真实对象做不了的事情
 * 真实对象专注做自己的事情
 * example：new Thread(thread).start(); 
 * @author Rambo,Shen
 */
public class Myproxy{
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new Person());
        weddingCompany.marry();
    }
}

/**
 * InnerMyproxy
 */
interface Marry {
    void marry();
}

/**
 * Person
 */
class Person implements Marry {
    @Override
    public void marry() {
        System.out.println("im married!");
    }
}
class WeddingCompany implements Marry{
    private Marry target;
    public WeddingCompany(Marry target){
        this.target = target;
    }
    @Override
    public void marry() {
        before();
        this.target.marry();
        after();
    }
    private void after() {
        System.out.println("go to bed!");
    }
    private void before() {
        System.out.println("preparing wedding!");
    }
}