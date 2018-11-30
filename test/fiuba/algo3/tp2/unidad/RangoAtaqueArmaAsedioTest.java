package fiuba.algo3.tp2.unidad;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.mapa.Posicion;

public class RangoAtaqueArmaAsedioTest {

	@Test
	public void testDadoUnRangoAtaqueArmaAsedioQueSeEncuentraEnLaPosicionX5Y5YUnCuartelEnX11Y5NoDeberiaEstarEnElRango() {
		
		Atacable cuartel = mock(Cuartel.class);
		
		Collection<Posicion> posicionesOcupadasCuartel = new ArrayList<Posicion>();
		posicionesOcupadasCuartel.add(new Posicion(11,5));
		
		when(cuartel.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasCuartel);
		
		Atacador armaAsedio = mock(ArmaAsedio.class);
		when(armaAsedio.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueArmaAsedio();
		assertFalse(rango.estaEnRango(armaAsedio, cuartel));
	}
	
	@Test
	public void testDadoUnRangoAtaqueArmaAsedioQueSeEncuentraEnLaPosicionX5Y5YUnCuartelEnX10Y5DeberiaEstarEnElRango() {
		
		Atacable cuartel = mock(Cuartel.class);
		
		Collection<Posicion> posicionesOcupadasCuartel = new ArrayList<Posicion>();
		posicionesOcupadasCuartel.add(new Posicion(10,5));
		
		when(cuartel.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasCuartel);
		
		Atacador armaAsedio = mock(ArmaAsedio.class);
		when(armaAsedio.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueArmaAsedio();
		assertTrue(rango.estaEnRango(armaAsedio, cuartel));
	}
	
	@Test
	public void testDadoUnRangoAtaqueArmaAsedioQueSeEncuentraEnLaPosicionX5Y5YUnCuartelEnX6Y5DeberiaEstarEnElRango() {
		
		Atacable cuartel = mock(Cuartel.class);
		
		Collection<Posicion> posicionesOcupadasCuartel = new ArrayList<Posicion>();
		posicionesOcupadasCuartel.add(new Posicion(6,5));
		
		when(cuartel.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasCuartel);
		
		Atacador armaAsedio = mock(ArmaAsedio.class);
		when(armaAsedio.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueArmaAsedio();
		assertTrue(rango.estaEnRango(armaAsedio, cuartel));
	}
	
	@Test
	public void testDadoUnRangoAtaqueArmaAsedioQueSeEncuentraEnLaPosicionX6Y6YUnCuartelEnX0Y6NoDeberiaEstarEnElRango() {
		
		Atacable cuartel = mock(Cuartel.class);
		
		Collection<Posicion> posicionesOcupadasCuartel = new ArrayList<Posicion>();
		posicionesOcupadasCuartel.add(new Posicion(0,5));
		
		when(cuartel.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasCuartel);
		
		Atacador armaAsedio = mock(ArmaAsedio.class);
		when(armaAsedio.obtenerPosicion()).thenReturn(new Posicion(6,6));
		
		RangoAtaque rango = new RangoAtaqueArmaAsedio();
		assertFalse(rango.estaEnRango(armaAsedio, cuartel));
	}
	
	@Test
	public void testDadoUnRangoAtaqueArmaAsedioQueSeEncuentraEnLaPosicionX6Y6YUnCuartelEnX10Y6DeberiaEstarEnElRango() {
		
		Atacable cuartel = mock(Cuartel.class);
		
		Collection<Posicion> posicionesOcupadasCuartel = new ArrayList<Posicion>();
		posicionesOcupadasCuartel.add(new Posicion(1,5));
		
		when(cuartel.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasCuartel);
		
		Atacador armaAsedio = mock(ArmaAsedio.class);
		when(armaAsedio.obtenerPosicion()).thenReturn(new Posicion(6,6));
		
		RangoAtaque rango = new RangoAtaqueArmaAsedio();
		assertTrue(rango.estaEnRango(armaAsedio, cuartel));
	}
	
	@Test
	public void testDadoUnRangoAtaqueArmaAsedioQueSeEncuentraEnLaPosicionX6Y6YUnCuartelEnX6Y6DeberiaEstarEnElRango() {
		
		Atacable cuartel = mock(Cuartel.class);
		
		Collection<Posicion> posicionesOcupadasCuartel = new ArrayList<Posicion>();
		posicionesOcupadasCuartel.add(new Posicion(5,6));
		
		when(cuartel.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasCuartel);
		
		Atacador armaAsedio = mock(ArmaAsedio.class);
		when(armaAsedio.obtenerPosicion()).thenReturn(new Posicion(6,6));
		
		RangoAtaque rango = new RangoAtaqueArmaAsedio();
		assertTrue(rango.estaEnRango(armaAsedio, cuartel));
	}
	
	@Test
	public void testDadoUnRangoAtaqueArmaAsedioQueSeEncuentraEnLaPosicionX6Y6YUnCuartelEnX6Y12NoDeberiaEstarEnElRango() {
		
		Atacable cuartel = mock(Cuartel.class);
		
		Collection<Posicion> posicionesOcupadasCuartel = new ArrayList<Posicion>();
		posicionesOcupadasCuartel.add(new Posicion(6,12));
		
		when(cuartel.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasCuartel);
		
		Atacador armaAsedio = mock(ArmaAsedio.class);
		when(armaAsedio.obtenerPosicion()).thenReturn(new Posicion(6,6));
		
		RangoAtaque rango = new RangoAtaqueArmaAsedio();
		assertFalse(rango.estaEnRango(armaAsedio, cuartel));
	}
	
	@Test
	public void testDadoUnRangoAtaqueArmaAsedioQueSeEncuentraEnLaPosicionX6Y6YUnCuartelEnX6Y11DeberiaEstarEnElRango() {
		
		Atacable cuartel = mock(Cuartel.class);
		
		Collection<Posicion> posicionesOcupadasCuartel = new ArrayList<Posicion>();
		posicionesOcupadasCuartel.add(new Posicion(6,11));
		
		when(cuartel.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasCuartel);
		
		Atacador armaAsedio = mock(ArmaAsedio.class);
		when(armaAsedio.obtenerPosicion()).thenReturn(new Posicion(6,6));
		
		RangoAtaque rango = new RangoAtaqueArmaAsedio();
		assertTrue(rango.estaEnRango(armaAsedio, cuartel));
	}
	
	@Test
	public void testDadoUnRangoAtaqueArmaAsedioQueSeEncuentraEnLaPosicionX6Y6YUnCuartelEnX6Y7DeberiaEstarEnElRango() {
		
		Atacable cuartel = mock(Cuartel.class);
		
		Collection<Posicion> posicionesOcupadasCuartel = new ArrayList<Posicion>();
		posicionesOcupadasCuartel.add(new Posicion(6,7));
		
		when(cuartel.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasCuartel);
		
		Atacador armaAsedio = mock(ArmaAsedio.class);
		when(armaAsedio.obtenerPosicion()).thenReturn(new Posicion(6,6));
		
		RangoAtaque rango = new RangoAtaqueArmaAsedio();
		assertTrue(rango.estaEnRango(armaAsedio, cuartel));
	}
	
	@Test
	public void testDadoUnRangoAtaqueArmaAsedioQueSeEncuentraEnLaPosicionX6Y6YUnCuartelEnX6Y0NoDeberiaEstarEnElRango() {
		
		Atacable cuartel = mock(Cuartel.class);
		
		Collection<Posicion> posicionesOcupadasCuartel = new ArrayList<Posicion>();
		posicionesOcupadasCuartel.add(new Posicion(6,0));
		
		when(cuartel.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasCuartel);
		
		Atacador armaAsedio = mock(ArmaAsedio.class);
		when(armaAsedio.obtenerPosicion()).thenReturn(new Posicion(6,6));
		
		RangoAtaque rango = new RangoAtaqueArmaAsedio();
		assertFalse(rango.estaEnRango(armaAsedio, cuartel));
	}
	
	@Test
	public void testDadoUnRangoAtaqueArmaAsedioQueSeEncuentraEnLaPosicionX6Y6YUnCuartelEnX6Y1DeberiaEstarEnElRango() {
		
		Atacable cuartel = mock(Cuartel.class);
		
		Collection<Posicion> posicionesOcupadasCuartel = new ArrayList<Posicion>();
		posicionesOcupadasCuartel.add(new Posicion(6,1));
		
		when(cuartel.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasCuartel);
		
		Atacador armaAsedio = mock(ArmaAsedio.class);
		when(armaAsedio.obtenerPosicion()).thenReturn(new Posicion(6,6));
		
		RangoAtaque rango = new RangoAtaqueArmaAsedio();
		assertTrue(rango.estaEnRango(armaAsedio, cuartel));
	}
	
	@Test
	public void testDadoUnRangoAtaqueArmaAsedioQueSeEncuentraEnLaPosicionX6Y6YUnCuartelEnX6Y5DeberiaEstarEnElRango() {
		
		Atacable cuartel = mock(Cuartel.class);
		
		Collection<Posicion> posicionesOcupadasCuartel = new ArrayList<Posicion>();
		posicionesOcupadasCuartel.add(new Posicion(6,5));
		
		when(cuartel.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasCuartel);
		
		Atacador armaAsedio = mock(ArmaAsedio.class);
		when(armaAsedio.obtenerPosicion()).thenReturn(new Posicion(6,6));
		
		RangoAtaque rango = new RangoAtaqueArmaAsedio();
		assertTrue(rango.estaEnRango(armaAsedio, cuartel));
	}
}
