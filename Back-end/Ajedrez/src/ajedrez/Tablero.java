package ajedrez;

import java.util.ArrayList;
import java.util.Arrays;
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

//32 piezas
//poner y quitar piezas, mover .. 

public class Tablero implements Cloneable {

	//private List<List<Pieza>> piezas = new ArrayList<List<Pieza>>();
	private Pieza[][] piezas = new Pieza[8][8];

	Tablero tablero = new Tablero();

	public Pieza getEscaque(int columna, int fila) { // dame pieza
		return piezas[columna][fila];

	}

	public Pieza getEscaque(Posicion posicion) {
		return piezas[posicion.getColumna()][posicion.getFila()];
		//return piezas.get(posicion.getColumna()).get(posicion.getFila());
	}
	
	public void setEscaque(int columna, int fila, Pieza pieza) throws JuegoException {
		//comprobar que la posicion es correcta, >- 0 && < 8
		if(!(esValido(columna) && esValido(fila)))
			throw new JuegoException("La posicion no es valida");
		
		if(hayPieza(columna, fila)) { //si la pieza es del otro color, la elimino y pongo la mia.
			
			if(getEscaque(columna,fila).getelColor()!= pieza.getelColor()) { // significa que la pieza no es mia
				quitarPieza(columna, fila);
				piezas[columna - 1][fila - 1] = pieza;
			}
			else { // //si la pieza que hay es de mi color --> no puedo hacer nada --> lanzo excepcion
				throw new JuegoException("Ya tienes una pieza en esa posicion");
				
			}
		} else {
			piezas[columna][fila] = pieza;
		}
		
	}

	private boolean esValido(int valido) {
		if (valido > 0 && valido < 8)
			return true;
		else
			return false;
	}

	// ************Hay Pieza****************
	public boolean hayPieza(int columna, int fila) {
		//return piezas.get(columna).get(fila) != null;
		if (piezas[columna][fila] != null) {
			return true;
		} else {
			return false;
		}
		
	}

	public boolean hayPieza(Posicion posicion) throws JuegoException {
		if (posicion == null)
			throw new NullPointerException("Posicion null");
		if (piezas[posicion.getColumna()][posicion.getFila()] != null) {
			return true;
		} else {
			return false;
		}

//		return piezas.get(posicion.getColumna()).get(posicion.getFila()) != null;
	}

	// *************Quitar Pieza**************

	public void quitarPieza(int columna, int fila) {
		if (!hayPieza(columna, fila))
			throw new NullPointerException("El escaque ya estaba vacío.");
		else
			piezas[columna - 1][fila - 1] = null;
//		piezas.get(columna).remove(fila);
	}

	public void quitarPieza(Posicion posicion) {
		if (posicion == null)
			throw new NullPointerException("Posicion null");

			quitarPieza(posicion.getColumna(), posicion.getFila());
		
//		piezas.get(posicion.getColumna()).remove(posicion.getFila());
	}

	// *************Mover**************

	public void mover(Movimiento mover) {
		if (mover == null)
			throw new NullPointerException("Movimiento null");

		if (piezas[mover.getPosini().getColumna()][mover.getPosini().getFila()] == null)
			throw new JuegoException("No hay pieza para mover");

//						posicion								pieza
		setEscaque(mover.getPosini(), getEscaque(mover.getPosini()));
		quitarPieza(mover.getPosini());

	}

	public Tablero clone() {
//		Arrays.copyOf(null, 0)
		return tablero.clone();

	}

	public Color colorEscaque(int columna, int fila) {
		if ((columna % 2) == (fila % 2)) {
			return Color.BLANCO;
		} else {
			return Color.NEGRO;
		}
		//piezas.get(columna).get(fila).getelColor();
		

	}

	public boolean hayPiezasEntre(Movimiento movimiento) {
		return false;

	}



}
