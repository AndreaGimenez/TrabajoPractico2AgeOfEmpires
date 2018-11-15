package fiuba.algo3.tp2.reparacion;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.reparacion.EdificioFueraDeRangoException;
import fiuba.algo3.tp2.unidad.Aldeano;

public class ReparacionTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void testUnAldeanoEnLaPosicionX1Y1NoPuedeRepararUnCuartelQueEsteEnX3Y1() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(1,1), mapa);
		
		Cuartel cuartel = new Cuartel(new Posicion(3,1), mapa);
		
		exceptionRule.expect(EdificioFueraDeRangoException.class);
		aldeano.repararEdificio(cuartel);
	}
	
	@Test
	public void testUnAldeanoEnLaPosicionX1Y1NoPuedeRepararUnCuartelQueEsteEnX2Y1PeroQueNoEsteDañado() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(1,1), mapa);
		
		Cuartel cuartel = new Cuartel(new Posicion(2,1), mapa);
		
		exceptionRule.expect(EdificioNoAptoParaReparacionException.class);
		aldeano.repararEdificio(cuartel);
	}
	
	/*@Test
	public void testUnAldeanoEnLaPosicionX1Y1ReparaUnCuartelCon75PorCientoDeVidaEnUnTurno() {
		
	}
	
	@Test
	public void testUnAldeanoEnLaPosicionX1Y1ReparaUnCuartelCon0PorCientoDeVidaEnCuatroTurno() {
		
	}*/
	
}
