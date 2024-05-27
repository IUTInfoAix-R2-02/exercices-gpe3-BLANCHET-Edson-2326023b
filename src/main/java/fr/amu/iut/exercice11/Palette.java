package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;

    private IntegerProperty nbFois;
    private StringProperty message;

    private StringProperty couleurPanneau;


    public Palette(){
        nbFois = new SimpleIntegerProperty();
        message = new SimpleStringProperty();
        couleurPanneau = new SimpleStringProperty("#FFFFFF");
    }

    public int getNbFois() {
        return nbFois.get();
    }

    public IntegerProperty nbFoisProperty() {
        return nbFois;
    }

    public void setNbFois(int nbFois) {
        this.nbFois.set(nbFois);
    }

    public String getMessage() {
        return message.get();
    }

    public StringProperty messageProperty() {
        return message;
    }

    public void setMessage(String message) {
        this.message.set(message);
    }


    public String getCouleurPanneau() {
        return couleurPanneau.get();
    }

    public StringProperty couleurPanneauProperty() {
        return couleurPanneau;
    }

    public void setCouleurPanneau(String couleurPanneau) {
        this.couleurPanneau.set(couleurPanneau);
    }




    private void createBindings(){
        BooleanProperty pasEncoreDeClic = new SimpleBooleanProperty();
        pasEncoreDeClic.bind(Bindings.equal(nbFois, 0));
        texteDuHaut.textProperty().bind(Bindings.when(pasEncoreDeClic).then("Cliquez sur un bouton.").otherwise(Bindings.concat(message, " choisi ", nbFois, " fois.")));
        panneau.styleProperty().bind(Bindings.concat("-fx-background-color:", couleurPanneau));
        texteDuBas.styleProperty().bind(Bindings.concat("-fx-text-fill:", couleurPanneau));
        texteDuBas.textProperty().bind(Bindings.when(pasEncoreDeClic).then("").otherwise(Bindings.concat(message, " est une jolie couleur !")));

    }

    @Override
    public void start(Stage primaryStage) {


        root = new BorderPane();

        texteDuHaut = new Label();


        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);


        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        /* VOTRE CODE ICI */
        createBindings();
;




        vert.setOnAction(event -> {
            nbVert++;
            setCouleurPanneau("#08CC0A");
            setMessage("Vert");
            setNbFois(nbVert);
//            texteDuHaut.setText(getMessage() + " choisi "+ getNbFois() +" fois.");
        });

        rouge.setOnAction(event -> {
            nbRouge++;
            setCouleurPanneau("#FF0000");
            setMessage("Rouge");
            setNbFois(nbRouge);
//            texteDuHaut.setText("Rouge choisi "+ getNbFois() +" fois.");
        });


        bleu.setOnAction(event -> {
            nbBleu++;
            setCouleurPanneau("#0620FB");
            setMessage("Bleu");
            setNbFois(nbBleu);
//            texteDuHaut.setText("Bleu choisi "+ getNbFois() +" fois.");
        });



        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

