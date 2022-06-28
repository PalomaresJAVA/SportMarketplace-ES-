package ventas;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductoTest {
	
	private Producto p;
	
	@BeforeEach
	public void setUp() throws Exception {
		p = new Producto("nombre", 0.0, "id");
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		p = null;
	}

	@Test
	void testGetNombre() {
		assertEquals("nombre", p.getNombre());
	}

	@Test
	void testSetNombreRemera() {
		p.setNombre("remera");
		assertEquals("remera", p.getNombre());
	}
	
	@Test
	void testSetNombreGuantes() {
		p.setNombre("guantes");
		assertEquals("guantes", p.getNombre());
	}

	@Test
	void testGetPrecio() {
		assertEquals(0.0, p.getPrecio(), 0.0001);
	}

	@Test
	void testSetPrecioConCien() {
		p.setPrecio(100.15);
		assertEquals(100.15, p.getPrecio(), 0.0001);
	}
	
	@Test
	void testSetPrecioConVeinte() {
		p.setPrecio(20.0);
		assertEquals(20.0, p.getPrecio(), 0.0001);
	}
	
	@Test
	void testSetPrecioNegativo() {
		p.setPrecio(-10.0);
		assertTrue("Debe ser número negativo para probar exitosamente la IllegalArgumentException", p.getPrecio() < 0);
		System.out.println("Excepción esperada en testSetPrecioNegativo().");
	}

	@Test
	void testGetId() {
		assertEquals("id", p.getId());
	}

	@Test
	void testSetIdUno() {
		p.setId("1A");
		assertEquals("1A", p.getId());
	}
	
	@Test
	void testSetIdDos() {
		p.setId("2B");
		assertEquals("2B", p.getId());
	}
	
	@Test
	void testDatos() {
		String esperado = "\n\tNombre: " + p.getNombre() + "\n\tPrecio: $" + p.getPrecio() + "\n\tID: " + p.getId() + "\n";
		assertEquals(esperado, p.datosProducto());
	}
	
	@Test
	void testDatosDiferentes() {
		p.setNombre("otro nombre");
		p.setPrecio(1.11);
		p.setId("ABC123");
		String esperado = "\n\tNombre: " + p.getNombre() + "\n\tPrecio: $" + p.getPrecio() + "\n\tID: " + p.getId() + "\n";
		assertEquals(esperado, p.datosProducto());
	}

}