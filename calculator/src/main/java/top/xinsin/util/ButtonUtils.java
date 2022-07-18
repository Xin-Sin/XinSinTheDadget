package top.xinsin.util;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class ButtonUtils {
    public static final Font font =  new Font("华文宋体",30);
    public static Button CB(String text){
        Button button = new Button(text);
        button.setMinWidth(60);
        button.setFont(font);
        return button;
    }
}
