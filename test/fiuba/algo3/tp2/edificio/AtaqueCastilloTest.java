package fiuba.algo3.tp2.edificio;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.AtaqueFueraDeRangoException;
import fiuba.algo3.tp2.unidad.Unidad;
import fiuba.algo3.tp2.unidad.UnidadMuertaException;

public class AtaqueCastilloTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void test_DadoUnAldeanoQueSeEncuentraEnLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca3Veces_ElAldeanoDeberiaEstarMuerto() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException {
		
		Mapa mapa = Mockito.mock(Mapa.class);
		Castillo castillo = new Castillo(new Posicion(1,1), mapa);
		Unidad aldeano = new Aldeano(new Posicion(4,1), mapa);
		AtaqueZona ataque = new AtaqueCastillo(castillo, mapa);
		
		Collection<Posicionable> posicionables = new ArrayList<Posicionable>();
		posicionables.add(aldeano);
		Mockito.when(mapa.obtenerPosicionables(Mockito.any())).thenReturn(posicionables);
		
		ataque.atacar();
		ataque.atacar();
		ataque.atacar();
		
		exceptionRule.expect(UnidadMuertaException.class);
		aldeano.recibirDanio(1);
	}
	
	@Test
	public void test_DadoUnAldeanoQueSeEncuentraEnLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca4Veces_ElAldeanoDeberiaEstarMuerto() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException {
		
		Mapa mapa = Mockito.mock(Mapa.class);
		Castillo castillo = new Castillo(new Posicion(1,1), mapa);
		Unidad aldeano = new Aldeano(new Posicion(4,1), mapa);
		AtaqueZona ataque = new AtaqueCastillo(castillo, mapa);
		
		Collection<Posicionable> posicionables = new ArrayList<Posicionable>();
		posicionables.add(aldeano);
		Mockito.when(mapa.obtenerPosicionables(Mockito.any())).thenReturn(posicionables);
		
		ataque.atacar();
		ataque.atacar();
		ataque.atacar();
		ataque.atacar();
		
		exceptionRule.expect(UnidadMuertaException.class);
		aldeano.recibirDanio(1);
	}
	
	@Test
	public void test_DadoUnAldeanoQueSeEncuentraFueraDeLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca3Veces_ElAldeanoDeberiaEstarVivo() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException {
		
		Mapa mapa = Mockito.mock(Mapa.class);
		Castillo castillo = new Castillo(new Posicion(1,1), mapa);
		Unidad aldeano = new Aldeano(new Posicion(5,1), mapa);
		AtaqueZona ataque = new AtaqueCastillo(castillo, mapa);
		
		Collection<Posicionable> posicionables = new ArrayList<Posicionable>();
		Mockito.when(mapa.obtenerPosicionables(Mockito.any())).thenReturn(posicionables);
		
		ataque.atacar();
		ataque.atacar();
		ataque.atacar();
		
		aldeano.recibirDanio(50);
		exceptionRule.expect(UnidadMuertaException.class);
		aldeano.recibirDanio(1);
	}
	
	@Test
	public void test_DadoUnCuartelQueSeEncuentraEnLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca14Veces_ElEdificioDeberiaEstarDestruido() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, EdificioDestruidoException {
		
		Mapa mapa = Mockito.mock(Mapa.class);
		Castillo castillo = new Castillo(new Posicion(1,1), mapa);
		Edificio cuartel = new Cuartel(new Posicion(4,1), mapa);
		AtaqueZona ataque = new AtaqueCastillo(castillo, mapa);
		
		Collection<Posicionable> posicionables = new ArrayList<Posicionable>();
		posicionables.add(cuartel);
		Mockito.when(mapa.obtenerPosicionables(Mockito.any())).thenReturn(posicionables);
		
		for(int i = 1; i <= 14; i++) {
			ataque.atacar();
		}
		
		exceptionRule.expect(EdificioDestruidoException.class);
		cuartel.recibirDanio(1);
	}
	
	@Test
	public void test_DadoUnCuartelYUnAldeanoQueSeEncuentranEnLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca14Veces_ElEdificioDeberiaEstarDestruidoYElAldeanoMuerto() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, EdificioDestruidoException {
		
		Mapa mapa = Mockito.mock(Mapa.class);
		Castillo castillo = new Castillo(new Posicion(1,1), mapa);
		Edificio cuartel = new Cuartel(new Posicion(4,1), mapa);
		Unidad aldeano = new Aldeano(new Posicion(4,0), mapa);
		AtaqueZona ataque = new AtaqueCastillo(castillo, mapa);
		
		Collection<Posicionable> posicionables = new ArrayList<Posicionable>();
		posicionables.add(cuartel);
		posicionables.add(aldeano);
		Mockito.when(mapa.obtenerPosicionables(Mockito.any())).thenReturn(posicionables);
		
		for(int i = 1; i <= 14; i++) {
			ataque.atacar();
		}
		
		exceptionRule.expect(EdificioDestruidoException.class);
		cuartel.recibirDanio(1);
		
		exceptionRule.expect(EdificioDestruidoException.class);
		aldeano.recibirDanio(1);
	}
}
