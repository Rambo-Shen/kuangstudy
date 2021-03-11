package learning.oop;
/**
 * learning Class
 * lambda代替只有一个方法体的接口
 * @author Rambo,Shen
 * @version 1.2
 */ 
import learning.entity.*;

public class Oop {
    public static void main(String[] args) {
        
        
        //private:self||default:+package||protected:+son class||public:+all
        domainDeclare();

        //
        inherit();

        //
        multiState();

        //static
        staticSentences();

        //内部类
        inner();

        //lambda
        lambda();
    }

    private static void lambda() {
        System.out.println("---Lambda---");
        /**
         * 参数类型声明可以简化,顺序不可改变
         * 参数只有一个可以省略小括号
         * 方法体只有一行代码可以省略中括号
         */
        MyInterface2 myInterface2 = (a,b) -> System.out.println("I like to "+a+"!");
        myInterface2.doSomething("",1);
        System.out.println("---ending---");
    }

    private static void inner() {
        System.out.println("---inner class---");

        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.in();

        new Outer.StaticInner().doSomething();
        new InnerOuter().doSomething();

        class PartiInner implements MyInterface{

            @Override
            public void doSomething() {
                System.out.println("这是一个局部内部类");
            }
            
        }

        new PartiInner().doSomething();

        new MyInterface(){
            @Override
            public void doSomething() {
                System.out.println("这是一个匿名内部类");
            }
        }.doSomething();


        MyInterface myInterface = ()-> System.out.println("lambda");
        myInterface.doSomething();

        System.out.println("---ending---");

    }


    private static void staticSentences() {
        /**
         * 静态导入包 import static ...
         * final class 不能被继承
         */
        System.out.println("---static {}---");
        Static obj1 = new Static();
        Static obj2 = new Static();
        obj1.equals(obj2);
        System.out.println("---ending---");

    }

    private static void multiState() {
        System.out.println("---mutli states---");
        /**
         * 方法多态
         * 父类引用可以指向子类对象 等价于低转高（int -> double）同时可能丢失方法
         */
        Book book1 = new Story();
        Book book2 = new Picture();
        book1.read();
        book2.read();
        System.out.println("---ending---");
    }

    private static void inherit() {
        System.out.println("---inherit---");
        Book book = new Story();
        Story story = new Story();
        System.out.println(story.name);
        System.out.println(story.getPrice());
        System.out.println(story.getPage());
        //Override 只能用于非静态非私有方法
        /**
         * 修饰符可以扩大不能缩小
         * 异常可以缩小不能扩大
         */        
        System.out.println(book.getPage());

        story.testSuper();
        System.out.println("---ending---");

    }

    private static void domainDeclare() {
        System.out.println("---Declare Domain---");

        Book book = new Book();
        System.out.println(book.name);
        System.out.println(book.getPrice());
        System.out.println(book.getPage());
        System.out.println("---ending---");

    }
}
