package top.xinsin.ui.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import top.xinsin.io.AbsName;
import top.xinsin.io.NameRead;
import top.xinsin.io.NameWrite;
import top.xinsin.io.SelectFile;
import top.xinsin.util.ForName;
import top.xinsin.util.StudentName;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static top.xinsin.randomOrderMain.log;

public class MainWindowController extends AbsName implements Initializable  {
    @FXML
    public Button randomButton;
    @FXML
    public Label randomRes;
    @FXML
    public Label classesName;
    @FXML
    public TextArea surplus;
    @FXML
    public TextField rightExitClasses;
    @FXML
    public TextArea rightExitClassesNames;
    @FXML
    public Button rightConfirmAndSave;
    @FXML
    public Menu selectClasses;
    @FXML
    public Menu editClasses;
    @FXML
    public Menu viewClasses;
    @FXML
    public Menu delClasses;
    @FXML
    public Button stopButton;

    private StudentName studentName = null;
    private String[] strings = null;
    private boolean boll = true;

    public MainWindowController() {}
    @FXML
    public void RandomListener(ActionEvent actionEvent) {
        randomButton.setVisible(false);
        stopButton.setVisible(true);
        randomRes.setText(null);
        /*Platform.runLater(() -> {
            int i = 0;
            while (i <= 10){
                System.out.println(Thread.currentThread());
                randomRes.setText(String.valueOf(studentName.arrayList.get(i)));
                i++;
                if (i == studentName.arrayList.size()){
                    i = 0;
                }
            }
        });*/
    }
    @FXML
    public void stopButtonListener(ActionEvent actionEvent) {
        randomButton.setVisible(true);
        stopButton.setVisible(false);
        String name = studentName.call();
        randomRes.setText(name);
        log.info("随机点到了'" + name + "'同学");
        surplus.setText(new String(studentName.get()));
    }
    /**
     * 新增班级
     * 已编写完成
     * @param actionEvent
     */
    @FXML
    public void newClasses(ActionEvent actionEvent) {
        rightExitClasses.setDisable(false);
        rightExitClasses.setEditable(true);
        rightExitClassesNames.setDisable(false);
        rightExitClassesNames.setEditable(true);
        rightConfirmAndSave.setDisable(false);
    }

    /**
     * 退出子菜单
     * 已完成
     * @param actionEvent
     */
    @FXML
    public void exit(ActionEvent actionEvent) {
        System.exit(1);
    }

    /**
     * 右侧保存按钮
     * 逻辑已编写完成
     * @param actionEvent
     */
    @FXML
    public void rightConfirmAndSaveButton(ActionEvent actionEvent) {
        try {
            NameWrite.write(rightExitClasses.getText(),rightExitClassesNames.getText());
            log.info("创建了" + rightExitClasses.getText() + "班级并保存了" );
            rightExitClasses.setDisable(true);
            rightExitClasses.setEditable(false);
            rightExitClassesNames.setDisable(true);
            rightExitClassesNames.setEditable(false);
            rightConfirmAndSave.setDisable(true);
            rightExitClasses.setText(null);
            rightExitClassesNames.setText(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        strings = file.list();
        /**
         * 选择班级
         */
        for (int i = 0; i < strings.length; i++) {
            MenuItem menuItem = new MenuItem(strings[i]);
            final int i1 = i;
            menuItem.setOnAction(event -> {
                try {
                    NameRead.read(strings[i1]);
                    studentName = StudentName.getInstance();
                    classesName.setText(strings[i1]);
                    surplus.setText(new String(studentName.get()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            selectClasses.getItems().add(menuItem);
//            editClasses.getItems().add(menuItem);
//            delClasses.getItems().add(menuItem);
        }
        /**
         * 查询班级
         */
        for (int i = 0; i < strings.length; i++) {
            MenuItem menuItem = new MenuItem(strings[i]);
            final int i1 = i;
            menuItem.setOnAction(event -> {
                try {
                    rightExitClasses.setText(strings[i1]);
                    rightExitClassesNames.setText(new String(SelectFile.selectFileClass(strings[i1])));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            viewClasses.getItems().add(menuItem);
        }
        studentName = StudentName.getInstance();
        classesName.setText(strings[0]);
//        randomButton.setStyle("-fx-background-image: url('/res/Images/Icon/Random.png');-fx-background-size: 200px");
        try {
            NameRead.read(strings[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
