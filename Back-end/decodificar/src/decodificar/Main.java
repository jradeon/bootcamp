package decodificar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	static String cadena;

	public static void main(String[] args) throws FileNotFoundException {
//			Decodificar e = new Decodificar();
//			e.decodificar();
//			e.calcular();

		try {
			leerFichero(); // llamamos al método
//			calcula(cadena);
		} catch (CalculadoraException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void leerFichero() throws CalculadoraException, Exception {
		File doc = new File("C:\\Users\\jespinfe\\Desktop\\document.txt");
		Scanner obj = new Scanner(doc);
		while (obj.hasNextLine()) {
			cadena = obj.nextLine();
			System.out.println("El documento contiene: " + cadena);
			calcula(cadena);
			guardarFichero(cadena);

		}
	}
	
	public static void guardarFichero() {
    
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("C:\\Users\\jespinfe\\Desktop\\document.txt",true); // true para fichero ya existente
            
            
            pw = new PrintWriter(fichero);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
	String[] lineas = { "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "..." };

	/** FORMA 1 DE ESCRITURA **/
	FileWriter fichero = null;
	try {

		fichero = new FileWriter("fichero_escritura.txt");

		// Escribimos linea a linea en el fichero
		for (String linea : lineas) {
			fichero.write(linea + "\n");
		}

		fichero.close();

	} catch (Exception ex) {
		System.out.println("Mensaje de la excepción: " + ex.getMessage());
	}
}
}

	public static double calcula(String expresion) throws CalculadoraException, Exception {
		if (expresion == null || "".equals(expresion) || !Character.isDigit(expresion.charAt(0)))
			throw new java.lang.IllegalArgumentException("No es una expresión valida");
		String operando = "";
		Calculadora calculadora = new Calculadora();
		for (int i = 0; i < expresion.length(); i++) {
			char ch = expresion.charAt(i);
			if (Character.isDigit(ch)) {
				operando += ch;
			} else if (ch == ',') {
				if (operando.indexOf(ch) == -1) {
					operando += ch;
				} else {
					// throw new Exception("Ya existe separador decimal.");
				}
			} else if ("+-*/%=".indexOf(ch) >= 0) {
				if (operando.endsWith(",")) {
					operando += "0";
				}
				calculadora.calcula(operando, ch);
				// System.out.println(operando + "\t" + ch + "\t" + calculadora.getAcumulado());
				// //cambiar esto para guardar en fichero
				if (ch == '=') {
					break;
				}
				operando = "";
			} else if (ch != ' ') {
//					throw new Exception("Carácter no valido.");
			}
		}
		System.out.println(calculadora.getAcumulado());
		return calculadora.getAcumulado();
	}
}
