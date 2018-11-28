/*package fiuba.algo3.tp2.edificio.reFactor;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.construccion.EdificioNoSoportadoException;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.EdificioConstants;
import fiuba.algo3.tp2.edificio.EdificioEnConstruccionException;
import fiuba.algo3.tp2.edificio.EdifioNoAptoParaContruirException;
import fiuba.algo3.tp2.edificio.GestionarConstruccion;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.edificio.UnidadNoSoportadaException;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.mapa.Celda;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.reparacion.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.turno.Turno;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.UnidadConstants;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

public class PlazaCentralTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
    public void test_CrearUnaPlazaCentralYPedirleCrearUnAldeanoHabiendoPasadoTresTurnosDeberiaSerPosible()
            throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException, TamanioInvalidoException, EdificioEnConstruccionException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException, EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException, OroInsuficienteException {

        Mapa mapa = new Mapa(250, 250);
        PlazaCentral plazaCentral = new PlazaCentral(new Posicion(5, 5), mapa);
        GestionarConstruccion gestorPlaza = new GestionarConstruccion(plazaCentral);
         
        Jugador jugador = new Jugador("Jugador 1");
        Collection<Posicionable> posicionables = jugador.obtenerPosicionables();
        jugador.agregarEdificio(gestorPlaza, false);
        Turno turno = new Turno(jugador);
        turno.avanzar();
        turno.avanzar();
        turno.avanzar();

        Aldeano aldeano = (Aldeano) gestorPlaza.crearAldeano(Aldeano.class, new Posicion(10, 10));
        
        assertTrue(mapa.obtenerCelda(new Posicion(10, 10)).estaOcupada());

    }

}
*/