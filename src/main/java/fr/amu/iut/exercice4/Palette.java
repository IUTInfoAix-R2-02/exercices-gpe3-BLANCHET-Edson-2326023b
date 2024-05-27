package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.Event;
import javafx.scene.input.MouseEvent;


public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert = new Button("Vert");
    private Button rouge = new Button("Rouge");
    private Button bleu = new Button("Bleu");

    private BorderPane root = new BorderPane();
    int width = 300;
    int height = 150;

    private Scene sc = new Scene(root, width, height);
    private Label label = new Label();
    private Pane panneau = new Pane();
    private HBox bas = new HBox();

    private void buttonClickRed(Event event){
        System.out.println("ButtonClick");
        String couleur="Rouge";
        nbRouge+=1;
        label.setText(couleur+" choisi "+nbRouge+" fois.");

        panneau.setStyle("-fx-background-color: red;");

    }

    private void buttonClickBlue(Event event){
        String couleur="Bleu";
        nbBleu+=1;
        label.setText(couleur+" choisi "+nbBleu+" fois.");
        panneau.setStyle("-fx-background-color: blue;");
    }

    private void buttonClickGreen(Event event){
        String couleur="Vert";
        nbVert+=1;
        label.setText(couleur+" choisi "+nbVert+" fois.");
        panneau.setStyle("-fx-background-color: green;");
    }




    @Override
    public void start(Stage primaryStage) throws Exception {
        bas.setAlignment(Pos.CENTER);
        bas.getChildren().addAll(vert, rouge, bleu);




        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, eventGreen -> buttonClickGreen(eventGreen));
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, eventRouge -> buttonClickRed(eventRouge));
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, eventBleu -> buttonClickBlue(eventBleu));

        root.setTop(label);
        root.setCenter(panneau);
        root.setBottom(bas);

        primaryStage.setScene(sc);
        primaryStage.setTitle("SUU");
        primaryStage.show();
    }



}

