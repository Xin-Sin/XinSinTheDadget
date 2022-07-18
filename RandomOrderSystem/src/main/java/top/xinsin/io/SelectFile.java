package top.xinsin.io;

import java.io.*;

import static top.xinsin.randomOrderMain.log;

public class SelectFile extends AbsName {
    public SelectFile() {
    }
    public static StringBuilder selectFileClass(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        File file = new File(newPath + fileName);
        log.info("NameRead:读取" + file.toURI() + "的文件");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String str;
        sb.setLength(0);
        while((str = bufferedReader.readLine()) != null) {
            sb.append(str.trim() + "\n");
        }
        bufferedReader.close();
        return sb;
    }
}
