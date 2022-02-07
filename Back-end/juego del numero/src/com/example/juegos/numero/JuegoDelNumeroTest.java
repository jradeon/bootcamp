package com.example.juegos.numero;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class JuegoDelNumeroTest {
	JuegoDelNumero juego;

	@BeforeEach
	void setUp() throws Exception {
		juego = new JuegoDelNumero(); // instanciamos el atributo juego y creamos el objeto
		juego.numeroBuscado = 50;
	}

	@Test
	void test_Constructor() {
		assertNotNull(new JuegoDelNumero());
	}

	@Test
	void testInicializar() {
		juego.numeroBuscado = -1;
		juego.inicializar();
		assertAll("Inicializar", () -> assertEquals("Pendiente de empezar", juego.getResultado()),
				() -> assertEquals(0, juego.getJugada()),
				() -> assertTrue(0 < juego.numeroBuscado && juego.numeroBuscado <= 100, "rango entre 1 y 100"));
	}

	@Nested
	class jugadas {
		@Test
		void test_es_mayor() throws JuegoException {
			juego.jugada(51);
			assertAll("Jugada", () -> assertEquals("Mi número es menor.", juego.getResultado()),
					() -> assertEquals(1, juego.getJugada()));

		}

		@Test
		void test_es_menor() throws JuegoException {
			juego.jugada(49);
			assertAll("Jugada", () -> assertEquals("Mi número es mayor.", juego.getResultado()),
					() -> assertEquals(1, juego.getJugada()));

		}

		@Test
		void test_es_igual() throws JuegoException {
			juego.jugada(50);
			assertAll("Jugada", () -> assertEquals("Bieeen!!! Acertaste.", juego.getResultado()),
					() -> assertEquals(1, juego.getJugada()));
		}
		
		@Test
		void test_Hasperdido() throws JuegoException {
			
		}
			
		}
	

	@Test
	void testJugadaInt() {

		
	}

	@Test
	void testGetResultado() {

	}

	@Test
	void testGetFinalizado() {

	}

	@Test
	void testGetJugada() {

	}

}

