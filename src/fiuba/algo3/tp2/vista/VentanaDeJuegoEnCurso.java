package fiuba.algo3.tp2.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class VentanaDeJuegoEnCurso extends Application {

    private static void main(String args[]){

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Prueba de interfaz");

        StackPane layout = new StackPane();

        MenuBar barraDeMenu = new MenuBar();

        HBox estadoDelJugador = new HBox();

        VBox interaccionConElUsuario = new VBox();

        HBox mapa = new HBox();

        layout.getChildren().add(mapa);

        layout.getChildren().add(interaccionConElUsuario);

        layout.getChildren().add(estadoDelJugador);

        Scene scene = new Scene(layout);

        primaryStage.setScene(scene);

        primaryStage.show();

    }
}
