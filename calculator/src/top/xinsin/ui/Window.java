package top.xinsin.ui;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Window extends BorderPane {
    public Window() {
        VBox vBox = new VBox();
        vBox.getChildren().add(displayBox());
        for (Button a :
                buttons()) {
            vBox.getChildren().add(a);
        }
        setCenter(vBox);
    }

    protected TextField displayBox(){
        TextField displayBox = new TextField();
        return displayBox;
    }

    protected Button[] buttons(){
        Button[] buttons = new Button[9];
        for (int i = 0; i < buttons.length; i++) {
            Button a = new Button(Integer.toString(i));
            a.setFont(new Font("华文细黑",20));
            buttons[i] = a;
        }
        return buttons;
    }
}
