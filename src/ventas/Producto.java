package ventas;

public class Producto {
	
	private String nombre;
	private double precio;
	private String id;
	
	public Producto(String nombre, double precio, String id) {
		this.nombre = nombre;
		this.precio = precio;
		this.id = id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
		
		try {
			if(this.precio < 0) {
				throw new IllegalArgumentException("El precio no puede ser negativo");
			}
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String datosProducto() {
		return "\n\tNombre: " + this.nombre + "\n\tPrecio: $" + this.precio + "\n\tID: " + this.id + "\n";
	}

}
