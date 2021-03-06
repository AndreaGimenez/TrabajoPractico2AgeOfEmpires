package fiuba.algo3.tp2.unidad;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.excepciones.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;

public class AtaqueArqueroTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	
	@Test
	public void testCuandoUnAtaqueDeArqueroAtacaUnAldeanoFueraDeSuRangoDeberiaLanzarAtaqueFueraDeRangoException() throws AtaqueFueraDeRangoException, UnidadMuertaException, EdificioDestruidoException, AtaqueInvalidoException {
		
		Atacable aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(5,1));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Atacador arquero = mock(Arquero.class);
		when(arquero.obtenerPosicion()).thenReturn(new Posicion(1,1));
		
		Ataque ataque = new AtaqueArquero();
		
		exceptionRule.expect(AtaqueFueraDeRangoException.class);
		ataque.atacar(arquero, aldeano);
	}
	
	@Test
	public void testCuandoUnAtaqueDeArqueroAtaca5VecesAUnAldeanoEnElUltimoGolpeDeberiaLanzarUnidadMuertaException() 
			throws AtaqueFueraDeRangoException, UnidadMuertaException, TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, EdificioDestruidoException, AtaqueInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Atacable aldeano = new Aldeano(new Posicion(2,1), mapa);
		Atacador arquero = new Arquero(new Posicion(1,1), mapa);
		Ataque ataque = new AtaqueArquero();
		
		ataque.atacar(arquero, aldeano);
		ataque.atacar(arquero, aldeano);
		ataque.atacar(arquero, aldeano);
		ataque.atacar(arquero, aldeano);
		
		exceptionRule.expect(UnidadMuertaException.class);
		ataque.atacar(arquero, aldeano);
	}
	
	@Test
	public void testCuandoUnAtaqueDeArqueroAtaca26VecesAUnCuartelEnElUltimoGolpeDeberiaLanzarEdificioDestruidoException() 
			throws AtaqueFueraDeRangoException, TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, EdificioDestruidoException, UnidadMuertaException, AtaqueInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Atacable cuartel = new Cuartel(new Posicion(1,2), mapa);
		Atacador arquero = new Arquero(new Posicion(3,1), mapa);
		Ataque ataque = new AtaqueArquero();
		
		for(int i = 1; i < 26; i++) {
			ataque.atacar(arquero, cuartel);
		}
		
		exceptionRule.expect(EdificioDestruidoException.class);
		ataque.atacar(arquero, cuartel);
	}
}
