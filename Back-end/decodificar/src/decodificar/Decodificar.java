package decodificar;

//3+4+3,4-7*1=

public class Decodificar {

	public void decodificar() {

		int i;
		String cadena = "3+4+3,4-7*=1";
		String[] subCadenas = cadena.split("(?<=[-+*=])");

		System.out.println("Decodificar la cadena por operador");

		for (i = 0; i < subCadenas.length; i++) {

			System.out.println(subCadenas[i]);
		}

	}
	
	public void calcular() {
		int i;
		String cadena = "3+4+3,4-7*=1";
		String[] subCadenas = cadena.split("(?<=[-+*=])");
		int num;
		int suma;

		System.out.println("3+4+3,4-7*=1");

		for (i = 0; i < subCadenas.length; i++) {
			num = subCadenas[i];
			suma = num + num;
			
			System.out.println(suma);
			
			
		}
			
	}

	
}

		
		
	
		

	
