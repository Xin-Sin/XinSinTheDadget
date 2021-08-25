package top.xinsin.io;

import java.io.File;
import java.util.logging.Logger;

/**
 * 整个IO通用的属性
 */
public abstract class AbsName {
    protected String path = System.getProperty("user.dir");
    public static String newPath;
    protected String index = "0";
    protected static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    protected File file;
    protected AbsName() {

        int firstIndex = this.path.lastIndexOf(System.getProperty("path.separator")) + 1;

        int lastIndex = this.path.lastIndexOf(File.separator) + 1;

        this.path = this.path.substring(firstIndex, lastIndex);

        newPath = this.path + "classes" + File.separator;

        file = new File(newPath);

        if (!file.isDirectory()) {

            file.mkdir();

            log.info("创建"+this.file.toURI()+"路径下的文件夹");

        }
    }
}
