package learning;

import java.util.Scanner;
/**
 *
 * @author Rambo,Shen
 * @version 1.0
 * */
public class Sentences {
    public static void main(String[] args) {
        //Scanner类
        scanner();

        //for for arrays
        arraysFor();

        //breaks in for sentences
        breakInFor();
    }

    private static void breakInFor() {
        System.out.println("---labels in for sentences---");
        outer:for (int i =1;i<10;i++){
            for(int j = 1;j<i;j++){
                System.out.println(i*j);
                if(j == 1){
                    continue outer;
                }
            }
        }

        System.out.println("---ending---");

    }

    private static void arraysFor() {
        System.out.println("---for For Arrays---");
        int[] nums = {1,2,3,4,5};
        for(int i:nums){
            System.out.println(i);
        }
        System.out.println("---ending---");

    }

    private static void scanner() {
        System.out.println("---Class Scanner---");

        Scanner scanner = new Scanner(System.in);
        //不接受空格
        if(scanner.hasNext()){
            System.out.println(scanner.next());
        }
        if(scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
        scanner.close();
        System.out.println("---ending---");

    }
}
