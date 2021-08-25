package top.xinsin.ui;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import top.xinsin.list.Element;
import top.xinsin.io.AbsName;
import top.xinsin.io.ModifyFile;
import top.xinsin.io.NameReadThread;
import top.xinsin.io.TemporarilyStoreData;
import top.xinsin.list.StudentName;

import java.io.File;

/**
 * 程序的主窗口(不出意外不会是这一个类的)
 */
public class RandomWindow extends BorderPane {
    private String name;
    private final Label returnName;
    private TextArea textArea;
    private final TemporarilyStoreData temporarilyStoreData = new TemporarilyStoreData();

    /**
     * 本类中将实现该主界面所有功能
     * 创建用于随机的按钮
     */
    public RandomWindow() {
        returnName = new Label("Name");
        returnName.setLayoutX(150);
        returnName.setLayoutY(40);
        returnName.setFont(new Font(20));
        setStyle("-fx-background-image: url(/Images/Background/background.png);-fx-background-repeat: no-repeat");
        setTop(getMenubar());
        setLeft(vBox());
        setCenter(VBox1());
    }
    /**
     * 创建随机按钮
     * @return 返回随机按钮
     */
    private Button getRandomButton(){
        Button random = new Button("",new ImageView("/Images/Icon/Random.png"));
        random.setLayoutX(30);
        random.setLayoutY(50);
        random.setFont(new Font(20));
        random.setOnAction(e ->{
            name = new StudentName().call();
            returnName.setText(name);
        });
        return random;
    }
    private VBox VBox1(){
        VBox VBox = new VBox();
        VBox.setAlignment(Pos.TOP_CENTER);
        VBox.getChildren().addAll(getRandomButton(),returnName);
        return VBox;
    }
    /**
     * 创建菜单
     * @return 返回菜单栏
     */
    private MenuBar getMenubar(){
        MenuBar menubar = new MenuBar();
        menubar.setMaxWidth(400);
        menubar.getMenus().addAll(file(), edit(),help());
        return menubar;
    }
    private Menu file(){
        Menu file = new Menu("文件");
        file.getItems().addAll(openClass(),exit());
        return file;
    }
    /**
     * 创建打开班级的多级菜单
     * @return 返回多级菜单
     */
    private Menu openClass(){
        Menu openClass = new Menu("打开班级");
        openClass.getItems().addAll(classes());
        return openClass;
    }
    private MenuItem classes(){
        MenuItem classes = new MenuItem("1");
        classes.setOnAction(e ->{
            NameReadThread nameReadThread = new NameReadThread();
            Thread thread = new Thread(nameReadThread);
            nameReadThread.setIndex("1");
            thread.start();
        });
        return classes;
    }
    private MenuItem exit(){
        MenuItem exit = new MenuItem("退出");
        exit.setOnAction(e -> Platform.exit());
        return exit;
    }
    private Menu edit(){
        Menu edit = new Menu("编辑");
        edit.getItems().addAll(newClass(),reviseClass());
        return edit;
    }

    /**
     * 创建修改班级的多级菜单
     * @return 返回多级菜单
     */
    private Menu reviseClass(){
        Menu reviseClass = new Menu("修改班级");
        reviseClass.getItems().addAll(classes1());
        return reviseClass;
    }
    private MenuItem classes1(){
        MenuItem classes1 = new MenuItem("1");
        classes1.setOnAction(e ->{
            newTextArea();
            textArea.setText(new ModifyFile().getModifyFile("1"));
        });
        return classes1;
    }
    private MenuItem newClass(){
        MenuItem newClass = new MenuItem("新建班级");
        newClass.setOnAction(e -> newTextArea());
        return newClass;
    }
    private Menu help(){
        Menu help = new Menu("帮助");
        help.getId();
        return help;
    }
    /**
     * 创建个新的文本框窗口
     * @return 返回一个Stage
     */
    private Stage newTextArea(){
        Stage newTextArea = new Stage();
        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane,300,200);
        textArea = new TextArea();
        Button submit = new Button("确认");
        submit.setOnAction(e ->{
            String str = textArea.getText();
            newTextArea.close();
            temporarilyStoreData.Submit(str);
            fileSave();
        });
        submit.setLayoutY(150);
        submit.setLayoutX(120);
        submit.setFont(new Font(20));
        textArea.setMaxHeight(150);
        anchorPane.getChildren().addAll(textArea,submit);
        newTextArea.setTitle("新班级");
        newTextArea.getIcons().add(new Image("/Images/Icon/logo.png"));
        newTextArea.setScene(scene);
        newTextArea.show();
        return newTextArea;
    }

    /**
     * 创建文件保存对话框
     * @return 返回文件保存对话框
     */
    private FileChooser fileSave(){
        FileChooser fileSave = new FileChooser();
        fileSave.setTitle("保存文件");
        fileSave.setInitialDirectory(new File(AbsName.newPath));
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("文本文件(*.txt)","*.txt");
        fileSave.getExtensionFilters().addAll(filter);
        File file = fileSave.showSaveDialog(StartWindow.stage);
        return fileSave;
    }

    private VBox vBox(){
        VBox vBox = new VBox();
        vBox.getChildren().addAll(classList(),showClass());
        vBox.setAlignment(Pos.TOP_CENTER);
        return vBox;
    }
    /**
     * 创建下拉框
     * @return 返回下拉框
     */
    private ComboBox<String> classList(){
        ComboBox<String> classList = new ComboBox<>(new Element().ObservableList());
        classList.setMinWidth(50);
        classList.getSelectionModel().select(0);
        classList.getSelectionModel().selectedItemProperty().addListener(e ->{
           String str = "当前班级是" +classList.getSelectionModel().getSelectedItem();
           showClass().setText(str);
        });
        return classList;
    }
    private Label showClass(){
        Label showClass = new Label("dsa");
        showClass.setFont(new Font(20));
        return showClass;
    }
}
