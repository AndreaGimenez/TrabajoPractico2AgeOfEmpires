package Entrega_1.PruebasDeEdificios.Cuartel;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.UnidadNoSoportadaException;
import fiuba.algo3.tp2.mapa.*;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.Espadachin;
import fiuba.algo3.tp2.unidad.UnidadConstants;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PruebasDeCuartel {

    /*Cuartel crea:
    espadachín
    arquero
    */

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void test_DadoUnCuartelEnLaPosicionX1Y1_SeDebePoderCrearUnEspadachinEnLaPosicionIndicada()
            throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException {

        Mapa mapa = new Mapa(250, 250);
        Cuartel cuartel = new Cuartel(new Posicion(1, 1), mapa);

        Espadachin espadachin = (Espadachin)cuartel.crear(UnidadConstants.TipoUnidad.ESPADACHIN, new Posicion(3, 1));


    }

    @Test
    public void test_DadoUnCuartelEnLaPosicionX1Y1_SeDebePoderCrearUnArqueroEnLaPosicionIndicada()
            throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException {

        Mapa mapa = new Mapa(250, 250);
        Cuartel cuartel = new Cuartel(new Posicion(1, 1), mapa);

        Arquero arquero = (Arquero)cuartel.crear(UnidadConstants.TipoUnidad.ARQUERO, new Posicion(3, 1));

    }

    @Test
    public void test_DadoUnCuartel_AlCrearUnEspadachinEnUnaPosicionYaOcupada_DebeLanzarCeldaOcupadaException()
            throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException {

        Mapa mapa = new Mapa(250, 250);
        Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
        Cuartel cuartel = new Cuartel(new Posicion(2,2), mapa);

        exceptionRule.expect(CeldaOcupadaException.class);
        cuartel.crear(UnidadConstants.TipoUnidad.ESPADACHIN, new Posicion(5, 5));
    }

    @Test
    public void test_DadoUnCuartel_AlCrearUnArqueroEnUnaPosicionYaOcupada_DebeLanzarCeldaOcupadaException()
            throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException {

        Mapa mapa = new Mapa(250, 250);
        Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
        Cuartel cuartel = new Cuartel(new Posicion(2,2), mapa);

        exceptionRule.expect(CeldaOcupadaException.class);
        cuartel.crear(UnidadConstants.TipoUnidad.ARQUERO, new Posicion(5, 5));
    }
}
