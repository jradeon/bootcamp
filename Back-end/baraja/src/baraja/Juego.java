package baraja;

import java.util.ArrayList;
import java.util.List;

//Crear las clases para implementar juegos que utilizan una baraja de naipes.
//Los naipes tienen dos propiedades distintivas: valor y palo. 
//Probar la funcionalidad de barajar, repartir, comparar, … 
//(Utilizar Enumeraciones, genéricos, colecciones …)

public class Juego {

	public void generarCartas() {
        Naipe n = new Naipe(Naipe.Palos.oros, Naipe.Numeros.REY); 
        List<Naipe> baraja = new ArrayList<Naipe> ();
        
        for(var palo : Naipe.Palos.values()) //values es la forma de devolver la posición con el enum
            for(var numero : Naipe.Numeros.values())
            	baraja.add(new Naipe(palo,numero));
        			
            	 
        	
        baraja.forEach(System.out::println);	
//      baraja.forEach(item-> System.out.println(item.toString()));
        
     Public void repartirCartas() {
    	 
    	
    	 
     }
        
//		int[] generarnum = new int[40];
//		String [] generarpalos = new String [4];
//		int i = 0;
//
//		generarnum[i] = (int) (Math.random() * numeros.length); // genera los numeros aleatorios
//		generarpalos[j] = 
//
//		for (i = 1; i < generarnum[i]; i++) {
//			generarnum[i] = (int) (Math.random() * numeros.length);
//			System.out.println(generarnum[i]);
//
//		}
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

