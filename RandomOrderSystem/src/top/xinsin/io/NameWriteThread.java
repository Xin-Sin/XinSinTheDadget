package top.xinsin.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class NameWriteThread extends AbsName implements Runnable{
    private String index = "1" ;
    private String toWrite = null;

    @Override
    public void run() {
        File file = new File(newPath + index + ".txt");
        try {
            if (!file.exists()){
                file.createNewFile();
                log.info("NameWrite:创建" + file.toURI() + "的文件");
            }
            log.info("NameWrite:读取"+file.toURI()+"的文件");
            BufferedWriter bufferedWriter  = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(toWrite);
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getToWrite() {
        return toWrite;
    }

    public void setToWrite(String toWrite) {
        this.toWrite = toWrite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameWriteThread that = (NameWriteThread) o;
        return Objects.equals(index, that.index) &&
                Objects.equals(toWrite, that.toWrite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, toWrite);
    }
}
