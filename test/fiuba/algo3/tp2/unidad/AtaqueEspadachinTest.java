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
import fiuba.algo3.tp2.edificio.EdificioDestruidoException;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;

public class AtaqueEspadachinTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	
	@Test
	public void testCuandoUnAtaqueDeEspadachinAtacaUnAldeanoFueraDeSuRangoDeberiaLanzarAtaqueFueraDeRangoException() throws AtaqueFueraDeRangoException, UnidadMuertaException {
		
		Atacable aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(3,1));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Atacador espadachin = mock(Espadachin.class);
		when(espadachin.obtenerPosicion()).thenReturn(new Posicion(1,1));
		
		Ataque ataque = new AtaqueEspadachin();
		
		exceptionRule.expect(AtaqueFueraDeRangoException.class);
		ataque.atacar(espadachin, aldeano);
	}
	
	@Test
	public void testCuandoUnAtaqueDeEspadachinAtaca3VecesAUnAldeanoEnElUltimoGolpeDeberiaLanzarUnidadMuertaException() 
			throws AtaqueFueraDeRangoException, UnidadMuertaException, TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250,250);
		Atacable aldeano = new Aldeano(new Posicion(2,1), mapa);
		Atacador espadachin = new Espadachin(new Posicion(1,1), mapa);
		Ataque ataque = new AtaqueEspadachin();
		
		ataque.atacar(espadachin, aldeano);
		ataque.atacar(espadachin, aldeano);
		
		exceptionRule.expect(UnidadMuertaException.class);
		ataque.atacar(espadachin, aldeano);
	}
	
	@Test
	public void testCuandoUnAtaqueDeEspadachinAtaca18VecesAUnCuartelEnElUltimoGolpeDeberiaLanzarEdificioDestruidoException() 
			throws AtaqueFueraDeRangoException, TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, EdificioDestruidoException {
		
		Mapa mapa = new Mapa(250,250);
		Atacable cuartel = new Cuartel(new Posicion(1,2), mapa);
		Atacador espadachin = new Espadachin(new Posicion(3,1), mapa);
		Ataque ataque = new AtaqueEspadachin();
		
		for(int i = 0; i < 17; i++) {
			ataque.atacar(espadachin, cuartel);
		}
		
		exceptionRule.expect(EdificioDestruidoException.class);
		ataque.atacar(espadachin, cuartel);
	}
}
