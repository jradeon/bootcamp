package trabajoclases;

public abstract class Productos implements Calculable {

	// encapsulamiento, tendremos que usar setters and getters

	private int codigo;
	private String nombre;
	private String descripci�n;
	private int cantidad;
	private int precio;

	// CONSTRUCTOR CON PAR�METROS *Preguntar
	public Productos(int codigo, String nombre, String descripci�n, int cantidad, int precio) {
		this.codigo = codigo;
		this.setNombre(nombre);
		this.descripci�n = descripci�n;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	// CONSTRUCTOR SIN PARAMETROS *Preguntar
	public Productos() {
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	// Validaci�n
	public void setNombre(String nombre) {
		int largo;
		largo = nombre.length();
		if (largo > 0) {
			this.nombre = nombre;
		}else {
			System.out.println("El nombre no debe ir vac�o");
	}

	public String getDescripci�n() {
		return descripci�n;
	}

	public void setDescripci�n(String descripci�n) {
		this.descripci�n = descripci�n;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public void mostrarDatos() {
	}

	public abstract int contarProducto();

	public int calcularTotal(int cantidad, String dia) {
		int total = 0;
		int descuento = 0;

		descuento = calcularPrecioFinal(precio);
		total = this.precio * cantidad - descuento * cantidad;
		return total;

	}

}
