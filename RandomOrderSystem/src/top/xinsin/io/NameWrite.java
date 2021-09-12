package top.xinsin.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static top.xinsin.randomOrderMain.log;

/**
 * 已修改
 */
public class NameWrite extends AbsName{
    public static void write(String fileName,String contents) throws IOException {
        File file = new File(newPath + fileName);
        if (!file.exists()){
            file.createNewFile();
            log.info("NameWrite:创建" + file.toURI() + "的文件");
            BufferedWriter bufferedWriter  = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(contents);
            bufferedWriter.flush();
            bufferedWriter.close();
        }
    }
}
