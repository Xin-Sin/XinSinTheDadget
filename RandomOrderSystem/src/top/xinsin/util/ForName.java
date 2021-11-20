package top.xinsin.util;

import javafx.scene.control.Label;

public class ForName implements Runnable{
    private Label randomRes;
    private StudentName studentName = null;
    private boolean boll;

    public ForName(Label randomRes,boolean boll) {
        this.randomRes = randomRes;
        this.studentName = StudentName.getInstance();
        this.boll = boll;
    }

    @Override
    public void run() {
        int i = 0;
        while (i <= 10){
            System.out.println(Thread.currentThread());
            randomRes.setText(String.valueOf(studentName.arrayList.get(i)));
            i++;
            if (i == studentName.arrayList.size()){
                i = 0;
            }
        }
    }
}
