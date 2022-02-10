package ajedrez;

//- posIni: Posicion
//- posFin: Posicion
//+ New(String)
//+ «property» PosicionInicial() : Posicion
//+ «property» PosicionFinal() : Posicion
//+ EsVertical() : Boolean
//+ EsHorizontal() : Boolean
//+ EsDiagonal() : Boolean
//+ SaltoVertical() : Integer
//+ SaltoHorizontal() : Integer
//+ deltaFila() : Integer
//+ deltaColumna() : Integer

public class Movimiento {

	private Posicion posini;
	private Posicion posfin;

	public Movimiento(Posicion posini, Posicion posfin) throws JuegoException {
		if (posini == null)
			throw new JuegoException("Posición inicial tiene que ser distinta de nulo");
		if (posfin == null)
			throw new JuegoException("Posición inicial tiene que ser distinta de nulo");
		if (posini.equals(posfin)) { // comparamos posiciones
			throw new JuegoException("Posición inicial tiene que ser distinta a la final");
		}

		this.posini = posini;
		this.posfin = posfin;
	}

	public Posicion getPosini() {
		return posini;
	}

	public Posicion getPosfin() {
		return posfin;
	}

	public boolean esVertical() { // cambia la fila
		return posini.getColumna() == posfin.getColumna();
	}

	public boolean esHorizontal() { // cambia la columna
		if (posini.getFila() == posfin.getFila()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean esDiagonal() { // si el desplazamiento fila columna es igual
		return saltoVertical() == saltoHorizontal();
	}

	public int saltoVertical() { // diferencia de filas fila inicial - fila final o columna inicial- columna
									// final
		
		return Math.abs(posini.getFila()-posfin.getFila());
	}

	public int saltoHorizontal() {
		return Math.abs(posini.getColumna()-posfin.getColumna());
	}

	public int deltaFila() {
		if (posfin.getColumna() > posini.getColumna()) return 1;
		else if (posfin.getColumna() == posini.getColumna()) return 0;
		else if (posfin.getColumna() < posini.getColumna()) return -1;
	}

	public int deltaColumna() {
		if (posfin.getFila() > posini.getFila()) return 1;
		else if (posfin.getFila() == posini.getFila()) return 0;
		else if (posfin.getFila() < posini.getFila()) return -1;
	}

}