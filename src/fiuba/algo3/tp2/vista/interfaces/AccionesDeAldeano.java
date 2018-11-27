package fiuba.algo3.tp2.vista.interfaces;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.PosicionarEdificio;
import fiuba.algo3.tp2.mapa.*;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeCuartelEventHandler;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDePlazaCentralEventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AccionesDeAldeano {

    /*Para hacer la prueba voy a hacer que este objeto tenga un posicionador, pero deberia
    * ser pasado por referencia en el constructor*/


    PosicionarEdificio posicionador;

    public AccionesDeAldeano() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {

        this.posicionador = new PosicionarEdificio(new Aldeano(new Posicion(5,5), new Mapa(250,250)));

    }

    public void mostrarAcciones(ContenedorPrincipal contenedor){

        Label labelNombreUnidad = new Label();
        labelNombreUnidad.setText("Menu de Aldeano");

        Button botonConstruirCuartel = new Button();
        botonConstruirCuartel.setText("Construir Cuartel");

        Button botonConstruirPlazaCentral = new Button();
        botonConstruirPlazaCentral.setText("Construir Plaza Central");

        BotonCreadorDeCuartelEventHandler botonCreadorDeCuartelEventHandler = new BotonCreadorDeCuartelEventHandler(botonConstruirCuartel, this.posicionador);
        botonConstruirCuartel.setOnAction(botonCreadorDeCuartelEventHandler);

        BotonCreadorDePlazaCentralEventHandler botonCreadorDePlazaCentralEventHandler = new BotonCreadorDePlazaCentralEventHandler(botonConstruirPlazaCentral, this.posicionador);
        botonConstruirPlazaCentral.setOnAction(botonCreadorDePlazaCentralEventHandler);

        VBox contenedorVertical = new VBox(labelNombreUnidad, botonConstruirCuartel, botonConstruirPlazaCentral);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));
        contenedorVertical.setStyle("-fx-background-color: brown;");
        contenedorVertical.setPrefWidth(200);

        contenedor.setLeft(contenedorVertical);

    }

}
