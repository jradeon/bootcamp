package trabajoclases;

public class Perfumeria extends Productos {
	private int ml;
	private char aroma;

	public Perfumeria(int ml, char aroma, int codigo, String nombre, String descripci�n, int cantidad, int precio) {
		super(codigo, nombre, descripci�n, cantidad, precio);
		this.ml = ml;
		this.aroma = aroma;
	}

	public Perfumeria() {

	}

	public int getMl() {
		return ml;
	}

	public void setMl(int ml) {
		this.ml = ml;
	}

	public char getAroma() {
		return aroma;
	}

	public void setAroma(char aroma) {
		if (aroma == 'V' || aroma == 'F' || aroma == 'L') {
			this.aroma = aroma;
		} else {
			System.out.println("El tipo debe ser v- Vainilla o F frutilla � Lim�n");
		}
	}

	public int contarProducto() {
		int cant = 0;
		if (getNombre().equalsIgnoreCase("cremas")) {
			System.out.println("Cantidad de cremas " + getCantidad());
		}
		return cant;
	}

	public void mostrarDatos() {
		System.out.println(toString() + "Perfumeria " + "ml= " + ml + ",aroma= " + aroma);
	}

	@Override
	// Sobreescribe el m�todo heredado de la Interface Calculable a trav�s de
	// productos
	public int calcularPrecioFinal(int precio) {
		int descuento = 0;
		// Hacemos un casting para convertir el descuento que es double en int
		descuento = (int) (precio * Calculable.descuento);
		return descuento;
	}

}
