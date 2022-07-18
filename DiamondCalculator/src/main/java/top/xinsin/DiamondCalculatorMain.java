package top.xinsin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class DiamondCalculatorMain extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/MainWindow.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("钻石计算器");
        stage.show();
    }
}
