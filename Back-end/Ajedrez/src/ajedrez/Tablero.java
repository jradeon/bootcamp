package ajedrez;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tablero implements Cloneable {

	private Pieza[][] piezas = new Pieza[8][8];

	public Pieza getEscaque(int columna, int fila) throws JuegoException { // dame pieza
				if (!(esValido(columna) && esValido(fila)))
					throw new JuegoException("La columna tiene que estar entre 0 y 8");
		return getEscaque(new Posicion(fila, columna));

	}

	public Pieza getEscaque(Posicion posicion) throws JuegoException {
		if (posicion == null)
			throw new IllegalArgumentException("Posicion null");
		if(!hayPieza(posicion))
			throw new JuegoException("No hay pieza en este escaque.");
		return piezas[posicion.getColumna()][posicion.getFila()];

	}

	public void setEscaque(int columna, int fila, Pieza pieza) throws JuegoException {
		// comprobar que la posicion es correcta, >- 0 && < 8
		if (!(esValido(columna) && esValido(fila)))
			throw new JuegoException("La posicion no es valida"); // Con el throw nos salimos del if y lanza excepción

		piezas[columna][fila] = pieza;

	}

	public void setEscaque(Posicion posicion, Pieza pieza) throws JuegoException {
		if (posicion == null)
			throw new IllegalArgumentException("Posicion null");
		setEscaque(posicion.getColumna(), posicion.getFila(), pieza);
	}

	private boolean esValido(int valido) {
		if (valido > 0 && valido < 8)
			return true;
		else
			return false;
	}

	// ************Hay Pieza****************
	public boolean hayPieza(int columna, int fila) throws JuegoException { // Validar
		if (!(esValido(columna) && esValido(fila)))
			throw new JuegoException("La columna y fila deben estar entre 0 y 8");
		if (piezas[columna][fila] != null) {
			return true;
		} else {
			return false;
		}

	}

	public boolean hayPieza(Posicion posicion) throws JuegoException {
		if (posicion == null)
			throw new IllegalArgumentException("Posicion null");
		if (piezas[posicion.getColumna()][posicion.getFila()] != null) {
			return true;
		} else {
			return false;
		}

	}

	// *************Quitar Pieza**************

	public void quitarPieza(int columna, int fila) throws JuegoException {
		if (!hayPieza(columna, fila))
			throw new IllegalArgumentException("El escaque ya estaba vacío.");
		else
			piezas[columna - 1][fila - 1] = null;

	}

	public void quitarPieza(Posicion posicion) throws JuegoException {
		if (posicion == null)
			throw new IllegalArgumentException("Posicion null");

		quitarPieza(posicion.getColumna(), posicion.getFila());

	}

	// *************Mover**************

	public void mover(Movimiento mover) throws JuegoException {
		if (mover == null)
			throw new IllegalArgumentException("Movimiento null");

		if (!hayPieza(mover.getPosini()))
			throw new JuegoException("No hay pieza para mover");

//						posicion								pieza
		setEscaque(mover.getPosfin(), getEscaque(mover.getPosini()));
		quitarPieza(mover.getPosini());

	}

	public Tablero clone() {
//		Arrays.copyOf(null, 0)
		Tablero tablero = new Tablero();
		tablero.piezas = this.piezas.clone();
		return tablero;

	}

	public Color colorEscaque(int columna, int fila) {
		if ((columna % 2) == (fila % 2)) {
			return Color.BLANCO;
		} else {
			return Color.NEGRO;
		}

	}

	public boolean hayPiezasEntre(Movimiento movimiento) throws JuegoException {
		if (!movimiento.esVertical() && !movimiento.esHorizontal() && !movimiento.esDiagonal())
			throw new IllegalArgumentException("No se puede realizar el movimiento");
		Posicion siguiente = new Posicion(movimiento.getPosini().getFila() + movimiento.deltaFila(),
				movimiento.getPosini().getColumna() + movimiento.deltaColumna());
		while (!siguiente.equals(movimiento.getPosfin())) {
			if (hayPieza(siguiente))
				return true;
			siguiente = new Posicion(siguiente.getFila() + movimiento.deltaFila(),
					siguiente.getColumna() + movimiento.deltaColumna());
		}
		return false;

	}

}
