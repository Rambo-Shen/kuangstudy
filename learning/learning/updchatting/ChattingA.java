package learning.updchatting;

public class ChattingA {
    public static void main(String[] args) {
        new Thread(new SenderThread(8081, 8082)).start();
        new Thread(new ReceiveThread(8083, "B")).start();
        
        
    }
}
