package learning;
/**
 * learning Class
 * @author Rambo,Shen
 * @version 1.0
 */ 

public class Oop {
    public static void main(String[] args) {
        
        
        //private:self||default:+package||protected:+son class||public:+all
        domainDeclare();

        //
        inherit();
    }

    private static void inherit() {
        System.out.println("---inherit---");

        Story story = new Story();
        System.out.println(story.name);
        System.out.println(story.price);
        System.out.println(story.getPage());

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
