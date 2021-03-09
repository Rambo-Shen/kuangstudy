package learning.exception;
/**
 * exception learning
 * @author Rambo,Shen
 * @version 1.0
 */
public class MyExceptionLearning {
    public static void main(String[] args) {
        System.out.println("---exception / by zero---");

        try {
            devidedByZero(0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            System.out.println("finally");
        }
        System.out.println("---ending---");

        System.out.println("---my exception---");
        try {
            marksOutOfRange(200);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("---ending---");

    }

    private static int marksOutOfRange(int marks) throws MyException {
        if(marks<0||marks>100){
            throw new MyException(marks);
        }
        return marks;
    }

    public static double devidedByZero(int a,int b) throws ArithmeticException{
        if(b == 0){
            throw new ArithmeticException("/ by zero");
        }
        return a/b;
    }
}
