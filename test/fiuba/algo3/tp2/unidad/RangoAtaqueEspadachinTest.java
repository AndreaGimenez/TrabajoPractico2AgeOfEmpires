package fiuba.algo3.tp2.unidad;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import fiuba.algo3.tp2.mapa.Posicion;

public class RangoAtaqueEspadachinTest {
	
	@Test
	public void testDadoUnRangoAtaqueEspadachinQueSeEncuentraEnLaPosicionX1Y1YUnAldeanoEnX3Y1NoDeberiaEstarEnElRango() {
		
		Aldeano aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(3,1));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Espadachin espadachin = mock(Espadachin.class);
		when(espadachin.obtenerPosicion()).thenReturn(new Posicion(1,1));
		
		RangoAtaque rango = new RangoAtaqueEspadachin();
		assertFalse(rango.estaEnRango(espadachin, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueEspadachinQueSeEncuentraEnLaPosicionX1Y1YUnAldeanoEnX2Y1DeberiaEstarEnElRango() {
		
		Aldeano aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(2,1));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Espadachin espadachin = mock(Espadachin.class);
		when(espadachin.obtenerPosicion()).thenReturn(new Posicion(1,1));
		
		RangoAtaque rango = new RangoAtaqueEspadachin();
		assertTrue(rango.estaEnRango(espadachin, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueEspadachinQueSeEncuentraEnLaPosicionX1Y1YUnAldeanoEnX2Y2NoDeberiaEstarEnElRango() {
		
		Aldeano aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(2,2));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Espadachin espadachin = mock(Espadachin.class);
		when(espadachin.obtenerPosicion()).thenReturn(new Posicion(1,1));
		
		RangoAtaque rango = new RangoAtaqueEspadachin();
		assertTrue(rango.estaEnRango(espadachin, aldeano));
	}
}
