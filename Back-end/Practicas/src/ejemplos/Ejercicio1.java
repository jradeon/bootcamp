package ejemplos;

import java.util.Scanner; //La clase Scanner se encuentra en el paquete java.util 
							//por lo tanto se debe incluir al inicio del programa la instrucci�n:

//Juego de �Adivina el n�mero que estoy pensando�, un n�mero del 1 al 100, ya te dir� si es mayor o menor que el m�o, pero tienes 10 intentos como mucho.
//

public class Ejercicio1 {

	public void run() { // public static class ser�a una instancia de clase, mejor es poner
		// public class y en la clase principal crear el objeto que llame a esa
		// instancia

//		Tenemos que crear un objeto de la clase Scanner asociado al dispositivo de entrada.
//		Si el dispositivo de entrada es el teclado escribiremos:

		Scanner sc = new Scanner(System.in);

		int a = (int) ((Math.random() * 100) + 1); // N�mero aleatorio de 1 a 100. +1 para que se incluya el �ltimo num
		int b; // N�mero introducido por el usuario.
		int i; // Contador para bucle for.

		System.out.println("El juego consiste en averiguar un n�mero secreto de 100 posibles.");

		System.out.print("Tienes 10 intentos. Escribe un n�mero entre 1 y 100: ");

		// i vale 1 y va de 1 a 10 intentos, mientras sea menor o igual a 9 tienes otro
		// intento
		for (i = 1; i <= 10; i++) {

			b = sc.nextInt(); // nextInt() para leer un dato de tipo int.
			// Primero se eval�a si se ha acertado.

			if (a == b) {
				System.out.println("�Has acertado!");
				break;
			} else if (i == 10) { // Luego da la partida por perdida si ya has gastado 10 intentos.
				System.out.println("Lo siento: �has perdido!. El n�mero era el: " + a);
				break;
			} else if (a > b) // Si no es ninguno de los casos anteriores, comparamos n�meros.
				System.out.println("El n�mero secreto es MAYOR que " + b);
			else if (a < b)
				System.out.println("El n�mero secreto es MENOR que " + b);

			// Por �ltimo un bucle if que sirve para dar una pista y avisarte de la �ltima
			// oportunidad.

			if (i == 9) {

				System.out.print("Oh, oh... �LTIMO intento: ");
			}

		}

	}

	public void inicializar() {

		System.out.println("El juego consiste en averiguar un n�mero secreto de 100 posibles.");

		System.out.println("Tienes 10 intentos");

	}

	public void jugada() {

		Scanner sc = new Scanner(System.in);
		System.out.print("Escribe un numero: ");

		int a = (int) ((Math.random() * 100) + 1); // N�mero aleatorio de 1 a 100. +1 para que se incluya el �ltimo num
		int b; // N�mero introducido por el usuario.
		int i; // Contador para bucle for.
		for (i = 1; i <= 10; i++) {

			b = sc.nextInt(); // nextInt() para leer un dato de tipo int.
			// Primero se eval�a si se ha acertado.

			if (a == b) {
				System.out.println("�Has acertado!");
				break;
			} else if (i == 10) { // Luego da la partida por perdida si ya has gastado 10 intentos.
				System.out.println("Lo siento: �has perdido!. El n�mero era el: " + a);
				break;
			} else if (a > b) {// Si no es ninguno de los casos anteriores, comparamos n�meros.
				System.out.println("El n�mero secreto es MAYOR que " + b);
			} else if (a < b) {
				System.out.println("El n�mero secreto es MENOR que " + b);
			}
			// Por �ltimo un bucle if que sirve para dar una pista y avisarte de la �ltima
			// oportunidad.

			if (i < 9) {
				System.out.print("Otro intento: ");
			} else {
				System.out.print("Oh, oh... �LTIMO intento: ");
			}

		}

	}
}
