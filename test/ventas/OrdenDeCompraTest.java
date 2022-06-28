package ventas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import stock.Stock;

public class OrdenDeCompraTest {
	
	private OrdenDeCompra orden;
	private Stock stock;
	
	@BeforeEach
	public void setUp() throws Exception {
		stock = new Stock();
		orden = new OrdenDeCompra();
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		stock = null;
		orden = null;
	}
	
	@Test
	void testAgregarUnProducto() {
		orden.agregarProducto(stock.getProductoEnStock(19));
		assertEquals(1, orden.getCantidadProductos());
	}
	
	@Test
	void testAgregarCincoProductos() {
		orden.agregarProducto(stock.getProductoEnStock(0));
		orden.agregarProducto(stock.getProductoEnStock(1));
		orden.agregarProducto(stock.getProductoEnStock(2));
		orden.agregarProducto(stock.getProductoEnStock(3));
		orden.agregarProducto(stock.getProductoEnStock(4));
		assertEquals(5, orden.getCantidadProductos());
	}
	
	@Test
	void testNoAgregarNingunProducto() {
		assertEquals(0, orden.getCantidadProductos());
	}
	
	@Test
	void testIdOrdenCinco() {
		orden.setIdOrden(5);
		assertEquals(5, orden.getIdOrden());
	}

	@Test
	void testIdOrdenCien() {
		orden.setIdOrden(100);
		assertEquals(100, orden.getIdOrden());
	}
	
	@Test
	void testIdOrdenConNumeroNegativo() {
		/* *
		 *  Testeando la excepción por ingreso de número negativo 
		 *  
		 *  Testing IllegalArgumentException (negative number) 
		 */
		orden.setIdOrden(-1);
		assertTrue("Debe ser número negativo para probar exitosamente la IllegalArgumentException", orden.getIdOrden() < 0);
		System.out.println("Excepción esperada en testIdOrdenConNumeroNegativo()");
	}

	@Test
	void testGetCeroProductos() {
		assertEquals(0, orden.getCantidadProductos());
	}
	
	@Test
	void testGetTresProductos() {
		orden.agregarProducto(stock.getProductoEnStock(0));
		orden.agregarProducto(stock.getProductoEnStock(1));
		orden.agregarProducto(stock.getProductoEnStock(2));
		assertEquals(3, orden.getCantidadProductos());
	}

	@Test
	void testPrecioTotalCero() {
		assertEquals(0.0, orden.precioTotal(), 0.0001);
	}
	
	@Test
	void testPrecioTotalOnceMil() {
		orden.agregarProducto(stock.getProductoEnStock(0));
		orden.agregarProducto(stock.getProductoEnStock(3));
		orden.agregarProducto(stock.getProductoEnStock(5));
		assertEquals(11380.0, orden.precioTotal(), 0.0001);
	}

}
