package learning.entity;

import learning.basic.Learning;

public class Book {
    public String name;
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

    public void read(){
        System.out.println("im reading "+name);
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
