package learning.thread;
/**
 * thread to download file from Internet
 * @author Rambo,Shen
 */
import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
public class MyThread2 extends Thread {
    private String url;
    private String name;

    public MyThread2(){
        super();
    }

    public MyThread2(String url,String name){
        super();
        this.name = name;
        this.url = url;
    }


    @Override
    public void run() {
        download(url, name);
        System.out.println(name+" has been downloaded!");
    }

    private static void download(String url,String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
