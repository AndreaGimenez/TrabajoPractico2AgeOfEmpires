package fiuba.algo3.tp2.vista.ventanas;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeAldeanosEventHandler;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeArqueroEventHandler;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeEspadachinEventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaPlazaCentral {

    private static BotonCreadorDeAldeanosEventHandler botonCreadorDeAldeanosEventHandler;

    private static Button botonDeAldeano;

    public VentanaPlazaCentral(PlazaCentral plazaCentral, Mapa mapa) {

        this.botonDeAldeano = new Button("Crear Aldeano");

        this.botonCreadorDeAldeanosEventHandler = new BotonCreadorDeAldeanosEventHandler(this.botonDeAldeano, plazaCentral, mapa);

    }

    public static void mostrarPorPantalla(){

        Stage stage = new Stage();

        stage.setTitle("Cuartel");

        stage.setMinWidth(200);

        Label label = new Label();

        label.setText("Seleccione la unidad a crear");

        botonDeAldeano.setOnAction(botonCreadorDeAldeanosEventHandler);

        VBox contenidoDeLaVentana = new VBox(10);

        HBox contenedorDeBotones = new HBox(5);

        HBox contenedorDeTexto = new HBox(5);

        contenedorDeTexto.getChildren().add(label);

        contenedorDeBotones.getChildren().add(botonDeAldeano);

        contenedorDeBotones.setAlignment(Pos.CENTER);

        contenedorDeTexto.setAlignment(Pos.CENTER);

        contenidoDeLaVentana.getChildren().add(contenedorDeTexto);

        contenidoDeLaVentana.getChildren().add(contenedorDeBotones);

        Scene scene = new Scene(contenidoDeLaVentana);

        stage.setScene(scene);

        stage.show();



    }

}
