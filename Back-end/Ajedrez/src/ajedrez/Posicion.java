package ajedrez;

import java.util.Objects;

public class Posicion {

 private int fila;
 private int columna;
 
// no necesito hacer el set porque la posición es inmutable 
// mis valores van del 1-8 pero me lo pueden expresasr de la a la H
 
 
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

	@Override
	public int hashCode() {
		return Objects.hash(columna, fila);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return columna == other.columna && fila == other.fila;
	}

	

		
	
}
