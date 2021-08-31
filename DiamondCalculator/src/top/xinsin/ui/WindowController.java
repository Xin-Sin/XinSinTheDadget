package top.xinsin.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static top.xinsin.util.Calculate.chunkDiamond;

public class WindowController implements Initializable {
    @FXML
    public TextField seed;
    @FXML
    public TextField chunkX;
    @FXML
    public TextField chunkZ;
    @FXML
    public Button commit;
    @FXML
    public TextField diamondX;
    @FXML
    public TextField diamondZ;
    @FXML
    public Button allCommit;
    @FXML
    public TextArea allRes;
    @FXML
    public TextField allSeed;

    @FXML
    public void commitButton(ActionEvent actionEvent) {
        String[] strings =  chunkDiamond(Long.parseLong(seed.getText()),Long.parseLong(chunkX.getText()),Long.parseLong(chunkZ.getText()));
        diamondX.setText(strings[0]);
        diamondZ.setText(strings[1]);
    }

    @FXML
    public void allCommitButton(ActionEvent actionEvent) {

    }
    public WindowController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
