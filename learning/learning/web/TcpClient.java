package learning.web;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
    public static void main(String[] args) {
        Socket socket = null;
        FileInputStream fileInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;

        try {
            InetAddress inetAddress =  InetAddress.getByName("127.0.0.1");
            int port = 9999;
            socket = new Socket(inetAddress,port);
            
            // TCP-communication
            // socket.getOutputStream().write("hello world".getBytes());

            fileInputStream = new FileInputStream(new File("C:\\Users\\34662\\Desktop\\repository\\kuangstudy\\learning\\learning\\web\\1.txt"));
            byte[] buffer = new byte[1024];
            int len;
            while((len = fileInputStream.read(buffer)) != -1 ){
                socket.getOutputStream().write(buffer,0,len);
            }

            socket.shutdownOutput();

            byteArrayOutputStream =  new ByteArrayOutputStream();
            byte[] buffer2 = new byte[1024];
            int len2;
            while((len2 =  socket.getInputStream().read(buffer2)) != -1 ){
                byteArrayOutputStream.write(buffer2,0,len2);
            }
            System.out.println(byteArrayOutputStream.toString());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(byteArrayOutputStream != null){
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
