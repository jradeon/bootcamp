package ajedrez;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PosicionTest {
	Posicion posicion1, posicion2, posicion3;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Nested
	class metodos {
		@Test
		void int_int() {
			assertAll("Posiciones validas", () -> assertEquals(2, new Posicion(2, 2).getFila()),
					() -> assertEquals(3, new Posicion(3, 3).getColumna()),
					() -> assertEquals(4, new Posicion(4, 4).getFila()),
					() -> assertEquals(5, new Posicion(5, 5).getColumna()),
					() -> assertEquals(6, new Posicion(6, 6).getFila()),
					() -> assertEquals(7, new Posicion(7, 7).getColumna()));
		}

		@Test
		void char_char() {
			assertAll("Posiciones validas", 
					() -> assertEquals(1, new Posicion('7', 'A').getColumna()),
					() -> assertEquals(8, new Posicion('7', 'H').getColumna()),
					() -> assertEquals(2, new Posicion('2', 'A').getFila()),
					() -> assertEquals(8, new Posicion('2', 'H').getColumna()),
					() -> assertEquals(5, new Posicion('5', 'D').getFila()));
		}

		@Test
		void int_int_Fallo() {
			assertAll("Posiciones invalidas",
					() -> assertThrows(IllegalArgumentException.class, () -> new Posicion(5, 16)),
					() -> assertThrows(IllegalArgumentException.class, () -> new Posicion(3, 0)),
					() -> assertThrows(IllegalArgumentException.class, () -> new Posicion(9, 7)),
					() -> assertThrows(IllegalArgumentException.class, () -> new Posicion(13, 9)));
		}

		@Test
		void char_char_Fallo() {
			assertAll("Posiciones invalidas",
					() -> assertThrows(IllegalArgumentException.class, () -> new Posicion('9', 'I')),
					() -> assertThrows(IllegalArgumentException.class, () -> new Posicion('4', 'J')),
					() -> assertThrows(IllegalArgumentException.class, () -> new Posicion('0', 'K')));
		}

		@Test
		void testEquals() throws JuegoException {
			posicion1 = new Posicion(6, 4);
			posicion2 = new Posicion('6', 'D');
			posicion3 = new Posicion(6, 3);

			assertAll("Comparacion", 
					() -> assertTrue(posicion1.equals(posicion2)),
					() -> assertTrue(posicion2.equals(posicion1)),
					() -> assertFalse(posicion3.equals(posicion1)),
					() -> assertFalse(posicion2.equals(posicion3)));
		}

	}
}
