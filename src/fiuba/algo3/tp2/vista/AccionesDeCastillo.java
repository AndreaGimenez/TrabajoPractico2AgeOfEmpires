package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.mapa.*;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeArmaDeAsedioEventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AccionesDeCastillo {

    Castillo castillo;

    Mapa mapa;

    public AccionesDeCastillo() throws CeldaInexistenteException, TamanioInvalidoException, CeldaOcupadaException {

        this.castillo = new Castillo(new Posicion(5, 5), new Mapa(250, 250));

        this.mapa = new Mapa(250,250);

    }

    public void mostrarAcciones(ContenedorPartida contenedor) {

        Label labelNombreUnidad = new Label();
        labelNombreUnidad.setText("Menu de Castillo");

        Button botonCreadorDeArmaDeAsedio = new Button();
        botonCreadorDeArmaDeAsedio.setText("Crear Arma de Asedio");

        BotonCreadorDeArmaDeAsedioEventHandler botonCreadorDeArmaDeAsedioEventHandler = new BotonCreadorDeArmaDeAsedioEventHandler(botonCreadorDeArmaDeAsedio, this.castillo, this.mapa);
        botonCreadorDeArmaDeAsedio.setOnAction(botonCreadorDeArmaDeAsedioEventHandler);

        VBox contenedorVertical = new VBox(labelNombreUnidad, botonCreadorDeArmaDeAsedio);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));
        contenedorVertical.setStyle("-fx-background-color: brown;");
        contenedorVertical.setPrefWidth(200);

        contenedor.setLeft(contenedorVertical);

    }

}
