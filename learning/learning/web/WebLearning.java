package learning.web;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class WebLearning {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getByName("www.alibaba.com");
            System.out.println(inetAddress);
            System.out.println(inetAddress.getHostAddress());
            System.out.println(inetAddress.getCanonicalHostName());
            System.out.println(inetAddress.getHostName());
            System.out.println(InetAddress.getLocalHost());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        
        InetSocketAddress inetSocketAddress =  new InetSocketAddress("127.0.0.1", 8080);
        System.out.println(inetSocketAddress);
    }
}
