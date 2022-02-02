package trabajoclases;

//Trabajar Interface, clases abstractas, herencias

public class Alimentos extends Productos {
	private char tipo;
	private int pesogramos;

	// Hereda de la clase productos los atributos y métodos
	public Alimentos(char tipo, int pesogramos, int codigo, String nombre, String descripción, int cantidad,
			int precio) {
		super(codigo, nombre, descripción, cantidad, precio);
		this.tipo = tipo;
		this.pesogramos = pesogramos;
	}

	public Alimentos() {

	}

	// Setters and Getters
	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		if (tipo == 'L' || tipo == 'C' || tipo == 'l' || tipo == 'c') {
			this.tipo = tipo;
		} else {
			System.out.println("el tipo deber ser L (LECHE) O C (Colacao)");
		}

	}

	public int getPesogramos() {
		return pesogramos;
	}

	public void setPesogramos(int pesogramos) {
		this.pesogramos = pesogramos;
	}

	public int contarProducto() {
		int cant = 0;
		if (tipo == 'L' || 'l') {
			System.out.println("Cantidad de leche" + getCantidad());
		}
		return cant;
	}

	@Override
	// Sobreescribe el método heredado de la Interface Calculable a través de
	// productos
	public int calcularPrecioFinal(int precio) {
		int descuento = 0;
		// Hacemos un casting para convertir el descuento que es double en int
		descuento = (int) (precio - (precio * Calculable.descuento));
		return descuento;
	}

	// Método abstracto de Productos lo sobreescribimos aquí, ya que se hereda
	public void mostrarDatos() {
		System.out.println(super.toString() + "Alimentos " + "tipo=" + tipo + ", pesogramos=" + pesogramos);
	}

}
