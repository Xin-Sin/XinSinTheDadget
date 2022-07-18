package top.xinsin.io;

import java.io.*;

public class CopyPasteIO {
    public static void delete(String path){
       //文件b
        File file = new File(path);
        File[] files1 = file.listFiles();
        for (File f1 : files1) {
            File[] files2 = f1.listFiles();
            for (File f2 : files2) {
                if (f2.toString().equals(f1 + "\\730")){
                    File[] files3 = f2.listFiles();
                    for (File f3 : files3) {
                        f3.delete();
                    }
                    f2.delete();
                }
            }
        }
        System.out.println("所有730文件夹已删除");
    }

    public static void copy(String A,String B){
        // 创建目标文件夹
        new File(B).mkdirs();
        // 获取源文件夹当前下的文件或目录
        File[] file = (new File(A)).listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                // 复制文件
                try {
                    copyFile(file[i],new File(B+file[i].getName()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (file[i].isDirectory()) {
                // 复制目录
                String sourceDir=A+File.separator+file[i].getName();
                String targetDir=B+File.separator+file[i].getName();
                try {
                    copyDirectiory(sourceDir, targetDir);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    private static void copyFile(File sourceFile,File targetFile) throws IOException{
        // 新建文件输入流并对它进行缓冲
        FileInputStream input = new FileInputStream(sourceFile);
        BufferedInputStream inBuff=new BufferedInputStream(input);

        // 新建文件输出流并对它进行缓冲
        FileOutputStream output = new FileOutputStream(targetFile);
        BufferedOutputStream outBuff=new BufferedOutputStream(output);

        // 缓冲数组
        byte[] b = new byte[1024 * 5];
        int len;
        while ((len =inBuff.read(b)) != -1) {
            outBuff.write(b, 0, len);
        }
        // 刷新此缓冲的输出流
        outBuff.flush();

        //关闭流
        inBuff.close();
        outBuff.close();
        output.close();
        input.close();
    }
    // 复制文件夹
    private static void copyDirectiory(String sourceDir, String targetDir)
            throws IOException {
        // 新建目标目录
        (new File(targetDir)).mkdirs();
        // 获取源文件夹当前下的文件或目录
        File[] file = (new File(sourceDir)).listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                // 源文件
                File sourceFile=file[i];
                // 目标文件
                File targetFile=new File(new File(targetDir).getAbsolutePath()+File.separator+file[i].getName());
                copyFile(sourceFile,targetFile);
            }
            if (file[i].isDirectory()) {
                // 准备复制的源文件夹
                String dir1=sourceDir + "/" + file[i].getName();
                // 准备复制的目标文件夹
                String dir2=targetDir + "/"+ file[i].getName();
                copyDirectiory(dir1, dir2);
            }
        }
    }
}
