package top.xinsin;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import top.xinsin.util.ReadJson;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.io.IOException;

import static top.xinsin.util.Regex.getPasswordAndAccount;

/**
 * Created On 7/11/22 8:34 AM
 *
 * @author xinsin
 * @version 1.0.0
 */
public class MainController {
    private static final String jsonFilePath = "resources/cards.json";
    private static final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    public TextField password;
    public TextField account;
    public Label count;
    public Label total;

    private JSONObject jsonObject;

    public void go(ActionEvent actionEvent) {
        JSONArray cards = jsonObject.getJSONArray("cards");
        int count = jsonObject.getIntValue("count");
        int total = jsonObject.getIntValue("total");
        if(count < total){
            String[] passwordAndAccount = getPasswordAndAccount(cards.getString(count));
            this.account.setText(passwordAndAccount[0]);
            this.password.setText(passwordAndAccount[1]);
            try {
                ReadJson.writeCount(jsonObject, new File(jsonFilePath));
                this.count.setText(String.valueOf(count + 1));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            this.account.setText("当前已经没有卡号了");
            this.password.setText("当前下标已经超过总数");
        }
    }

    public void accountClick(MouseEvent mouseEvent) {
        pauseAndCopy(this.account.getText());
    }

    public void passwordClick(MouseEvent mouseEvent) {
        pauseAndCopy(this.password.getText());
    }
    private void pauseAndCopy(String content){
        Transferable trans = new StringSelection(content);
        clipboard.setContents(trans, null);
    }
    public void init(){
        try {
            jsonObject = ReadJson.readJson(new File(jsonFilePath));
            if (jsonObject.getJSONArray("cards").size() != jsonObject.getIntValue("total")){
                jsonObject = ReadJson.writeTotal(jsonObject, new File(jsonFilePath));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Integer count = ReadJson.readCount(jsonObject);
        Integer total = ReadJson.readTotal(jsonObject);
        String[] passwordAndAccount = getPasswordAndAccount(ReadJson.readCards(jsonObject).get(count - 1));
        this.count.setText(count.toString());
        this.total.setText(total.toString());
        this.account.setText(passwordAndAccount[0]);
        this.password.setText(passwordAndAccount[1]);
    }

    public void paneMove(MouseEvent mouseEvent) {
        if (this.password.getText().isEmpty() || this.account.getText().isEmpty() || this.count.getText().isEmpty() || this.total.getText().isEmpty()) {
            init();
        }
    }
}
