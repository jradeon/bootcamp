package trabajoclases;

//Trabajar Interface, clases abstractas, herencias

public class Alimentos extends Productos {
	private char tipo;
	private int pesogramos;

	// Hereda de la clase productos los atributos y m�todos
	public Alimentos(char tipo, int pesogramos, int codigo, String nombre, String descripci�n, int cantidad,
			int precio) {
		super(codigo, nombre, descripci�n, cantidad, precio);
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
	// Sobreescribe el m�todo heredado de la Interface Calculable a trav�s de
	// productos
	public int calcularPrecioFinal(int precio) {
		int descuento = 0;
		// Hacemos un casting para convertir el descuento que es double en int
		descuento = (int) (precio - (precio * Calculable.descuento));
		return descuento;
	}

	// M�todo abstracto de Productos lo sobreescribimos aqu�, ya que se hereda
	public void mostrarDatos() {
		System.out.println(super.toString() + "Alimentos " + "tipo=" + tipo + ", pesogramos=" + pesogramos);
	}

}
