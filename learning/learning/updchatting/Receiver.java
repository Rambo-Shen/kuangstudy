package learning.updchatting;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver {
    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(8082);
        byte[] buffer = null;
        DatagramPacket datagramPacket = null;
        String msg = null;
        while(true){
            buffer = new byte[1024];
            datagramPacket = new DatagramPacket(buffer, 0,buffer.length);
            datagramSocket.receive(datagramPacket);
            msg = new String(datagramPacket.getData());
            System.out.println(msg.trim()); 
            if(msg.trim().equals("goodbye")){
                break;
            }
        }
        
        
        
       

        // String msg = "hello,receiver";

        // datagramPacket = new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,new InetSocketAddress("localhost", 8081));

        // datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
}
