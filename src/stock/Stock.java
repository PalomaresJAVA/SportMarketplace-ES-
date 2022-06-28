package stock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ventas.Producto;

public class Stock {
	
	ArrayList<Producto> productosEnStock;
	
	@SuppressWarnings("serial")
	public Stock() {
		productosEnStock = new ArrayList<Producto>() {
			{
				add(new Producto("Zapatillas Nike", 7000.0, "AT432TFR671"));
				add(new Producto("Raqueta de ténis", 2500.50, "8RHHO9ANCKQ"));
				add(new Producto("Pelota Adidas", 3000.70, "1BZ6HBITBB3"));
				add(new Producto("Buzo de invierno", 1780.0, "6AU5RH3MKMP"));
				add(new Producto("Remera Argentina", 1400.10, "3IO70MVHY5Z"));
				add(new Producto("Palo de golf", 2600.0, "WSHR8OH450J"));
				add(new Producto("Botines Puma", 8500.40, "AY1G767SIKC"));
				add(new Producto("Guantes de atajar", 1308.40, "HPTIZB5S5E3"));
				add(new Producto("Sudadera", 3604.56, "LQCEO6EQBE2"));
				add(new Producto("Banda para el pelo", 320.0, "V82YWI5DW37"));
				add(new Producto("Red de voleyball", 6700.0, "NURZNMA14IZ"));
				add(new Producto("Bate de softball", 1965.70, "NJHKBVEYKPY"));
				add(new Producto("Remera D&J", 4030.90, "26HJ172OY4H"));
				add(new Producto("Pelota de rugby", 1740.10, "6H2NGIWZJC3"));
				add(new Producto("Set pelotas de ténis", 1800.10, "WCFBYWFG6II"));
				add(new Producto("Banderín campo de golf", 850.30, "616PZQH86EV"));
				add(new Producto("Guantes de neoprene", 700.40, "277HD4BRKLI"));
				add(new Producto("Traje de buceo", 5308.0, "6NXNWTGDYOJ"));
				add(new Producto("Navaja de entrenamiento", 1610.56, "218B0R7SZ3D"));
				add(new Producto("Florete de esgrima", 3020.0, "IUKANIN1GYE"));
			}
		};
	}
	
	public Producto getProductoEnStock(int indice_producto) {
		return productosEnStock.get(indice_producto);
	}
	
	public void verTodosLosProductosEnElStock() {
		for(Producto producto : productosEnStock) {
			System.out.println(producto.getId() + " " + producto.getNombre() + ": " + producto.getPrecio());
		}
	}
	
	public void agregarProductosAlStock(Producto p) {
		productosEnStock.add(p);
	}
	
	public void quitarProductoDelStock(int indice_producto) {
		productosEnStock.remove(indice_producto);
	}
	
	/* *
	 * Los productos en el stock son ordenados teniendo en cuenta su ID:
	 * 
	 * Products in stock are ordered depending their ID:
	 */
	
	public void ordenarStock() {
		Collections.sort(productosEnStock, new Comparator<Producto>() {
			public int compare(Producto p1, Producto p2) {
				return p1.getId().compareTo(p2.getId());
			}
		});
	}
	
	public int tamanioDelStock() {
		return productosEnStock.size();
	}

}
