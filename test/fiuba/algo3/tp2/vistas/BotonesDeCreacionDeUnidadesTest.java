package fiuba.algo3.tp2.vistas;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.mapa.*;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.Espadachin;
import fiuba.algo3.tp2.vista.JavaFXThreadingRule;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeAldeanosEventHandler;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeArmaDeAsedioEventHandler;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeArqueroEventHandler;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeEspadachinEventHandler;
import javafx.scene.control.Button;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BotonesDeCreacionDeUnidadesTest {

    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();


    @Test
    public void test01BotonCrearAldeanoEnElMapa() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {

        Mapa mapa = new Mapa(250,250);

        Posicion posicion = new Posicion(5,5);

        PlazaCentral plazaCentral = new PlazaCentral(posicion, mapa);

        Button botonCreadorDeAldeanos = new Button();

        BotonCreadorDeAldeanosEventHandler botonCreadorDeAldeanosEventHandler = new BotonCreadorDeAldeanosEventHandler(botonCreadorDeAldeanos, plazaCentral);

        botonCreadorDeAldeanos.setOnAction(botonCreadorDeAldeanosEventHandler);

        botonCreadorDeAldeanos.fire();

        assertTrue(mapa.obtenerCelda(plazaCentral.obtenerPosicion().desplazarHorizontalmente(3)).obtenerPosicionable() instanceof Aldeano);

    }

    @Test
    public void test02BotonCrearArmaDeAsedioEnElMapa() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {

        Mapa mapa = new Mapa(250,250);

        Posicion posicion = new Posicion(5,5);

        Castillo castillo = new Castillo(posicion, mapa);

        Button botonCreadorDeArmaDeAsedio = new Button();

        BotonCreadorDeArmaDeAsedioEventHandler botonCreadorDeArmaDeAsedioEventHandler = new BotonCreadorDeArmaDeAsedioEventHandler(botonCreadorDeArmaDeAsedio, castillo);

        botonCreadorDeArmaDeAsedio.setOnAction(botonCreadorDeArmaDeAsedioEventHandler);

        botonCreadorDeArmaDeAsedio.fire();

        assertTrue(mapa.obtenerCelda(castillo.obtenerPosicion().desplazarHorizontalmente(5)).obtenerPosicionable() instanceof ArmaAsedio);

    }

    @Test
    public void test03BotonCrearArqueroEnElMapa() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {

        Mapa mapa = new Mapa(250,250);

        Posicion posicion = new Posicion(5,5);

        Cuartel cuartel = new Cuartel(posicion, mapa);

        Button botonCreadorDeArquero = new Button();

        BotonCreadorDeArqueroEventHandler botonCreadorDeArqueroEventHandler = new BotonCreadorDeArqueroEventHandler(botonCreadorDeArquero, cuartel);

        botonCreadorDeArquero.setOnAction(botonCreadorDeArqueroEventHandler);

        botonCreadorDeArquero.fire();

        assertTrue(mapa.obtenerCelda(cuartel.obtenerPosicion().desplazarHorizontalmente(3)).obtenerPosicionable() instanceof Arquero);

    }

    @Test
    public void test04BotonCrearEspadachinEnElMapa() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {

        Mapa mapa = new Mapa(250,250);

        Posicion posicion = new Posicion(5,5);

        Cuartel cuartel = new Cuartel(posicion, mapa);

        Button botonCreadorDeEspadachin = new Button();

        BotonCreadorDeEspadachinEventHandler botonCreadorDeEspadachinEventHandler = new BotonCreadorDeEspadachinEventHandler(botonCreadorDeEspadachin, cuartel);

        botonCreadorDeEspadachin.setOnAction(botonCreadorDeEspadachinEventHandler);

        botonCreadorDeEspadachin.fire();

        assertTrue(mapa.obtenerCelda(cuartel.obtenerPosicion().desplazarHorizontalmente(3)).obtenerPosicionable() instanceof Espadachin);

    }



}
