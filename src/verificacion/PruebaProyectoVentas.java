package verificacion;

import ventas.*;
import stock.Stock;

public class PruebaProyectoVentas {

	public static void main(String[] args) {
		/* *
		 * Creando el stock de la tienda:
		 * 
		 * Creating the product stock:
		 */
		Stock s = new Stock();
		
		System.out.println("************************************************************************************************");
		System.out.println("CREANDO ORDEN DE PRUEBA 1...");
		System.out.println("************************************************************************************************\n");
		OrdenDeCompra o1 = new OrdenDeCompra();
		o1.setIdOrden(1);
		o1.agregarProducto(s.getProductoEnStock(2));
		o1.agregarProducto(s.getProductoEnStock(9));
		o1.agregarProducto(s.getProductoEnStock(0));
		o1.verOrden();
		
		/* *
		 * Generando el recibo 1 en un archivo de texto:
		 * 
		 * Generating receipt 1 in a text file:
		 */
		o1.generarRecibo(1);
		
		System.out.println("\n************************************************************************************************");
		System.out.println("CREANDO ORDEN DE PRUEBA 2...");
		System.out.println("************************************************************************************************\n");
		OrdenDeCompra o2 = new OrdenDeCompra();
		o2.setIdOrden(2);
		o2.agregarProducto(s.getProductoEnStock(4));
		o2.agregarProducto(s.getProductoEnStock(6));
		o2.verOrden();
		
		/* *
		 * Generando el recibo 2 en un archivo de texto:
		 * 
		 * Generating receipt 2 in a text file:
		 */
		o2.generarRecibo(2);
		
		System.out.println("\n************************************************************************************************");
		System.out.println("MOSTRANDO PRODUCTOS EN STOCK...");
		System.out.println("************************************************************************************************\n");
		s.ordenarStock();
		s.verTodosLosProductosEnElStock();
		
		System.out.println("\n************************************************************************************************");
		System.out.println("AGREGANDO PRODUCTOS NUEVOS AL STOCK...");
		System.out.println("(PALOS DE SKI, PELOTA DE BASKETBALL, CASCO DE MOTOCROSS Y RUEDA PARA BICICLETA DE MONTAÑA)");
		System.out.println("************************************************************************************************");
		s.agregarProductosAlStock(new Producto("Pack 2 palos de ski", 1964.55, "ZJ6L532ZP6U"));
		s.agregarProductosAlStock(new Producto("Pelota de basketball", 1200.0, "WOPYC9HVZ7J"));
		s.agregarProductosAlStock(new Producto("Casco de motocross", 4634.40, "6UQHAKT3JUQ"));
		s.agregarProductosAlStock(new Producto("Rueda para bicicleta de montaña", 12890.75, "J2AWITQQSWS"));
		
		System.out.println("\n************************************************************************************************");
		System.out.println("MOSTRANDO PRODUCTOS EN STOCK ACTUALIZADO...");
		System.out.println("************************************************************************************************\n");
		/* *
		 *  Se ordena el stock luego de agregar o quitar productos:
		 * 
		 *  Stock is ordered after adding or removing products:
		 */
		s.ordenarStock();
		s.verTodosLosProductosEnElStock();
		
		System.out.println("\n************************************************************************************************");
		System.out.println("CREANDO ORDEN DE PRUEBA 3...");
		System.out.println("************************************************************************************************\n");
		OrdenDeCompra o3 = new OrdenDeCompra();
		o3.setIdOrden(3);
		o3.agregarProducto(s.getProductoEnStock(9));
		o3.agregarProducto(s.getProductoEnStock(15));
		o3.agregarProducto(s.getProductoEnStock(21));
		o3.agregarProducto(s.getProductoEnStock(23));
		o3.verOrden();
		
		/* *
		 * Generando el recibo 3 en un archivo de texto:
		 * 
		 * Generating receipt 3 in a text file:
		 */
		o3.generarRecibo(3);
		
		System.out.println("\n************************************************************************************************");
		System.out.println("NO HAY MAS PALOS DE SKI. QUITANDO DEL STOCK...");
		System.out.println("************************************************************************************************");
		s.quitarProductoDelStock(23);
		
		System.out.println("\n************************************************************************************************");
		System.out.println("MOSTRANDO PRODUCTOS EN STOCK ACTUALIZADO...");
		System.out.println("************************************************************************************************\n");
		s.ordenarStock();
		s.verTodosLosProductosEnElStock();
	}

}