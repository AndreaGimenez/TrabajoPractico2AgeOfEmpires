package fiuba.algo3.tp2.reparacion;
import static org.mockito.Mockito.*;

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
		Cuartel cuartelMock =  mock(Cuartel.class);
		
		when(cuartelMock.obtenerPosicion()).thenReturn(new Posicion(3,1));
		
		exceptionRule.expect(EdificioFueraDeRangoException.class);
		aldeano.repararEdificio(cuartelMock);
	}
	
/*	@Test
	public void testUnAldeanoEnLaPosicionX1Y1NoPuedeRepararUnCuartelQueEsteEnX2Y1PeroQueNoEsteDaniado() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(1,1), mapa);*/
		
		/*Cuartel cuartel = new Cuartel(new Posicion(2,1), mapa);*/
		/*Cuartel cuartelMock =  mock(Cuartel.class);
		
		when(cuartelMock.obtenerPosicion()).thenReturn(new Posicion(2,1));
		
		exceptionRule.expect(EdificioNoAptoParaReparacionException.class);
		
		aldeano.repararEdificio(cuartelMock);
	}*/
	
	@Test
	public void testUnAldeanoEnLaPosicionX1Y1PuedeReparaUnCuartelEnX2Y2QueRecibioDanio() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(1,1), mapa);
		
		Cuartel cuartelMock =  mock(Cuartel.class);
		doNothing().when(cuartelMock).reparar();
		
		when(cuartelMock.obtenerPosicion()).thenReturn(new Posicion(2,2));
		cuartelMock.recibirDanio();
		
		aldeano.repararEdificio(cuartelMock);
	}
	
	@Test
	public void testUnAldeanoEnLaPosicionX1Y1PuedeReparaUnCuartelEnX2Y2QueRecibioDanioSoloUnaVezPorTurno() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(1,1), mapa);
		
		Cuartel cuartelMock =  mock(Cuartel.class);
		doNothing().when(cuartelMock).reparar();
		when(cuartelMock.obtenerPosicion()).thenReturn(new Posicion(2,2));
		
		 doNothing().
		   doThrow(new EdificioNoAptoParaReparacionException())
		   .when(cuartelMock).reparar();
		 
		cuartelMock.recibirDanio();
		aldeano.repararEdificio(cuartelMock);
		exceptionRule.expect(EdificioNoAptoParaReparacionException.class);
		aldeano.repararEdificio(cuartelMock);
	}
	
	
	/*@Test
	public void testUnAldeanoEnLaPosicionX1Y1ReparaUnCuartelCon0PorCientoDeVidaEnCuatroTurno() {
		
	}*/
	
}
