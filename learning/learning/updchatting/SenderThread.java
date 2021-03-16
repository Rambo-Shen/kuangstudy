package learning.updchatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * SenderThread
 */
public class SenderThread implements Runnable
{

    DatagramSocket datagramSocket = null;
    DatagramPacket datagramPacket = null;
    BufferedReader bufferedReader = null;
    private int toPort;

    public SenderThread(int fromPort,int toPort){
        this.toPort = toPort;
        try {
            datagramSocket = new DatagramSocket(fromPort);
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        
        while(true){
            String msg;
            try {
                msg = bufferedReader.readLine();
                datagramPacket = new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,new InetSocketAddress("localhost", toPort));
                datagramSocket.send(datagramPacket);
                if(msg.trim().equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
        datagramSocket.close();
    }
}
