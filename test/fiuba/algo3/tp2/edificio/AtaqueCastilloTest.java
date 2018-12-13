package fiuba.algo3.tp2.edificio;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
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
import fiuba.algo3.tp2.excepciones.AtaqueInvalidoException;
import fiuba.algo3.tp2.excepciones.UnidadMuertaException;

public class AtaqueCastilloTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void test_DadoUnAldeanoQueSeEncuentraEnLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca3Veces_ElAldeanoDeberiaEstarMuerto() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException, AtaqueInvalidoException {
		
		Mapa mapa = mock(Mapa.class);
		AtacadorZona castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(1,1));
		Atacable aldeano = mock(Aldeano.class);
		when(aldeano.obtenerPosicion()).thenReturn(new Posicion(4,1));
		AtaqueZona ataque = new AtaqueCastillo(castillo, mapa);
		
		Collection<Posicionable> posicionables = new ArrayList<Posicionable>();
		posicionables.add(aldeano);
		when(mapa.obtenerPosicionables(any())).thenReturn(posicionables);
		
		ataque.atacar();
		ataque.atacar();
		ataque.atacar();
		
		//? Como probar que el aldeano esta muerto?
	}
	
	@Test
	public void test_DadoUnAldeanoQueSeEncuentraEnLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca4Veces_ElAldeanoDeberiaEstarMuerto() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException, AtaqueInvalidoException {
		
		Mapa mapa = mock(Mapa.class);
		AtacadorZona castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(1,1));
		Atacable aldeano = mock(Aldeano.class);
		when(aldeano.obtenerPosicion()).thenReturn(new Posicion(4,1));
		AtaqueZona ataque = new AtaqueCastillo(castillo, mapa);
		
		Collection<Posicionable> posicionables = new ArrayList<Posicionable>();
		posicionables.add(aldeano);
		when(mapa.obtenerPosicionables(Mockito.any())).thenReturn(posicionables);
		
		ataque.atacar();
		ataque.atacar();
		ataque.atacar();
		ataque.atacar();
		
		//? Como verificar que el aldeano esta muerto?
	}
	
	@Test
	public void test_DadoUnAldeanoQueSeEncuentraFueraDeLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca3Veces_ElAldeanoDeberiaEstarVivo() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException, AtaqueInvalidoException {
		
		Mapa mapa = mock(Mapa.class);
		AtacadorZona castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(1,1));
		AtaqueZona ataque = new AtaqueCastillo(castillo, mapa);
		
		Collection<Posicionable> posicionables = new ArrayList<Posicionable>();
		when(mapa.obtenerPosicionables(any())).thenReturn(posicionables);
		
		ataque.atacar();
		ataque.atacar();
		ataque.atacar();
		
		//Como checkear que el aldeano esta vivo?
	}
	
	@Test
	public void test_DadoUnCuartelQueSeEncuentraEnLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca14Veces_ElEdificioDeberiaEstarDestruido() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, EdificioDestruidoException, AtaqueInvalidoException {
		
		Mapa mapa = mock(Mapa.class);
		AtacadorZona castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(1,1));
		AtaqueZona ataque = new AtaqueCastillo(castillo, mapa);
		
		Atacable cuartel = mock(Cuartel.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(3,1));
		
		Collection<Posicionable> posicionables = new ArrayList<Posicionable>();
		posicionables.add(cuartel);
		Mockito.when(mapa.obtenerPosicionables(Mockito.any())).thenReturn(posicionables);
		
		for(int i = 1; i <= 14; i++) {
			ataque.atacar();
		}
		
		//? Como verificar que el cuartel esta destruido?
	}
	
	@Test
	public void test_DadoUnCuartelYUnAldeanoQueSeEncuentranEnLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca14Veces_ElEdificioDeberiaEstarDestruidoYElAldeanoMuerto() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, EdificioDestruidoException, AtaqueInvalidoException {
		
		Mapa mapa = mock(Mapa.class);
		AtacadorZona castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(1,1));
		Atacable cuartel = mock(Cuartel.class);
		when(cuartel.obtenerPosicion()).thenReturn(new Posicion(3,1));
		Atacable aldeano = mock(Aldeano.class);
		when(aldeano.obtenerPosicion()).thenReturn(new Posicion(2,1));
		AtaqueZona ataque = new AtaqueCastillo(castillo, mapa);
		
		Collection<Posicionable> posicionables = new ArrayList<Posicionable>();
		posicionables.add(cuartel);
		posicionables.add(aldeano);
		when(mapa.obtenerPosicionables(Mockito.any())).thenReturn(posicionables);
		
		for(int i = 1; i <= 14; i++) {
			ataque.atacar();
		}
		
		//? Como verificar que el cuartel esta destruido y el aldeano muerto?
		
		/* ?
		Ataque ataqueEspadachin = mock(AtaqueEspadachin.class);
		when(ataqueEspadachin.obtenerDanioEdificio()).thenReturn(25);
		exceptionRule.expect(EdificioDestruidoException.class);
		cuartel.recibirDanio(ataqueEspadachin);
		
		exceptionRule.expect(UnidadMuertaException.class);
		when(ataqueEspadachin.obtenerDanioEdificio()).thenReturn(15);
		aldeano.recibirDanio(ataqueEspadachin);
		*/
	}
}
