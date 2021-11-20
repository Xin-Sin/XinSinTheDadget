package top.xinsin.ui;

import top.xinsin.io.CopyPasteIO;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MainWindow extends JFrame {
    @Override
    protected void frameInit() {
        JFrame jf = new JFrame("批量复制文件");
        JPanel jp = new JPanel();

        JTextField jTextField1 = new JTextField(30);
        JTextField jTextField2 = new JTextField(30);
        JButton jButton = new JButton("开始复制");

                jTextField1.setText("E:\\单子号\\730");
                jTextField2.setText("D:\\Steam\\userdata");
//        jTextField1.setText("D:\\XinSinTheDadget\\Ctrl-CV\\Test\\730");
//        jTextField2.setText("D:\\XinSinTheDadget\\Ctrl-CV\\Test\\b");

        jp.add(jTextField1);
        jp.add(jTextField2);
        jp.add(jButton);

        jButton.addActionListener(e -> {
            CopyPasteIO.delete(jTextField2.getText());
            File[] files1 = new File(jTextField2.getText()).listFiles();
            for (File f1 : files1) {
                CopyPasteIO.copy(jTextField1.getText(), f1+ "\\730\\");
            }
        });

        jf.add(jp);
        jf.setBounds(600,300,400,600);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

