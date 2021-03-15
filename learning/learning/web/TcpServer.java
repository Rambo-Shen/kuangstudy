package learning.web;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TcpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            serverSocket = new ServerSocket(9999);
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();

            // TCP-communication
            // byteArrayOutputStream =  new ByteArrayOutputStream();
            // byte[] buffer = new byte[1024];
            // int len;
            // while((len = inputStream.read(buffer)) != -1 ){
            //     byteArrayOutputStream.write(buffer,0,len);
            // }
            // System.out.println(byteArrayOutputStream.toString());

            //
            fileOutputStream = new FileOutputStream(new File("resources"));
            byte[] buffer = new byte[1024];
            int len;
            while((len = inputStream.read(buffer)) != -1 ){
                fileOutputStream.write(buffer,0,len);
            }
            socket.getOutputStream().write("Got it,lets break up!".getBytes());

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
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream!=null){
                try {
                    inputStream.close();
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
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
        }

        
    }
}
