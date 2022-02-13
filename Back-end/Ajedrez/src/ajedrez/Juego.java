package ajedrez;

import java.util.ArrayList;
import java.util.List;

public class Juego {

	private Tablero tablero = new Tablero();
	private Color elTurno;
	private boolean partidaActiva = false;

	public void inicializar() throws JuegoException {

		tablero.setEscaque(1, 1, new Torre(Color.BLANCO));
		tablero.setEscaque(2, 1, new Caballo(Color.BLANCO));
		tablero.setEscaque(3, 1, new Alfil(Color.BLANCO));
		tablero.setEscaque(4, 1, new Dama(Color.BLANCO));
		tablero.setEscaque(5, 1, new Rey(Color.BLANCO));
		tablero.setEscaque(6, 1, new Alfil(Color.BLANCO));
		tablero.setEscaque(7, 1, new Caballo(Color.BLANCO));
		tablero.setEscaque(8, 1, new Torre(Color.BLANCO));
		tablero.setEscaque(1, 2, new Peon(Color.BLANCO));
		tablero.setEscaque(2, 2, new Peon(Color.BLANCO));
		tablero.setEscaque(3, 2, new Peon(Color.BLANCO));
		tablero.setEscaque(4, 2, new Peon(Color.BLANCO));
		tablero.setEscaque(5, 2, new Peon(Color.BLANCO));
		tablero.setEscaque(6, 2, new Peon(Color.BLANCO));
		tablero.setEscaque(7, 2, new Peon(Color.BLANCO));
		tablero.setEscaque(8, 2, new Peon(Color.BLANCO));

		tablero.setEscaque(1, 8, new Torre(Color.NEGRO));
		tablero.setEscaque(2, 8, new Caballo(Color.NEGRO));
		tablero.setEscaque(3, 8, new Alfil(Color.NEGRO));
		tablero.setEscaque(4, 8, new Dama(Color.NEGRO));
		tablero.setEscaque(5, 8, new Rey(Color.NEGRO));
		tablero.setEscaque(6, 8, new Alfil(Color.NEGRO));
		tablero.setEscaque(7, 8, new Caballo(Color.NEGRO));
		tablero.setEscaque(8, 8, new Torre(Color.NEGRO));
		tablero.setEscaque(1, 7, new Peon(Color.NEGRO));
		tablero.setEscaque(2, 7, new Peon(Color.NEGRO));
		tablero.setEscaque(3, 7, new Peon(Color.NEGRO));
		tablero.setEscaque(4, 7, new Peon(Color.NEGRO));
		tablero.setEscaque(5, 7, new Peon(Color.NEGRO));
		tablero.setEscaque(6, 7, new Peon(Color.NEGRO));
		tablero.setEscaque(7, 7, new Peon(Color.NEGRO));
		tablero.setEscaque(8, 7, new Peon(Color.NEGRO));

		partidaActiva = true;
		elTurno = Color.BLANCO;

	}

	public Color getElTurno() throws JuegoException {
		if(!partidaActiva)
			throw new JuegoException("La partida aun no ha comenzado.");
		return elTurno;
	}

	public Tablero getTablero() throws JuegoException {
		if(!partidaActiva)
			throw new JuegoException("La partida aun no ha comenzado.");
		return (Tablero) tablero.clone();
	}

}