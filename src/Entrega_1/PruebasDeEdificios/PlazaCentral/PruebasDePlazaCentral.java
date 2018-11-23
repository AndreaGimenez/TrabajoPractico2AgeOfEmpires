package Entrega_1.PruebasDeEdificios.PlazaCentral;

import fiuba.algo3.tp2.edificio.EdifioNoAptoParaContruirException;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.edificio.UnidadNoSoportadaException;
import fiuba.algo3.tp2.mapa.*;
import fiuba.algo3.tp2.movimiento.MovimientoInvalidoException;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.UnidadConstants;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PruebasDePlazaCentral {

    /*Plaza central crea aldeano*/

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void test_DadaUnaPlazaCentral_CrearUnAldeanoEnLaPosicionElegidaDeberiaSerValido()
            throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {

        Mapa mapa = new Mapa(250, 250);
        PlazaCentral plazaCentral = new PlazaCentral(new Posicion(1, 1), mapa);

        Aldeano aldeano = (Aldeano)plazaCentral.crear(UnidadConstants.TipoUnidad.ALDEANO, new Posicion(3, 1));

    }

    @Test
    public void test_DadaUnaPlazaCentralEnLaPosicionX3Y3_CrearUnAldeanoEnUnaPosicionFueraDelMapaNoDeberiaSerPosible()
            throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {

        Mapa mapa = new Mapa(250, 250);
        PlazaCentral plazaCentral = new PlazaCentral(new Posicion(3, 3), mapa);

        exceptionRule.expect(CeldaInexistenteException.class);
        Aldeano unAldeano = (Aldeano)plazaCentral.crear(UnidadConstants.TipoUnidad.ALDEANO, new Posicion(300, 300));
    }


}
