package learning.synchronization;

public class Drawing implements Runnable{
    Account account;

    int money;

    public Drawing(Account account,int money){
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
/**
 * 同步代码块避免嵌套，产生死锁
 */
        synchronized(account){
            if(money>account.money){
            
                System.out.println("Your account have no enough money!");
                return;
            }
            account.money -= money;        
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" get "+money+"$ from Account "+account.name+"(remain "+account.money+"$)");
        }
        

    } 
}

class Account{
    int money;
    String name;
    public Account(int money,String name){
        this.money = money;
        this.name = name;
    }
}
