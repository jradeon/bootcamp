package trabajoclases;

import java.util.ArrayList;

public class RegistroProductos {
	ArrayList<Productos> productos = new ArrayList<Productos>();

	public void agregarProducto(Productos nuevoProducto) { // nuebo objetvo nuevoProducto
		if (this.verificarProducto(nuevoProducto.getCodigo()) == false) {
			productos.add(nuevoProducto);
		} else {
			System.out.println("Producto existe");
		}
	}

	public void listar() {
		// foreach ponemos el tipo de Arraylist <Productos>
		// variable(temporalProductos) y el nombre del array y lo mostramos con el
		// to.String
		for (Productos temporalProducto : productos) {
			System.out.println(temporalProducto.toString());
		}
	}

	public boolean verificarProducto(int codigo) { // declaramos la variable que vamos a utilizar
		boolean existe = false;
		for (Productos temporalProductos : productos) { // foreach
			if (temporalProductos.getCodigo() == codigo) {
				existe = true;
				break;
			}
		}
		return existe;
	}

	// Si el producto del nombre que recibo es igual al nombre de la posición que le
	// paso lo elimino
	public void eliminarProductos(String nombre) {
		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).getNombre().equals(nombre)) {
				productos.remove(i);
				i = i - 1; // AL ELIMINAR UNA POSICIÓN NOS SOBRA UNA POR ESO LE RESTAMOS ESA POSICIÓN
				// P1 P2 P3
				// 0 1 2
			}
		}
	}
}
