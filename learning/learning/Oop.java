package learning;
/**
 * learning Class
 * @author Rambo,Shen
 * @version 1.1
 */ 

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
    }

    private static void inner() {
        System.out.println("---inner class---");

        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.in();
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
        System.out.println(story.price);
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
        System.out.println(book.price);
        System.out.println(book.getPage());
        System.out.println("---ending---");

    }
}
