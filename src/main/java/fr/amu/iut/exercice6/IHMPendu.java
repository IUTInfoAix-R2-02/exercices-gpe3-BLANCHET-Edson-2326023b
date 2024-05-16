package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class IHMPendu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        BorderPane root = new BorderPane();

        VBox Vb = new VBox();

        Dico dico = new Dico();

        // A completer
        String mot = dico.getMot();

        String motATrouve;
        String motCripte = "*".repeat(mot.length());

        TextField textField = new TextField();




        //ArrayList<Integer> getPosition(textField.getText(), mot);

        //root.set;

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
