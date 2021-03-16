package learning.web;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket();

        String msg = "hello world";

        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 8080;

        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,inetAddress,port);
        
        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
}
