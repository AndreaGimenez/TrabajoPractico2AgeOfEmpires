package Entrega_1.PruebasDeEdificios.Castillo;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.EdifioNoAptoParaContruirException;
import fiuba.algo3.tp2.edificio.UnidadNoSoportadaException;
import fiuba.algo3.tp2.mapa.*;
import fiuba.algo3.tp2.movimiento.MovimientoInvalidoException;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.UnidadConstants;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PruebasDeCastillo {

    /*castillo crea arma de asedio*/


    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void test_DadoUnCastilloEnLaPosicionX1Y1_DebePoderCrearUnArmaDeAsedioEnLaPosicionSolicitada()
            throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {

        Mapa mapa = new Mapa(250, 250);
        Castillo castillo = new Castillo(new Posicion(1, 1), mapa);

        ArmaAsedio armaAsedio = (ArmaAsedio)castillo.crear(UnidadConstants.TipoUnidad.ARMA_ASEDIO, new Posicion(5, 5));

    }

    @Test
    public void test_DadoUnCastilloEnLaPosicionX1Y1_AlCrearUnArmaDeAsedioEnLaPosicionX3Y3_DebeLanzarCeldaOcupadaException()
            throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {

        Mapa mapa = new Mapa(250, 250);
        Castillo castillo = new Castillo(new Posicion(1, 1), mapa);

        exceptionRule.expect(CeldaOcupadaException.class);
        ArmaAsedio armaAsedio = (ArmaAsedio)castillo.crear(UnidadConstants.TipoUnidad.ARMA_ASEDIO, new Posicion(3, 3));

    }

}
