package top.xinsin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import top.xinsin.io.NameRead;

import java.io.IOException;
import java.util.logging.Logger;

import static top.xinsin.io.AbsName.file;

/**
 * 整个程序的入口
 * 已修改
 */
public class randomOrderMain extends Application {
    public static final Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args) {
        new NameRead();
        launch(args);
    }
    public static Stage stage = new Stage();

    @Override
    public void start(Stage pStage) throws Exception {
        stage.setTitle("随机点名");
        stage.getIcons().add(new Image("/res/Images/Icon/logo.png"));
        if (file.listFiles().length == 0){
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/res/Fxml/FirstUseWindow.fxml"))));
        }else{
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/res/Fxml/MainWindow.fxml"))));
        }
        stage.show();
    }
}