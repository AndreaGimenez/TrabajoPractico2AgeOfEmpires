package fiuba.algo3.tp2.edificio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.RangoAtaque;

public class RangoAtaqueCastilloTest {

	@Test
	public void testDadoUnRangoAtaqueCastilloQueSeEncuentraEnLaPosicionX1Y1YUnAldeanoEnX9Y1NoDeberiaEstarEnElRango() {
		
		Atacable aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(9,1));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		AtacadorZona castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(1,1));
		
		RangoAtaque rango = new RangoAtaqueCastillo();
		assertFalse(rango.estaEnRango(castillo, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueCastilloQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX11Y5DeberiaEstarEnElRango() {
		
		Atacable aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(11,5));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		AtacadorZona castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueCastillo();
		assertTrue(rango.estaEnRango(castillo, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueCastilloQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX10Y5DeberiaEstarEnElRango() {
		
		Atacable aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(10,5));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		AtacadorZona castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueCastillo();
		assertTrue(rango.estaEnRango(castillo, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueCastilloQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX2Y5DeberiaEstarEnElRango() {
		
		Atacable aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(2,5));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		AtacadorZona castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueCastillo();
		assertTrue(rango.estaEnRango(castillo, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueCastilloQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX4Y5DeberiaEstarEnElRango() {
		
		Atacable aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(4,5));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		AtacadorZona castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueCastillo();
		assertTrue(rango.estaEnRango(castillo, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueCastilloQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX5Y11DeberiaEstarEnElRango() {
		
		Atacable aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(5,11));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		AtacadorZona castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueCastillo();
		assertTrue(rango.estaEnRango(castillo, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueCastilloQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX5Y10DeberiaEstarEnElRango() {
		
		Atacable aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(5,10));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		AtacadorZona castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueCastillo();
		assertTrue(rango.estaEnRango(castillo, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueCastilloQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX5Y4DeberiaEstarEnElRango() {
		
		Atacable aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(5,4));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		AtacadorZona castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueCastillo();
		assertTrue(rango.estaEnRango(castillo, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueCastilloQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX5Y2DeberiaEstarEnElRango() {
		
		Atacable aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(5,2));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		AtacadorZona castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueCastillo();
		assertTrue(rango.estaEnRango(castillo, aldeano));
	}
}
