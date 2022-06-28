package ventas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class OrdenDeCompra {
	
	private int idOrden;
	private List<Producto> listaProductos;
	
	public OrdenDeCompra() {
		listaProductos = new ArrayList<Producto>();
	}
	
	public int getIdOrden() {
		return this.idOrden;
	}
	
	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
		
		try {
			if(this.idOrden < 0) {
				throw new IllegalArgumentException("La ID de orden no puede ser número negativo");
			}
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	
	public void agregarProducto(Producto a) {
		listaProductos.add(a);
	}
	
	public int getCantidadProductos() {
		return listaProductos.size();
	}
	
	public double precioTotal() {
		double total = 0.0;
		
		for(Producto producto : listaProductos) {
			total += producto.getPrecio();
		}
		return total;
	}
	
	/* *
	 * El siguiente método muestra el recibo por consola:
	 * 
	 * The following method shows the receipt in console:
	 */
	
	public void verOrden() {
		String productosOrden = "";
		
		for(Producto producto : listaProductos) {
			productosOrden += producto.datosProducto();
		}
		System.out.println("Número de orden: " + this.idOrden + "\n\nProductos:\n" + 
						    productosOrden + "\nTotal: $" + this.precioTotal());
	}
	
	/* *
	 * El siguiente método sirve para convertir los recibos en un archivo de texto, pasando como parámetro 
	 * el número (o la ID, si se quiere) de la orden.
	 * 
	 * The following method is used to convert the receipts in a text file, passing the number 
	 * (or the ID if you want) of the order. 
	 */
	
	public void generarRecibo(int indice_recibo) {
		String productosOrden = "";

		for(Producto producto : listaProductos) {
			productosOrden += producto.datosProducto();
		}
		String recibo = "Número de orden: " + this.idOrden + "\n\nProductos:\n" + 
				productosOrden + "\nTotal: $" + this.precioTotal();
		
		String directorio = "recibos_generados";
		String nombre = "recibo" + indice_recibo + ".txt";
		
		File dirFile = new File(directorio);
		File archivo = new File(dirFile, nombre);
		
		try(PrintWriter out = new PrintWriter(archivo)) {
			out.println(recibo);
			out.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
