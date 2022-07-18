package top.xinsin.ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import top.xinsin.io.NameWrite;

import java.io.IOException;

import static top.xinsin.randomOrderMain.stage;

public class FirstUseWindowController {
    @FXML
    public TextField classesNames;
    @FXML
    public TextArea studentsNames;
    @FXML
    public Button confirmButton;

    @FXML
    public void confirmLister(ActionEvent actionEvent) {
        try {
            NameWrite.write(classesNames.getText(),studentsNames.getText());
            stage.close();
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/res/Fxml/MainWindow.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
