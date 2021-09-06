package top.xinsin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class test {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
    }
    /*public static void main(String[] args) throws IOException {
        savePic("https://s3.ananas.chaoxing.com/doc/5a/23/48/ea7e1937a25c84d2b4d026c46941d47c/thumb/55.png","D:/save/");
    }
    public static void savePic(String urlStr, String dirStr) throws IOException {
        URL url = new URL(urlStr);
        InputStream in = url.openStream();
        String filename = dirStr + urlStr.substring(urlStr.lastIndexOf("/") + 1);
        File dir = new File(dirStr);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        System.out.println(filename);
        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        byte[] b = new byte[1024];
        int len;
        while ((len = in.read(b)) != -1) {
            fos.write(b, 0, len);
        }
        fos.close();
        in.close();
    }*/
}
