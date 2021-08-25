package top.xinsin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import top.xinsin.ui.Window;
import top.xinsin.util.CalculateUtils;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(CalculateUtils.to("10010", 2, 8));
        Scene scene = new Scene(new Window(),300,400);
        primaryStage.setTitle("计算器");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
