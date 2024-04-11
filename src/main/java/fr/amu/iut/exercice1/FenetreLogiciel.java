package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.InputStream;

import javafx.scene.image.Image;


public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        // code de l'exercice 1

        Parameters params = getParameters();
        int width = 300;
        int height = 150;

        if (params.getRaw().size() > 0) {
            // Utiliser le premier argument passé en ligne de commande comme largeur de la fenêtre
            width = Integer.parseInt(params.getRaw().get(0));
        }

        if (params.getRaw().size() > 1) {
            // Utiliser le deuxième argument passé en ligne de commande comme hauteur de la fenêtre
            height = Integer.parseInt(params.getRaw().get(1));
        }

        // Créer une scène
        BorderPane bp = new BorderPane();
        Scene scene = new Scene(bp, width, height);

        HBox HT = new HBox();



        // Create menus
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");

        MenuBar menuBar = new MenuBar();



        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);
        //file
        MenuItem newItem = new MenuItem("New");
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem exitItem = new MenuItem("Exit");
        //Edit
        MenuItem cutItem = new MenuItem("Cut");
        MenuItem copyItem = new MenuItem("Copy");
        MenuItem pasteItem = new MenuItem("Paste");


        fileMenu.getItems().addAll(newItem, openItem, saveItem, exitItem);
        editMenu.getItems().addAll(cutItem, copyItem, pasteItem);

        VBox VM = new VBox();
        HBox HM1 = new HBox();
        HBox HM2 = new HBox();
        HBox HB = new HBox();
        VBox VB = new VBox();

        Label lt = new Label("Boutons :");
        Label lb = new Label("Ceci est un label de bas de page");
        Button b1 = new Button("Bouton 1");
        Button b2 = new Button("Bouton 2");
        Button b3 = new Button("Bouton 3");

        Separator sepV = new Separator(Orientation.VERTICAL);
        Separator sepH = new Separator(Orientation.HORIZONTAL);
        VM.getChildren().addAll(lt, b1, b2, b3);
        VM.setSpacing(10);
        HM1.getChildren().addAll(VM, sepV);

        HB.getChildren().add(lb);
        VB.getChildren().addAll(sepH, HB);

        VM.setAlignment(Pos.CENTER);
        VBox.setVgrow(VM, Priority.ALWAYS);
        HB.setAlignment(Pos.CENTER);

        GridPane gridpane = new GridPane();
        Label lb1 = new Label("Name:");
        Label lb2 = new Label("Email:");
        Label lb3 = new Label("Password:");
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField t3 = new TextField();
        gridpane.addRow(0,lb1, t1);
        gridpane.addRow(1,lb2, t2);
        gridpane.addRow(2,lb3, t3);
        Button b4 = new Button("Submit");
        Button b5 = new Button("Cancel");
        gridpane.addRow(3,b4, b5);
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setAlignment( Pos.CENTER);
        bp.setCenter(gridpane);


        bp.setTop(menuBar);
        bp.setLeft(HM1);
        bp.setBottom(VB);

        Separator separator = new Separator(Orientation.VERTICAL);






        // Définir la scène principale de l'application
        primaryStage.setScene(scene);
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }
}

