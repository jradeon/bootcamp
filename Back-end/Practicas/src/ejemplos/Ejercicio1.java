package ejemplos;

import java.util.Scanner; //La clase Scanner se encuentra en el paquete java.util 
							//por lo tanto se debe incluir al inicio del programa la instrucción:

//Juego de “Adivina el número que estoy pensando”, un número del 1 al 100, ya te diré si es mayor o menor que el mío, pero tienes 10 intentos como mucho.
//

public class Ejercicio1 {

	public void run() { // public static class sería una instancia de clase, mejor es poner
		// public class y en la clase principal crear el objeto que llame a esa
		// instancia

//		Tenemos que crear un objeto de la clase Scanner asociado al dispositivo de entrada.
//		Si el dispositivo de entrada es el teclado escribiremos:

		Scanner sc = new Scanner(System.in);

		int a = (int) ((Math.random() * 100) + 1); // Número aleatorio de 1 a 100. +1 para que se incluya el último num
		int b; // Número introducido por el usuario.
		int i; // Contador para bucle for.

		System.out.println("El juego consiste en averiguar un número secreto de 100 posibles.");

		System.out.print("Tienes 10 intentos. Escribe un número entre 1 y 100: ");

		// i vale 1 y va de 1 a 10 intentos, mientras sea menor o igual a 9 tienes otro
		// intento
		for (i = 1; i <= 10; i++) {

			b = sc.nextInt(); // nextInt() para leer un dato de tipo int.
			// Primero se evalúa si se ha acertado.

			if (a == b) {
				System.out.println("¡Has acertado!");
				break;
			} else if (i == 10) { // Luego da la partida por perdida si ya has gastado 10 intentos.
				System.out.println("Lo siento: ¡has perdido!. El número era el: " + a);
				break;
			} else if (a > b) // Si no es ninguno de los casos anteriores, comparamos números.
				System.out.println("El número secreto es MAYOR que " + b);
			else if (a < b)
				System.out.println("El número secreto es MENOR que " + b);

			// Por último un bucle if que sirve para dar una pista y avisarte de la última
			// oportunidad.

			if (i == 9) {

				System.out.print("Oh, oh... ÚLTIMO intento: ");
			}

		}

	}

	public void inicializar() {

		System.out.println("El juego consiste en averiguar un número secreto de 100 posibles.");

		System.out.println("Tienes 10 intentos");

	}

	public void jugada() {

		Scanner sc = new Scanner(System.in);
		System.out.print("Escribe un numero: ");

		int a = (int) ((Math.random() * 100) + 1); // Número aleatorio de 1 a 100. +1 para que se incluya el último num
		int b; // Número introducido por el usuario.
		int i; // Contador para bucle for.
		for (i = 1; i <= 10; i++) {

			b = sc.nextInt(); // nextInt() para leer un dato de tipo int.
			// Primero se evalúa si se ha acertado.

			if (a == b) {
				System.out.println("¡Has acertado!");
				break;
			} else if (i == 10) { // Luego da la partida por perdida si ya has gastado 10 intentos.
				System.out.println("Lo siento: ¡has perdido!. El número era el: " + a);
				break;
			} else if (a > b) {// Si no es ninguno de los casos anteriores, comparamos números.
				System.out.println("El número secreto es MAYOR que " + b);
			} else if (a < b) {
				System.out.println("El número secreto es MENOR que " + b);
			}
			// Por último un bucle if que sirve para dar una pista y avisarte de la última
			// oportunidad.

			if (i < 9) {
				System.out.print("Otro intento: ");
			} else {
				System.out.print("Oh, oh... ÚLTIMO intento: ");
			}

		}

	}
}
