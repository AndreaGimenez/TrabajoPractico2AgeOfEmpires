package fiuba.algo3.tp2.turno;

import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.juego.PoblacionMaximaAlcanzadaException;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import fiuba.algo3.tp2.movimiento.DireccionDerecha;
import fiuba.algo3.tp2.excepciones.MovimientoInvalidoException;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.unidad.Aldeano;

public class TurnoTest {
	
	@Rule
	public ExpectedException expectedRule = ExpectedException.none();

	@Test
	public void testDadoUnAldeanoQueYaSeMovioEnUnTurnoAlMoverloNuevamenteDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException{
		
		Mapa mapa = new Mapa(250, 250);
		
		Jugador jugador = new Jugador("Jugador 1");
		Collection<Posicionable> posicionablesJugador = jugador.obtenerPosicionables();
		Aldeano aldeano = new Aldeano(new Posicion(0, 0), mapa);
		
		posicionablesJugador.add(aldeano);
		
		Turno primerTurno = new Turno(jugador);
		
		aldeano.mover(new DireccionDerecha());
		
		expectedRule.expect(MovimientoInvalidoException.class);
		aldeano.mover(new DireccionDerecha());
	}
	
	@Test
	public void testDadoUnAldeanoQueYaSeMovioEnUnTurnoDeberiaPoderMoverseEnUnNuevoTurno() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, PoblacionMaximaAlcanzadaException, OroInsuficienteException{
		
		Mapa mapa = new Mapa(250, 250);
		
		Jugador jugador = new Jugador("Jugador 1");
		Collection<Posicionable> posicionablesJugador = jugador.obtenerPosicionables();
		Aldeano aldeano = new Aldeano(new Posicion(0, 0), mapa);
		
		boolean checkearRecursos = false;
		jugador.agregarUnidad(aldeano, mapa, checkearRecursos);
		
		Turno turno = new Turno(jugador);
		aldeano.mover(new DireccionDerecha());
		
		turno.avanzar();
		aldeano.mover(new DireccionDerecha());
	}
}
