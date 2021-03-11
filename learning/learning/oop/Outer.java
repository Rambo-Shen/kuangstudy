package learning.oop;
/**
 * 内部类可以获得外部类的private成员属性
 * 但static 内部class不行
 */
public class Outer {
    private int i=10;
    //outer.Inner 实例对象可以用
    public class Inner {
        public void in(){
            System.out.println(i);
        }
        
    }
    //new Outer.StaticInner() 
    static class StaticInner implements MyInterface{
        @Override
        public void doSomething() {
            System.out.println("这是一个静态内部类");
        }
    }
}
//只能有一个public class
class InnerOuter implements MyInterface{
    @Override
    public void doSomething() {
        System.out.println("这是一个内部类");
    }
    
}

/**
 * 
 */
interface MyInterface {
    void doSomething();
}

/**
 * 
 */
interface MyInterface2 {

    void doSomething(String things,int num);
    
}