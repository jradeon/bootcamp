package baraja;

//Crear las clases para implementar juegos que utilizan una baraja de naipes.
//Los naipes tienen dos propiedades distintivas: valor y palo. 
//Probar la funcionalidad de barajar, repartir, comparar, … 
//(Utilizar Enumeraciones, genéricos, colecciones …)

public class Juego {

	int[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	String pal[] = { "espada", "copas", "baston", "oros" };

	public void generarCartas() {

		int[] revolver = new int[40];
		int i = 0;

		revolver[i] = (int) (Math.random() * numeros.length); // genera los numeros aleatorios

		for (i = 1; i < revolver[i]; i++) {
			revolver[i] = (int) (Math.random() * numeros.length);
			System.out.println(revolver[i]);

		}
	}

//	    public void repartirCartas(){       
//	        for(int k=0; k<totalCartas; k++){ 
//	            String cartita = cartitas[revolver[k] %13 ];
//
//	            String palito = palitos[revolver[k] / 4 ];
//
//	            switch(revolver[k]){
//
//	            case 1:
//	                System.out.println("Tu carta numero " + (k+1) + " es el: " + cartita + " de " + palito );
//	                suma = suma + revolver[k];
//
//	            break;
//
//	            default:
//	                System.out.println("Tu carta numero " + (k+1) + " es el: " + cartita + " de " + palito );
//	                suma = suma + revolver[k] + 1;
//
//	                break;
//
//	            }
//
//	        }
//	        System.out.println("Total suma:" + (suma+1));
//	    }
}

