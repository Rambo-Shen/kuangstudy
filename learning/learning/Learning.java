package learning;

import java.util.List;

/**
 * learning variables
 *
 * @author Rambo,Shen
 * @version 1.0.0
 *
 */
public class Learning {

    public static void main(String[] args) {

        System.out.println("123");

        //整数进制
        integer2816();

        //浮点数
        floatAndDouble();

        //char
        charToInt();

        //string
        stringCompare();

        //
        classField();

        //compute signal
        computeSignal();

    }

    /**
     * @param
    *  @return nothing
     * @throws Exception
    * */
    public static void computeSignal() {
        System.out.println("---compute signal---");
        //short + byte = int

        Book book = new Book();
        System.out.println(book instanceof Book);
        System.out.println(book instanceof List);

        System.out.println("---ending---");
    }

    private static void classField() {
        System.out.println("---testing class field---");

        Book book = new Book();
        System.out.println(book.name);//null
        System.out.println(book.getPage());//default 0 / 0.0 / false
        System.out.println("---ending---");

    }

    private static void stringCompare() {
        System.out.println("---string 比较---");

        String s1 = "123";
        String s2 = "123";
        System.out.println(s1 == s2);//true

        String s3 = new String("123");
        String s4 = new String("123");
        System.out.println(s3 == s4);//false
        System.out.println(s1 == s4);//false
        System.out.println("---ending---");

    }

    private static void charToInt() {
        System.out.println("---char/int转换---");
        char c1 = 'a';
        char c2 = '中';
        System.out.println(c1);
        System.out.println((int)c1);
        System.out.println(c2);
        System.out.println((int)c2);
        System.out.println("---ending---");
    }

    private static void floatAndDouble() {
        System.out.println("---float/double 精度问题,避免使用浮点数---");
        float f = 0.1f;
        double d = 1.0/10;
        System.out.println(f==d);//false
        f = 1234123124231312313f;
        System.out.println(f == f+1);//true
        System.out.println("---ending---");
    }

    private static void integer2816() {
        System.out.println("---以100为例---");
        int i = 100;
        System.out.println("十进制i = "+i);
        i = 0b100;
        System.out.println("二进制i = "+i);
        i = 0100;
        System.out.println("八进制i = "+i);
        i = 0x100;
        System.out.println("十六进制i = "+i);
        System.out.println("---ending---");
    }

}