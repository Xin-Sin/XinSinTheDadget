package top.xinsin.io;

import java.util.Objects;

/**
 * 将界面输入的数据暂时存入此类中的集合里
 */
public class TemporarilyStoreData {
    private String string;
    public TemporarilyStoreData() {

    }

    /**
     * 遍历集合
     */
    public void getHashset(){
        System.out.println("string = " + string);
    }

    /**
     *
     * @param string 传入数据
     * @return 返回该数据
     */
    public String Submit(String string) {
        this.string = string;
        NameWriteThread nameWriteThread = new NameWriteThread();
        nameWriteThread.setToWrite(string);
        Thread thread = new Thread(nameWriteThread);
        thread.start();
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemporarilyStoreData that = (TemporarilyStoreData) o;
        return Objects.equals(string, that.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string);
    }
}
