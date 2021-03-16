package learning.updchatting;

public class ChattingB {
    public static void main(String[] args) {
        new Thread(new SenderThread(8084, 8083)).start();
        new Thread(new ReceiveThread(8082, "A")).start();
    }
    
}
