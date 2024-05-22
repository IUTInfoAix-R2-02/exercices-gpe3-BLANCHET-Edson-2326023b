package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {

    @FXML
    public TextField usr;

    @FXML
    public PasswordField pwd;




    @FXML
    private void okClicked() {
        String user = usr.getText();
        String password = new String("");
        for(int i = 0; i < pwd.getLength(); ++i){
            password = password + "*";
        }

        System.out.println(user);
        System.out.println(password);

    }

    @FXML
    private void cancelClicked() {
        usr.clear();
        pwd.clear();
    }
}