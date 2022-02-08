package ajedrez;

public class Posicion {

 private int fila;
 private int columna;
 
 
 	public Posicion (int fila, int columna) {
 		this.fila = fila;
 		this.columna= columna;
 	}
 	
 	public Posicion (char fila, char columna) {
 		this.fila = fila;
 		this.columna= columna;
 		
 	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	
	public boolean equals(Posicion posicion) {
		
		return super.equals(posicion);
	}
	
	
		
	
}
