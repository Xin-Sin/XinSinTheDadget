package top.xinsin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DiamondCalculatorMain extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/top/xinsin/ui/MainWindow.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("钻石计算器");
        stage.show();
    }
}
