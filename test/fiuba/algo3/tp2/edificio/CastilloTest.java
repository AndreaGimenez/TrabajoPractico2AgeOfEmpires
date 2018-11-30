package fiuba.algo3.tp2.edificio;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.excepciones.EdificioDestruidoException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.tp2.excepciones.UnidadMuertaException;

public class CastilloTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void test_DadoUnCastilloEnlaPosicionX5Y2_CuandoSePosicionaUnAldeanoEnLaPosicionX5Y2_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Castillo castillo = new Castillo(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano aldeano = new Aldeano(new Posicion(5, 2), mapa);
	}
	
	@Test
	public void test_DadoUnCastilloEnlaPosicionX5Y2_CuandoSePosicionaUnAldeanoEnLaPosicionX8Y2_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Castillo castillo = new Castillo(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano aldeano = new Aldeano(new Posicion(8, 2), mapa);
	}
	
	@Test
	public void test_DadoUnCastilloEnlaPosicionX5Y2_CuandoSePosicionaUnAldeanoEnLaPosicionX8Y5_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Castillo castillo = new Castillo(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano aldeano = new Aldeano(new Posicion(8, 5), mapa);
	}
	
	@Test
	public void test_DadoUnCastilloEnlaPosicionX5Y2_CuandoSePosicionaUnAldeanoEnLaPosicionX5Y5_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Castillo castillo = new Castillo(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
	}
	
	
	
	//ATAQUE
	
	@Test
	public void test_DadoUnAldeanoQueSeEncuentraEnLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca3Veces_ElAldeanoDeberiaEstarMuerto() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException {
		
		Mapa mapa = mock(Mapa.class);
		AtacadorZona castillo = new Castillo(new Posicion(1,1), mapa);
		Atacable aldeano = mock(Aldeano.class);
		when(aldeano.obtenerPosicion()).thenReturn(new Posicion(4,1));
		
		Collection<Posicionable> posicionables = new ArrayList<Posicionable>();
		posicionables.add(aldeano);
		Mockito.when(mapa.obtenerPosicionables(Mockito.any())).thenReturn(posicionables);
		
		castillo.atacar();
		castillo.atacar();
		castillo.atacar();
		
		//Como verifico si el aldeano esta muerto?
	}
	
	@Test
	public void test_DadoUnAldeanoQueSeEncuentraEnLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca4Veces_ElAldeanoDeberiaEstarMuerto() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException {
		
		Mapa mapa = mock(Mapa.class);
		AtacadorZona castillo = new Castillo(new Posicion(1,1), mapa);
		Atacable aldeano = mock(Aldeano.class);
		when(aldeano.obtenerPosicion()).thenReturn(new Posicion(4,1));
		
		Collection<Posicionable> posicionables = new ArrayList<Posicionable>();
		posicionables.add(aldeano);
		Mockito.when(mapa.obtenerPosicionables(Mockito.any())).thenReturn(posicionables);
		
		castillo.atacar();
		castillo.atacar();
		castillo.atacar();
		castillo.atacar();
		
		//Como verifico si el aldeano esta muerto?
	}
	
	@Test
	public void test_DadoUnAldeanoQueSeEncuentraFueraDeLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca3Veces_ElAldeanoDeberiaEstarVivo() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException {
		
		Mapa mapa = mock(Mapa.class);
		AtacadorZona castillo = new Castillo(new Posicion(1,1), mapa);
		
		Collection<Posicionable> posicionables = new ArrayList<Posicionable>();
		when(mapa.obtenerPosicionables(any())).thenReturn(posicionables);
		
		castillo.atacar();
		castillo.atacar();
		castillo.atacar();
		
		//?? Ni siquiera necesito el aldeano, tiene sentido como test unitario?
	}
	
	@Test
	public void test_DadoUnCuartelQueSeEncuentraEnLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca14Veces_ElEdificioDeberiaEstarDestruido() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, EdificioDestruidoException {
		
		Mapa mapa = mock(Mapa.class);
		AtacadorZona castillo = new Castillo(new Posicion(1,1), mapa);
		Atacable cuartel = mock(Cuartel.class);
		when(cuartel.obtenerPosicion()).thenReturn(new Posicion(3,1));
		
		Collection<Posicionable> posicionables = new ArrayList<Posicionable>();
		posicionables.add(cuartel);
		Mockito.when(mapa.obtenerPosicionables(Mockito.any())).thenReturn(posicionables);
		
		for(int i = 1; i <= 14; i++) {
			castillo.atacar();
		}
		
		//Como verifico si el cuartel esta destruido?
	}
	
	@Test
	public void test_DadoUnCuartelYUnAldeanoQueSeEncuentranEnLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca14Veces_ElEdificioDeberiaEstarDestruidoYElAldeanoMuerto() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, EdificioDestruidoException {
		
		Mapa mapa = mock(Mapa.class);
		AtacadorZona castillo = new Castillo(new Posicion(1,1), mapa);
		Atacable cuartel = mock(Cuartel.class);
		when(cuartel.obtenerPosicion()).thenReturn(new Posicion(3,1));
		Atacable aldeano = mock(Aldeano.class);
		when(cuartel.obtenerPosicion()).thenReturn(new Posicion(2,1));
		
		Collection<Posicionable> posicionables = new ArrayList<Posicionable>();
		posicionables.add(cuartel);
		Mockito.when(mapa.obtenerPosicionables(Mockito.any())).thenReturn(posicionables);
		
		for(int i = 1; i <= 14; i++) {
			castillo.atacar();
		}
		
		//Como verifico si el cuartel esta destruido y el aldeano muerto?
	}
}
