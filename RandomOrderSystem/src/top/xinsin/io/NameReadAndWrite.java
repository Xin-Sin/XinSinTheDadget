package top.xinsin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.logging.Logger;
import top.xinsin.util.Student;
import top.xinsin.list.StudentName;

/**
 * 已废弃，因为使用多线程效率会高
 * 实现读和写类
 */
@Deprecated
public class NameReadAndWrite {
    private String path = System.getProperty("java.io.tmpdir");
    private String newPath;
    private String index = "0";
    private Logger log = Logger.getLogger(this.getClass().getName());;

    public NameReadAndWrite() {
        int firstIndex = this.path.lastIndexOf(System.getProperty("path.separator")) + 1;
        int lastIndex = this.path.lastIndexOf(File.separator) + 1;
        this.path = this.path.substring(firstIndex, lastIndex);
        this.newPath = this.path + "classes" + File.separator;
        File file = new File(this.newPath);
        if (!file.isDirectory()) {
            file.mkdir();
        }

    }

    /**
     * 将文件中数据放到集合中
     * @param index 一般传入文件名
     * @return 返回是否读取成功
     * @throws IOException
     */
    public boolean read(String index) throws IOException {
        this.index = index;
        File file = new File(this.newPath + index + ".txt");
        new String();
        if (!file.isFile()) {
            file.createNewFile();
            this.log.info("创建文件" + file.toURI());
        }

        this.log.info(file.getPath());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String str;
        while((str = bufferedReader.readLine()) != null) {
            str.trim();
            StudentName.List.add(new Student(str));
        }

        bufferedReader.close();
        return true;
    }

    /**
     * 将用户提交的数存入到文件中
     * @param toWrite 数据
     * @param index 文件名
     * @return 返回是否成功
     * @throws IOException
     */
    public boolean write(HashSet<String> toWrite, String index) throws IOException {
        this.index = index;
        File file = new File(this.newPath + index + ".txt");
        if (!file.exists()){
            file.createNewFile();
            this.log.info("创建文件" + file.toURI());
        }
        this.log.info(file.getPath());
        BufferedWriter bufferedWriter  = new BufferedWriter(new FileWriter(file));
        for (String str:toWrite) {
            bufferedWriter.write(str);
            bufferedWriter.flush();
        }
        bufferedWriter.close();

        return false;
    }
}
