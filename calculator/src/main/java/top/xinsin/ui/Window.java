package top.xinsin.ui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Window extends BorderPane {
    public final Font font =  new Font("华文宋体",30);
    private TextField displayBox = null;
    public Window() {
        displayBox = new TextField();
        VBox vBox = new VBox();
        HBox hBox = new HBox();
        hBox.getChildren().addAll(one(),two(),three(),plus());
        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(four(),five(),six(),minus());
        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(seven(),eight(),nine(),multiply());
        HBox hBox3 = new HBox();
        hBox3.getChildren().addAll(point(),zero(),pass(),divide());
        vBox.getChildren().addAll(displayBox,hBox,hBox1,hBox2,hBox3);
        setCenter(vBox);
    }

    protected Button zero(){
        Button button = new Button("0");
        button.setMinWidth(60);
        button.setFont(font);
        button.setOnAction(event -> {
            displayBox.setText("0");
        });
        button.setOnKeyReleased(event -> {
            System.out.println("event = " + event.getCode());
            if (event.getCode() == KeyCode.DIGIT0){
                System.out.println(0);
                displayBox.setText("0");
            }
        });
        return button;
    }
    protected Button one(){
        Button button = new Button("1");
        button.setMinWidth(60);
        button.setFont(font);
        button.setOnAction(event -> {
            displayBox.setText("1");
        });
        return button;
    }
    protected Button two(){
        Button button = new Button("2");
        button.setMinWidth(60);
        button.setFont(font);
        button.setOnAction(event -> {
            displayBox.setText("2");
        });
        return button;
    }
    protected Button three(){
        Button button = new Button("3");
        button.setMinWidth(60);
        button.setFont(font);
        button.setOnAction(event -> {
            displayBox.setText("3");
        });
        return button;
    }
    protected Button four(){
        Button button = new Button("4");
        button.setMinWidth(60);
        button.setFont(font);
        button.setOnAction(event -> {
            displayBox.setText("4");
        });
        return button;
    }
    protected Button five(){
        Button button = new Button("5");
        button.setMinWidth(60);
        button.setFont(font);
        button.setOnAction(event -> {
            displayBox.setText("5");
        });
        return button;
    }
    protected Button six(){
        Button button = new Button("6");
        button.setMinWidth(60);
        button.setFont(font);
        button.setOnAction(event -> {
            displayBox.setText("6");
        });
        return button;
    }
    protected Button seven(){
        Button button = new Button("7");
        button.setMinWidth(60);
        button.setFont(font);
        button.setOnAction(event -> {
            displayBox.setText("7");
        });
        return button;
    }
    protected Button eight(){
        Button button = new Button("8");
        button.setMinWidth(60);
        button.setFont(font);
        button.setOnAction(event -> {
            displayBox.setText("8");
        });
        return button;
    }
    protected Button nine(){
        Button button = new Button("9");
        button.setMinWidth(60);
        button.setFont(font);
        button.setOnAction(event -> {
            displayBox.setText("9");
        });
        return button;
    }
    protected Button point(){
        Button button = new Button(".");
        button.setMinWidth(60);
        button.setFont(font);
        return button;
    }
    protected Button pass(){
        Button button = new Button(" ");
        button.setMinWidth(60);
        button.setFont(font);
        return button;
    }
    protected Button plus(){
        Button button = new Button("+");
        button.setMinWidth(60);
        button.setFont(font);
        return button;
    }
    protected Button minus(){
        Button button = new Button("-");
        button.setMinWidth(60);
        button.setFont(font);
        return button;
    }
    protected Button multiply(){
        Button button = new Button("*");
        button.setMinWidth(60);
        button.setFont(font);
        return button;
    }
    protected Button divide(){
        Button button = new Button("/");
        button.setMinWidth(60);
        button.setFont(font);
        return button;
    }
    class EventHandler implements javafx.event.EventHandler{

        @Override
        public void handle(Event event) {

        }
    }
}
