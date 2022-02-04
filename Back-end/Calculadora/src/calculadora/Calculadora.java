package calculadora;

import java.util.Scanner;

public class Calculadora {

	public static void main() {
		Scanner entrada = new Scanner(System.in);
		
		double dividendo =0;
		double divisor= 0;
		double resultado= 0;
		
	
		System.out.println("Introduce Dividendo: ");
		 dividendo= entrada.nextInt();

		System.out.println("Introduce Divisor: ");
		 divisor= entrada.nextInt();
		 
		 resultado = dividendo / divisor;
		 System.out.println("RESULTADO: " + resultado);
		
	}

}
