package top.xinsin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import top.xinsin.ui.Window;

public class CalculatorMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new Window(),300,400);
        primaryStage.setTitle("计算器");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
