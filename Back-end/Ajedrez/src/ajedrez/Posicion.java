package ajedrez;

import java.util.Objects;

public class Posicion {

 private int fila;
 private int columna;
 
// no necesito hacer el set porque la posición es inmutable 
// mis valores van del 1-8 pero me lo pueden expresasr de la a la H
 
 
 	public Posicion (int fila, int columna) {
 		if (columna < 1 || columna > 8 || fila < 1 || fila > 8) {
			throw new IllegalArgumentException("La fila y la columna deben estar entre 1 y 8");
 		}else {
 		this.fila = fila;
 		this.columna= columna;
 		}
 	}
 	
 	public Posicion(char fila, char columna) {
        if ('A' <= columna && columna <= 'H') {
            this.columna = columna - 'A' + 1;
        } else {
            throw new IllegalArgumentException("La columna debe estar entra la A y la H");
        }
        if ('1' <= fila && fila <= '8') {
            this.fila = fila - '0';
        } else {
            throw new IllegalArgumentException("La fila debe estar entra el 1 y el 8");
        }
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
