package fiuba.algo3.tp2.vista.ventanas;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeArqueroEventHandler;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeEspadachinEventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaCuartel {

    private static BotonCreadorDeEspadachinEventHandler botonCreadorDeEspadachinEventHandler;

    private static BotonCreadorDeArqueroEventHandler botonCreadorDeArqueroEventHandler;

    private static Button botonDeArquero;

    private static Button botonDeEspadachin;

    public VentanaCuartel(Cuartel cuartel) {

        this.botonDeArquero = new Button("Crear Arquero");

        this.botonCreadorDeArqueroEventHandler = new BotonCreadorDeArqueroEventHandler(this.botonDeArquero, cuartel);

        this.botonDeEspadachin = new Button("Crear Espadachin");

        this.botonCreadorDeEspadachinEventHandler = new BotonCreadorDeEspadachinEventHandler(this.botonDeEspadachin, cuartel);

    }

    public static void mostrarPorPantalla(){

        Stage stage = new Stage();

        stage.setTitle("Cuartel");

        stage.setMinWidth(200);

        Label label = new Label();

        label.setText("Seleccione la unidad a crear");

        botonDeArquero.setOnAction(botonCreadorDeArqueroEventHandler);

        botonDeEspadachin.setOnAction(botonCreadorDeEspadachinEventHandler);

        VBox contenidoDeLaVentana = new VBox(10);

        HBox contenedorDeBotones = new HBox(5);

        HBox contenedorDeTexto = new HBox(5);

        contenedorDeTexto.getChildren().add(label);

        contenedorDeBotones.getChildren().add(botonDeEspadachin);

        contenedorDeBotones.getChildren().add(botonDeArquero);

        contenedorDeBotones.setAlignment(Pos.CENTER);

        contenedorDeTexto.setAlignment(Pos.CENTER_LEFT);

        contenidoDeLaVentana.getChildren().add(contenedorDeTexto);

        contenidoDeLaVentana.getChildren().add(contenedorDeBotones);

        Scene scene = new Scene(contenidoDeLaVentana);

        stage.setScene(scene);

        stage.show();



    }

}
