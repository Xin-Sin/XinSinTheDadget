package top.xinsin.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * 整个gui程序的启动方法
 */
public class StartWindow extends Application{
    public static Stage stage;
    @Override
    public void start(Stage stage){
        RandomWindow randomWindow = new RandomWindow();
        Scene scene = new Scene(randomWindow,400,400);
        stage.setTitle("RandomOrderSystem");
        stage.getIcons().add(new Image("/Images/Icon/logo.png"));
        stage.setScene(scene);
        stage.show();
    }
}
