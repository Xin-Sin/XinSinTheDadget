package top.xinsin.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * 用来存储下拉列表中的元素
 */
public class Element {
    private final ArrayList<String> arrayList = new ArrayList<>();
    public Element() {

    }

    public void addElement(String str){
        arrayList.add(str);

    }

    public void getElementList(){
        for (String str:arrayList) {
            System.out.println("str = " + str);
        }
    }

    public ObservableList<String> ObservableList() {
        return FXCollections.observableArrayList(arrayList);
    }
}
