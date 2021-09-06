package top.xinsin.ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import top.xinsin.io.NameRead;
import top.xinsin.util.StudentName;

import java.io.IOException;

import static top.xinsin.randomOrderMain.log;

public class MainWindowController {
    @FXML
    public Button randomButton;
    @FXML
    public Label randomRes;
    @FXML
    public Label classesName;
    @FXML
    public TextArea surplus;

    private StudentName studentName = StudentName.getInstance();
    private String name = null;

    @FXML
    public void RandomListener(ActionEvent actionEvent) {
        name = studentName.call();
        randomRes.setText(name);
        log.info("随机点到了" + name + "同学");
        surplus.setText(new String(studentName.get()));
        classesName.setText("123");
    }

    public MainWindowController() {
        try {
            NameRead.read("123");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
