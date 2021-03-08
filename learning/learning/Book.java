package learning;

public class Book {
    String name;
    private int page;
    protected int price;

    Learning learning;

    public Book(){
        // Learning.computeSignal();
        name = "default";
        page = 0;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
}
