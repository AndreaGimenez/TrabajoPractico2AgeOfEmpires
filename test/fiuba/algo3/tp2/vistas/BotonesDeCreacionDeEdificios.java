package fiuba.algo3.tp2.vistas;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.edificio.PosicionarEdificio;
import fiuba.algo3.tp2.mapa.*;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.vista.JavaFXThreadingRule;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeCuartelEventHandler;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDePlazaCentralEventHandler;
import javafx.scene.control.Button;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BotonesDeCreacionDeEdificios {

    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    @Test
    public void test01BotonCreaUnCuartelEnElMapa() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {

        Mapa mapa = new Mapa(250,250);

        Posicion posicion = new Posicion(5,5);

        Aldeano jose = new Aldeano(posicion, mapa);

        PosicionarEdificio posicionador = new PosicionarEdificio(jose);

        Button botonCreadorDeCuartel = new Button();

        BotonCreadorDeCuartelEventHandler botonCreadorDeCuartelEventHandler = new BotonCreadorDeCuartelEventHandler(botonCreadorDeCuartel, posicionador);

        botonCreadorDeCuartel.setOnAction(botonCreadorDeCuartelEventHandler);

        botonCreadorDeCuartel.fire();

        assertTrue(mapa.obtenerCelda(jose.obtenerPosicion().desplazarHorizontalmente(1)).obtenerPosicionable() instanceof Cuartel);

        assertTrue(mapa.obtenerCelda(jose.obtenerPosicion().desplazarHorizontalmente(2)).obtenerPosicionable() instanceof Cuartel);

        assertTrue(mapa.obtenerCelda(jose.obtenerPosicion().desplazarHorizontalmente(1).desplazarVerticalmente(1)).obtenerPosicionable() instanceof Cuartel);

        assertTrue(mapa.obtenerCelda(jose.obtenerPosicion().desplazarHorizontalmente(2).desplazarVerticalmente(1)).obtenerPosicionable() instanceof Cuartel);

    }

    @Test
    public void test02BotonCreaUnaPlazaCentralEnElMapa() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {

        Mapa mapa = new Mapa(250,250);

        Posicion posicion = new Posicion(5,5);

        Aldeano jose = new Aldeano(posicion, mapa);

        PosicionarEdificio posicionador = new PosicionarEdificio(jose);

        Button botonCreadorDePlazaCentral = new Button();

        BotonCreadorDePlazaCentralEventHandler botonCreadorDePlazaCentralEventHandler = new BotonCreadorDePlazaCentralEventHandler(botonCreadorDePlazaCentral, posicionador);

        botonCreadorDePlazaCentral.setOnAction(botonCreadorDePlazaCentralEventHandler);

        botonCreadorDePlazaCentral.fire();

        assertTrue(mapa.obtenerCelda(jose.obtenerPosicion().desplazarHorizontalmente(1)).obtenerPosicionable() instanceof PlazaCentral);

        assertTrue(mapa.obtenerCelda(jose.obtenerPosicion().desplazarHorizontalmente(2)).obtenerPosicionable() instanceof PlazaCentral);

        assertTrue(mapa.obtenerCelda(jose.obtenerPosicion().desplazarHorizontalmente(1).desplazarVerticalmente(1)).obtenerPosicionable() instanceof PlazaCentral);

        assertTrue(mapa.obtenerCelda(jose.obtenerPosicion().desplazarHorizontalmente(2).desplazarVerticalmente(1)).obtenerPosicionable() instanceof PlazaCentral);

    }

}
