package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();





        double x = 40;
        for(int i = 0; i<10; ++i) {
            Obstacle m = new Obstacle(x, 100, 20, 20);
            obstacles.add(m);
            x = x + 20;
        }

        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        pacman.setLayoutX(20);
        pacman.setLayoutY(20);

        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        jeu.getChildren().addAll(obstacles);

        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome, obstacles);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2, ArrayList<Obstacle> obstacles) {

        scene.setOnKeyPressed((KeyEvent event) -> {
            double x;
            double y;
            switch (event.getCode()) {

                case LEFT:
                    x = j1.getLayoutX();
                    j1.deplacerAGauche();
                    if(j1.estEnCollisionObs(obstacles)) {
                        j1.setLayoutX(x);
                    }
                    break;
                case RIGHT:
                    x = j1.getLayoutX();
                    j1.deplacerADroite(scene.getWidth());
                    if(j1.estEnCollisionObs(obstacles)) {
                        j1.setLayoutX(x);
                    }
                    break;
                case DOWN:
                    y = j1.getLayoutY();
                    j1.deplacerEnBas(scene.getHeight());
                    if(j1.estEnCollisionObs(obstacles)) {
                        j1.setLayoutY(y);
                    }
                    break;
                case UP:
                    y = j1.getLayoutY();
                    j1.deplacerEnHaut();
                    if(j1.estEnCollisionObs(obstacles)) {
                        j1.setLayoutY(y);
                    }
                    break;
                case Q:
                    x = j2.getLayoutX();
                    j2.deplacerAGauche();
                    if(j2.estEnCollisionObs(obstacles)) {
                        j2.setLayoutX(x);
                    }

                    break;
                case D:
                    x = j2.getLayoutX();
                    j2.deplacerADroite(scene.getWidth());
                    if(j2.estEnCollisionObs(obstacles)) {
                        j2.setLayoutX(x);
                    }
                    break;
                case S:
                    y = j2.getLayoutY();
                    j2.deplacerEnBas(scene.getHeight());
                    if(j2.estEnCollisionObs(obstacles)) {
                        j2.setLayoutY(y);
                    }
                    break;
                case Z:
                    y = j2.getLayoutY();
                    j2.deplacerEnHaut();
                    if(j2.estEnCollisionObs(obstacles)) {
                        j2.setLayoutY(y);
                    }
                    break;

            }
            if (j1.estEnCollisionJ(j2))
                System.exit(0);
            else if (j1.estEnCollisionObs(obstacles)) {
                System.out.println("Collision");
            }

        });
    }


}
