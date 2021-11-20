package top.xinsin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import top.xinsin.ui.MainWindow;

public class BigFishEatSmallFish extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        MainWindow mainWindow = new MainWindow();
        Scene scene = new Scene(mainWindow,1400,400);

    }
}
