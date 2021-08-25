package top.xinsin.io;

import java.io.*;

public class ModifyFile extends AbsName {
    public ModifyFile() {
    }

    public String getModifyFile(String index){
        String s;
        BufferedReader bufferedReader = null;
        File file = new File(newPath + index + ".txt");
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            log.info("dsa"+file.toURI());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str).append("\n");
            }
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            s = stringBuilder.toString();
        }
        return s;
    }
}
