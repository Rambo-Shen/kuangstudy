package learning.exception;
/**
 * my exception
 * @author Rambo,Shen
 * @version 1.0
 */
public class MyException extends Exception{

    public MyException(){
        super();
    }

    public MyException(int marks){
        super("Your marks("+marks+") is out of range!");
    }

}

    
