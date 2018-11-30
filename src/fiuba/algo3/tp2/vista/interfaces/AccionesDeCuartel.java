package fiuba.algo3.tp2.vista.interfaces;

import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.mapa.*;
import fiuba.algo3.tp2.vista.ContenedorPartida;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeArqueroEventHandler;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeEspadachinEventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AccionesDeCuartel {

    Cuartel cuartel;

    public AccionesDeCuartel() throws CeldaInexistenteException, TamanioInvalidoException, CeldaOcupadaException {

        this.cuartel = new Cuartel(new Posicion(5,5), new Mapa(250,250));

    }

    public void mostrarAcciones(ContenedorPartida contenedor) throws TamanioInvalidoException{

        Label labelNombreUnidad = new Label();
        labelNombreUnidad.setText("Menu de Cuartel");

        Button botonCrearArquero = new Button();
        botonCrearArquero.setText("Crear Arquero");

        Button botonCrearEspadachin = new Button();
        botonCrearEspadachin.setText("Crear Espadachin");

        BotonCreadorDeEspadachinEventHandler botonCreadorDeEspadachinEventHandler = new BotonCreadorDeEspadachinEventHandler(botonCrearArquero, this.cuartel, new Mapa(250, 250));
        botonCrearArquero.setOnAction(botonCreadorDeEspadachinEventHandler);

        BotonCreadorDeArqueroEventHandler botonCreadorDeArqueroEventHandler = new BotonCreadorDeArqueroEventHandler(botonCrearArquero, this.cuartel, new Mapa(250, 250));
        botonCrearEspadachin.setOnAction(botonCreadorDeArqueroEventHandler);

        VBox contenedorVertical = new VBox(labelNombreUnidad, botonCrearArquero, botonCrearEspadachin);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));
        contenedorVertical.setStyle("-fx-background-color: brown;");
        contenedorVertical.setPrefWidth(200);

        contenedor.setLeft(contenedorVertical);

    }

}
