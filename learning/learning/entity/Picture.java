package learning.entity;

public class Picture extends Book{
    @Override
    public void read() {
        System.out.println("im reading Picture "+name);
    }
}
