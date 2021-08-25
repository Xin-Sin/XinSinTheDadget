package top.xinsin.io;

import top.xinsin.util.Student;
import top.xinsin.list.StudentName;

import java.io.*;

/**
 * 读元素类
 * 在使用此方法时,必须传入index，作为文件名
 */
public class NameReadThread extends AbsName implements Runnable{

    private String index = "1";

    @Override
    public void run() {
        File file = new File(newPath + index + ".txt");
        try {
            if (!file.isFile()) {
                file.createNewFile();
                log.info("NameRead:创建" + file.toURI() + "的文件");
            }
            log.info("NameRead:读取" + file.toURI() + "的文件");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str;
            while((str = bufferedReader.readLine()) != null) {
                StudentName.List.add(new Student(str.trim()));
            }
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getIndex() {
        return index;
    }

    /**
     *
     * @param index 在使用此类时必须传入该参数
     */
    public void setIndex(String index) {
        this.index = index;
    }
}
