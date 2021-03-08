package learning;
/**
 * 内部类可以获得外部类的private成员属性
 * 但static 内部class不行
 */
public class Outer {
    private int i=10;
    
    public class Inner{
        public void in(){
            System.out.println(i);
        }
    }
}
//只能有一个public class
class InnerOuter {

    
}