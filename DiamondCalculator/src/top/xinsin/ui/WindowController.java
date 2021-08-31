package top.xinsin.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

import java.net.URL;
import java.util.ResourceBundle;

import static top.xinsin.util.Calculate.chunkDiamondSeven;
import static top.xinsin.util.Calculate.chunkDiamondSix;

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
    public ToggleButton cutover;

    @FXML
    public void commitButton(ActionEvent actionEvent) {
        if (cutover.isSelected() == false){
            String[] strings =  chunkDiamondSix(Long.parseLong(seed.getText()),Long.parseLong(chunkX.getText()),Long.parseLong(chunkZ.getText()));
            diamondX.setText(strings[0]);
            diamondZ.setText(strings[1]);
        }else if (cutover.isSelected() == true){
            String[] strings =  chunkDiamondSeven(Long.parseLong(seed.getText()),Long.parseLong(chunkX.getText()),Long.parseLong(chunkZ.getText()));
            diamondX.setText(strings[0]);
            diamondZ.setText(strings[1]);
        }

    }

    @FXML
    public void cutoverMot(ActionEvent actionEvent) {
        if (cutover.isSelected() == false){
            cutover.setText("1.16.5");
        }else if (cutover.isSelected() == true){
            cutover.setText("1.17.1");
        }
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
