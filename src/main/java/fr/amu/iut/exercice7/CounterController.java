package fr.amu.iut.exercice7;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CounterController implements Initializable {
    @FXML
    public Label counterLabel;




    int counter = 0;

    @FXML
    public void increment() {
        counter = counter + 1;
        counterLabel.setText(String.valueOf(counter));
    }
    @FXML
    public void decrement() {
        counter = counter - 1;
        counterLabel.setText(String.valueOf(counter));

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing CounterController...");
   }
}
