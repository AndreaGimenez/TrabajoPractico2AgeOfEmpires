package fiuba.algo3.tp2.edificio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import Ataque.Atacador;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.RangoAtaque;
import fiuba.algo3.tp2.unidad.RangoAtaqueArquero;

public class RangoAtaqueCastilloTest {

	@Test
	public void testDadoUnRangoAtaqueCastilloQueSeEncuentraEnLaPosicionX1Y1YUnAldeanoEnX5Y1NoDeberiaEstarEnElRango() {
		
		Aldeano aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(5,1));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Castillo castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(1,1));
		
		RangoAtaque rango = new RangoAtaqueCastillo();
		assertFalse(rango.estaEnRango(castillo, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueCastilloQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX8Y5DeberiaEstarEnElRango() {
		
		Aldeano aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(8,5));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Castillo castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueCastillo();
		assertTrue(rango.estaEnRango(castillo, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueCastilloQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX6Y5DeberiaEstarEnElRango() {
		
		Aldeano aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(6,5));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Castillo castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueCastillo();
		assertTrue(rango.estaEnRango(castillo, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueCastilloQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX2Y5DeberiaEstarEnElRango() {
		
		Aldeano aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(2,5));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Castillo castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueCastillo();
		assertTrue(rango.estaEnRango(castillo, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueCastilloQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX4Y5DeberiaEstarEnElRango() {
		
		Aldeano aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(4,5));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Castillo castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueCastillo();
		assertTrue(rango.estaEnRango(castillo, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueCastilloQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX5Y8DeberiaEstarEnElRango() {
		
		Aldeano aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(5,8));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Castillo castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueCastillo();
		assertTrue(rango.estaEnRango(castillo, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueCastilloQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX5Y6DeberiaEstarEnElRango() {
		
		Aldeano aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(5,6));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Castillo castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueCastillo();
		assertTrue(rango.estaEnRango(castillo, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueCastilloQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX5Y4DeberiaEstarEnElRango() {
		
		Aldeano aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(5,4));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Castillo castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueCastillo();
		assertTrue(rango.estaEnRango(castillo, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueCastilloQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX5Y2DeberiaEstarEnElRango() {
		
		Aldeano aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(5,2));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Castillo castillo = mock(Castillo.class);
		when(castillo.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueCastillo();
		assertTrue(rango.estaEnRango(castillo, aldeano));
	}
}
