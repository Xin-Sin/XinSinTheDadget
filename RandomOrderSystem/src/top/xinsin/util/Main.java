package top.xinsin.util;

import javafx.application.Application;
import top.xinsin.io.NameReadThread;
import top.xinsin.ui.StartWindow;

/**
 * 整个程序的入口
 */
public class Main {
    public static void main(String[] args) {
        new Thread(new NameReadThread()).start();
        Application.launch(StartWindow.class);
    }
}