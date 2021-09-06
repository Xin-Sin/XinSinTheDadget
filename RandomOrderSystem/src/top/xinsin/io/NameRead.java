package top.xinsin.io;

import top.xinsin.util.Student;
import top.xinsin.util.StudentName;

import java.io.*;

import static top.xinsin.randomOrderMain.log;

/**
 * 读元素类
 * 在使用此方法时,必须传入index，作为文件名
 *
 * 已修改
 */
public class NameRead extends AbsName {
    public static StudentName read(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        File file = new File(newPath + fileName + ".txt");
        log.info("NameRead:读取" + file.toURI() + "的文件");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String str;
        StudentName studentName = StudentName.getInstance();
        studentName.list.clear();
        while((str = bufferedReader.readLine()) != null) {
            studentName.list.add(new Student(str.trim()));
        }
        bufferedReader.close();
        return studentName;
    }
}
