package learning.oop;

/**
 * MyAbstracts
 * 抽象方法只能在抽象类里，抽象方法没有方法体
 * 不能实例化
 * 子类必须重写全部抽象方法
 * @author Rambo,Shen
 * @version 1.0
 */
public abstract class MyAbstracts {

    public abstract void name(int i);
    public void name() {
        
    }
}