package fiuba.algo3.tp2.unidad;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Ataque.Atacador;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.EdificioDestruidoException;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;

public class AtaqueArmaAsedioTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void testCuandoUnAtaqueDeArmaAsedioAtacaUnAldeanoDeberiaLanzarUnidadNoAtacableException() 
			throws AtaqueFueraDeRangoException, UnidadMuertaException {
		
		Unidad aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasCuartel = new ArrayList<Posicion>();
		posicionesOcupadasCuartel.add(new Posicion(6,1));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasCuartel);
		
		Atacador armaAsedio = mock(ArmaAsedio.class);
		when(armaAsedio.obtenerPosicion()).thenReturn(new Posicion(1,1));
		
		Ataque ataque = new AtaqueArmaAsedio();
		
		exceptionRule.expect(UnidadNoAtacableException.class);
		ataque.atacar(armaAsedio, aldeano);
	}
	
	@Test
	public void testCuandoUnAtaqueDeArmaAsedioAtacaUnCuartelFueraDeSuRangoDeberiaLanzarAtaqueFueraDeRangoException() 
			throws AtaqueFueraDeRangoException, EdificioDestruidoException {
		
		Edificio cuartel = mock(Cuartel.class);
		
		Collection<Posicion> posicionesOcupadasCuartel = new ArrayList<Posicion>();
		posicionesOcupadasCuartel.add(new Posicion(7,1));
		
		when(cuartel.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasCuartel);
		
		Atacador armaAsedio = mock(ArmaAsedio.class);
		when(armaAsedio.obtenerPosicion()).thenReturn(new Posicion(1,1));
		
		Ataque ataque = new AtaqueArmaAsedio();
		
		exceptionRule.expect(AtaqueFueraDeRangoException.class);
		ataque.atacar(armaAsedio, cuartel);
	}
	
	@Test
	public void testCuandoUnAtaqueDeArmaAsedioAtaca5VecesUnCuartelEnElUltimoGolpeDeberiaLanzarEdificioDestruidoException() 
			throws AtaqueFueraDeRangoException, TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, EdificioDestruidoException {
		
		Mapa mapa = new Mapa(250,250);
		Edificio cuartel = new Cuartel(new Posicion(2,1), mapa);
		Atacador armaAsedio = new ArmaAsedio(new Posicion(1,1), mapa);
		Ataque ataque = new AtaqueArmaAsedio();
		
		ataque.atacar(armaAsedio, cuartel);
		ataque.atacar(armaAsedio, cuartel);
		ataque.atacar(armaAsedio, cuartel);
		ataque.atacar(armaAsedio, cuartel);
		
		exceptionRule.expect(EdificioDestruidoException.class);
		ataque.atacar(armaAsedio, cuartel);
	}
	
}
