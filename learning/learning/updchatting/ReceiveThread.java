package learning.updchatting;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveThread implements Runnable{
    DatagramSocket datagramSocket = null;
    byte[] buffer = null;
    DatagramPacket datagramPacket = null;
    String msg = null;
    private String sender;
    public ReceiveThread(int port,String sender){
        this.sender = sender;
        try {
            datagramSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        } 
    }
    @Override
    public void run() {
        while(true){
            buffer = new byte[1024];
            datagramPacket = new DatagramPacket(buffer, 0,buffer.length);
            try {
                datagramSocket.receive(datagramPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }
            msg = new String(datagramPacket.getData());
            System.out.println(sender+" : "+msg.trim()); 
            if(msg.trim().equals("bye")){
                break;
            }
        }
        datagramSocket.close();
    }
    
}
