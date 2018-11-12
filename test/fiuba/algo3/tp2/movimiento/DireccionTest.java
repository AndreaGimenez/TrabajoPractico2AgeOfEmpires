package fiuba.algo3.tp2.movimiento;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.tp2.mapa.Posicion;

public class DireccionTest {
	
	@Test
	public void testDadaUnaDireccionX1Y3AlMultiplicarlaPor1DeberiaQuedarIgual() {
		
		Direccion direccion = new Direccion(new Integer(1), new Integer(3));
		
		Posicion posicion = direccion.multiplicar(1);
		
		assertEquals(1,posicion.getX());
		assertEquals(3,posicion.getY());
	}
	
	@Test
	public void testDadaUnaDireccionX2Y3AlMultiplicarlaPor3DeberiaQuedarX6Y9() {
		
		Direccion direccion = new Direccion(new Integer(2), new Integer(3));
		
		Posicion posicion = direccion.multiplicar(3);
		
		assertEquals(6,posicion.getX());
		assertEquals(9, posicion.getY());
	}
	
	@Test
	public void testDadaUnaDireccionX2Y3AlMultiplicarlaPor0DeberiaQuedarX0Y0() {
		
		Direccion direccion = new Direccion(new Integer(2), new Integer(3));
		
		Posicion posicion = direccion.multiplicar(0);
		
		assertEquals(0,posicion.getX());
		assertEquals(0, posicion.getY());
	}
}
