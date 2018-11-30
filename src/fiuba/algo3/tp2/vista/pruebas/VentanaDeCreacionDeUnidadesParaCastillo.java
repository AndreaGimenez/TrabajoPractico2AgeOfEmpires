package fiuba.algo3.tp2.vista.pruebas;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.vista.ventanas.VentanaCastillo;
import fiuba.algo3.tp2.vista.ventanas.VentanaPlazaCentral;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VentanaDeCreacionDeUnidadesParaCastillo extends Application {

    public static void main(String args[]){

        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {

        Castillo castillo = new Castillo(new Posicion(5,5), new Mapa(250,250));

        VentanaCastillo ventana = new VentanaCastillo(castillo);

        stage.setTitle("Ventana de Prueba");

        Button boton = new Button("Abrir ventana de castillo");

        boton.setOnAction(e-> ventana.mostrarPorPantalla());

        StackPane layout = new StackPane();

        layout.getChildren().add(boton);

        Scene scene = new Scene(layout);

        stage.setScene(scene);

        stage.show();

    }

}
