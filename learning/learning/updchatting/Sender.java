package learning.updchatting;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Sender {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(8081);

        String msg = "goodbye";

        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,new InetSocketAddress("localhost", 8082));

        datagramSocket.send(datagramPacket);

        datagramSocket.close();


    }
}
