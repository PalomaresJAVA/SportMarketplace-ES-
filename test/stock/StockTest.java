package stock;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ventas.Producto;

public class StockTest {
	
	private Stock stock;
	private Producto p;
	
	@BeforeEach
	public void setUp() throws Exception {
		stock = new Stock();
		p = new Producto("nombre", 0.0, "id");
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		stock = null;
		p = null;
	}

	@Test
	void testGetNombreDeProductoEnStock() {
		assertEquals("Palo de golf", stock.getProductoEnStock(5).getNombre());
	}
	
	@Test
	void testGetPrecioDeProductoEnStock() {
		assertEquals(4030.90, stock.getProductoEnStock(12).getPrecio(), 0.0001);
	}
	
	@Test
	void testGetIdDeProductoEnStock() {
		assertEquals("IUKANIN1GYE", stock.getProductoEnStock(19).getId());
	}
	
	/* *
	 *  Por defecto, en el stock hay una cantidad de 20 productos (0-19) 
	 *  
	 *  There are twenty products in stock by default (0-19)
	 */

	@Test
	void testAgregarProductosAlStock() {
		stock.agregarProductosAlStock(p);
		assertEquals(21, stock.tamanioDelStock());
	}

	@Test
	void testQuitarProductoDelStock() {
		stock.quitarProductoDelStock(19);
		assertEquals(19, stock.tamanioDelStock());
	}

}
