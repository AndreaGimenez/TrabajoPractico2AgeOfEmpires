package fiuba.algo3.tp2.vista.ventanas;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeArmaDeAsedioEventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaCastillo {


    private static BotonCreadorDeArmaDeAsedioEventHandler botonCreadorDeArmaDeAsedioEventHandler;

    private static Button botonDeArmaAsedio;

    public VentanaCastillo(Castillo castillo) throws TamanioInvalidoException {

        this.botonDeArmaAsedio = new Button("Crear Arma de Asedio");

        this.botonCreadorDeArmaDeAsedioEventHandler = new BotonCreadorDeArmaDeAsedioEventHandler(this.botonDeArmaAsedio, castillo, new Mapa(250, 250));

    }

    public static void mostrarPorPantalla(){

        Stage stage = new Stage();

        stage.setTitle("Cuartel");

        stage.setMinWidth(200);

        Label label = new Label();

        label.setText("Seleccione la unidad a crear");

        botonDeArmaAsedio.setOnAction(botonCreadorDeArmaDeAsedioEventHandler);

        VBox contenidoDeLaVentana = new VBox(10);

        HBox contenedorDeBotones = new HBox(5);

        HBox contenedorDeTexto = new HBox(5);

        contenedorDeTexto.getChildren().add(label);

        contenedorDeBotones.getChildren().add(botonDeArmaAsedio);

        contenedorDeBotones.setAlignment(Pos.CENTER);

        contenedorDeTexto.setAlignment(Pos.CENTER);

        contenidoDeLaVentana.getChildren().add(contenedorDeTexto);

        contenidoDeLaVentana.getChildren().add(contenedorDeBotones);

        Scene scene = new Scene(contenidoDeLaVentana);

        stage.setScene(scene);

        stage.show();

    }
}
