package ar.uba.fi.algo3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProductoLibreriaTest {

	@Test
	public void testComparaNombreExactoVerdadero() {
		ProductoLibreria producto = new ProductoLibreria("lapiz", 20);
		assertTrue(producto.nombreExacto("lapiz"));
	}
	
	@Test
	public void testComparaNombreExactoFalso() {
		ProductoLibreria producto = new ProductoLibreria("lapiz", 20);
		assertFalse(producto.nombreExacto("lapicera"));
	}
	
	@Test
	public void testComparaNombreAproximadoVerdadero() {
		ProductoLibreria producto = new ProductoLibreria("papelera", 420);
		assertTrue(producto.nombreAproximado("papel"));
	}
	
	@Test
	public void testComparaNombreAproximadoFalso() {
		ProductoLibreria producto = new ProductoLibreria("papelera", 420);
		assertFalse(producto.nombreAproximado("carpeta"));
	}
	
	@Test
	public void testRangoDePrecioEnRangoVerdadero() {
		ProductoLibreria producto = new ProductoLibreria("lapiz", 20);
		assertTrue(producto.enRango(10, 30));
	}
	
	@Test
	public void testRangoDePrecioEnRangoFalso() {
		ProductoLibreria producto = new ProductoLibreria("lapiz", 20);
		assertFalse(producto.enRango(40, 50));
	}

}
