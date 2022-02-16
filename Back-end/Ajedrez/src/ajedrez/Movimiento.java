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

	public Movimiento(String jugada) throws JuegoException {
		if (jugada == null || jugada.length() != 4)
			throw new JuegoException("Posición inicial tiene que ser distinta de nulo");
		//  jugada b1c4
		this.posini = new Posicion(jugada.charAt(1), jugada.charAt(0));
		this.posfin = new Posicion(jugada.charAt(3), jugada.charAt(2));;
		if (posini.equals(posfin)) { // comparamos posiciones
			throw new JuegoException("Posición inicial tiene que ser distinta a la final");
		}

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
		return posini.getFila() == posfin.getFila();
	}

	public boolean esDiagonal() { // si el desplazamiento fila columna es igual
		return saltoVertical() == saltoHorizontal();
	}

	public int saltoVertical() { // diferencia de filas fila inicial - fila final o columna inicial- columna
									// final

		return Math.abs(posini.getFila() - posfin.getFila());
	}

	public int saltoHorizontal() {
		return Math.abs(posini.getColumna() - posfin.getColumna());
	}

	public int deltaFila() { // para saber si se mueve positivo o negativo
		int mov = 0;
		if (posfin.getColumna() > posini.getColumna())
			mov = 1;
		else if (posfin.getColumna() == posini.getColumna())
			mov = 0;
		else if (posfin.getColumna() < posini.getColumna())
			mov = -1;
		return mov;
	}

	public int deltaColumna() {
		int mov2 = 0;
		if (posfin.getFila() > posini.getFila())
			mov2 = 1;
		else if (posfin.getFila() == posini.getFila())
			mov2 = 0;
		else if (posfin.getFila() < posini.getFila())
			mov2 = -1;
		return mov2;
	}

}