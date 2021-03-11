package learning.thread;

import java.io.File;
import java.net.URL;
import java.util.concurrent.Callable;

import org.apache.commons.io.FileUtils;

public class MyCallable implements Callable<Boolean>{
    private String url;
    private String name;
    public MyCallable(String url,String name){
        this.url = url;
        this.name = name;
    }
    public Boolean call() throws Exception {
        download(url, name);
        System.out.println(name+" has been downloaded!");
        return true;

    };
    private static void download(String url,String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
