package learning.basic;

import java.util.Arrays;
import learning.entity.*;

/**  
 * learning function and arrays
* @author Rambo,Shen
* @version 1.0
*/
public class Function{
    public static void main(String[] args) {
        //值传递,对象是引用传递
        System.out.println("---parameter passing---");

        Book book = new Book();
        book.name  = "rambo";
        book.setPage(20);
        parameterPass(book);
        System.out.println(book.name);
        System.out.println("---ending---");

        //可变参数
        variableParameter(1,2,3);

        //Arrays utils
        arraysUtils();
    }
    public static void arraysUtils() {
        System.out.println("---Usage of Arrays Utils---");
        int[] a = new int [10];
        System.out.println(Arrays.toString(a));
        
        Arrays.fill(a,2,4,2);
        System.out.println(Arrays.toString(a));

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println("---ending---");

    }
    public static void parameterPass(Book book) {
        book.name = "shen";
    }
    public static void variableParameter(int... i) {
        System.out.println("---variable parameter---");
        for (int j : i) {
            System.out.println(j);
        }
        System.out.println("---ending---");
    }
}