package trabajoclases;

import java.util.Scanner;

public class ProductosBebe {

	public static void main(String[] args) {

		Alimentos alimento = new Alimentos('L', 500, 12010, "leche", "sobrole", 2, 790);
		Perfumeria perfumeria = new Perfumeria(100, 'F', 2121, "Cremas", "Bebesito", 2, 15000);

		// Alimentos
		alimento.mostrarDatos();
		System.out.println("Precio final:" + alimento.calcularPrecioFinal(alimento.getPrecio()));
		alimento.contarProducto();

		// Perfumeria
		perfumeria.mostrarDatos();
		System.out.println("Precio final: " + perfumeria.calcularPrecioFinal(perfumeria.getPrecio()));
		perfumeria.contarProducto();

		System.out.println("******************");
		System.out.println("******************");
		System.out.println("******************");

		RegistroProductos registro = new RegistroProductos();
		registro.agregarProducto(alimento);
		registro.agregarProducto(perfumeria);

		if (registro.verificarProducto(321) == false) {
			System.out.println("No existe");

		} else {
			System.out.println("Existe");
		}

		registro.listar();

	}

}
