package fr.amu.iut.exercice7;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ResourceBundle;

public class CounterController implements Initializable {

    @FXML
    public VBox VB = new VBox();

    @FXML
    public Label LA = new Label("0");


    @FXML
    public HBox HB = new HBox();


    int counter = 0;

    public void increment() {
        counter = counter + 1;
        LA.setText(String.valueOf(counter));
    }

    public void decrement() {
        counter = counter - 1;
        LA.setText(String.valueOf(counter));

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing CounterController...");
   }
}
