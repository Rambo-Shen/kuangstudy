package learning;

/**
 * Story
 */
public class Story extends Book{

    private int page;

    public Story(){
        super();
        this.page = 1;
    }

    public void testSuper(){
        System.out.println("-----super-----");

        System.out.println(page);
        System.out.println(this.page);
        System.out.println(super.getPage());
        System.out.println("-----ending-----");

    }
}