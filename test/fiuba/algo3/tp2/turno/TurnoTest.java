package fiuba.algo3.tp2.turno;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.movimiento.DireccionDerecha;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.MovimientoInvalidoException;

public class TurnoTest {
	
	@Rule
	public ExpectedException expectedRule = ExpectedException.none();

	@Test
	public void testDadoUnAldeanoQueYaSeMovioEnUnTurnoAlMoverloNuevamenteDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException{
		
		Mapa mapa = new Mapa(250, 250);
		
		Collection<Posicionable> posicionablesJugador = new ArrayList<Posicionable>();
		Aldeano aldeano = new Aldeano(new Posicion(0, 0), mapa);
		
		posicionablesJugador.add(aldeano);
		
		Turno primerTurno = new Turno(posicionablesJugador);
		primerTurno.iniciar();
		
		aldeano.mover(new DireccionDerecha());
		
		expectedRule.expect(MovimientoInvalidoException.class);
		aldeano.mover(new DireccionDerecha());
	}
	
	@Test
	public void testDadoUnAldeanoQueYaSeMovioEnUnTurnoDeberiaPoderMoverseEnUnNuevoTurno() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException{
		
		Mapa mapa = new Mapa(250, 250);
		
		Collection<Posicionable> posicionablesJugador = new ArrayList<Posicionable>();
		Aldeano aldeano = new Aldeano(new Posicion(0, 0), mapa);
		
		posicionablesJugador.add(aldeano);
		
		Turno primerTurno = new Turno(posicionablesJugador);
		primerTurno.iniciar();
		aldeano.mover(new DireccionDerecha());
		
		Turno segundoTurno = new Turno(posicionablesJugador);
		segundoTurno.iniciar();
		aldeano.mover(new DireccionDerecha());
	}
}
