package ajedrez;

import java.util.ArrayList;
import java.util.List;

//- piezas(8,8): Pieza

//«property» Escaque(Integer, Integer) : Pieza
//+ «property» Escaque(Posicion) : Pieza
//- esValido(Integer) : Boolean
//+ HayPieza(Integer, Integer) : Boolean
//+ HayPieza(Posicion) : Boolean
//+ QuitaPieza(Integer, Integer)
//+ QuitaPieza(Posicion)
//+ Mover(Movimiento)
//+ Clone() : Object
//+ ColorEscaque(Integer, Integer) : Color
//+ HayPiezasEntre(Movimiento) : Boolean

public class Tablero implements Cloneable {

	private List<Pieza> pieza = new ArrayList<Pieza>();

	public Pieza getEscaque (int a, int b) {
		return null;
	}

	public void setEscaque (int a, int b, Pieza p) {
		
	}


	public void escaque(Posicion posicion) {
	
	}
	
	private boolean esValido (int t) {
		return false;
	}
	
	//************Hay Pieza****************
	public boolean hayPieza (int c, int d) {
		return false;
	}
	
	public void hayPieza (Posicion posicion) {
		
	}
	
	//*************Quitar Pieza**************
	
	public void quitarPieza (int e, int f) {
		
	}
	
	public void quitarPieza(Posicion posicion) {
		
	}
	
	//*************Mover**************

	public List<Pieza> getPieza() {
		return pieza;
	}

	public void setPieza(List<Pieza> pieza) {
		this.pieza = pieza;
	}

}
