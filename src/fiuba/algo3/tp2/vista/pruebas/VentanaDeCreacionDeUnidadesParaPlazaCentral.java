package fiuba.algo3.tp2.vista.pruebas;

import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.vista.ventanas.VentanaPlazaCentral;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VentanaDeCreacionDeUnidadesParaPlazaCentral extends Application {

    public static void main(String args[]){

        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {

        PlazaCentral plazaCentral = new PlazaCentral(new Posicion(5,5), new Mapa(250,250));

        VentanaPlazaCentral ventana = new VentanaPlazaCentral(plazaCentral, new Mapa(250, 250));

        stage.setTitle("Ventana de Prueba");

        Button boton = new Button("Abrir ventana de plaza central");

        boton.setOnAction(e-> ventana.mostrarPorPantalla());

        StackPane layout = new StackPane();

        layout.getChildren().add(boton);

        Scene scene = new Scene(layout);

        stage.setScene(scene);

        stage.show();

    }

}
