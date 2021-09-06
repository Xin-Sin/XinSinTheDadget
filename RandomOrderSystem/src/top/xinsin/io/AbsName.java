package top.xinsin.io;

import java.io.File;

import static top.xinsin.randomOrderMain.log;

/**
 * 整个IO通用的属性
 */
public abstract class AbsName {
    protected static String path = System.getProperty("user.dir");
    public static String newPath = path + File.separator + "classes" + File.separator;
    public static File file = new File(newPath);
    protected AbsName() {
        if (!file.isDirectory()) {
            if (file.mkdir()){
                log.info("创建"+file.toURI()+"路径下的文件夹");
            }else{
                log.info("创建"+file.toURI()+"路径下的文件夹时失败了");
            }
        }
    }
}
