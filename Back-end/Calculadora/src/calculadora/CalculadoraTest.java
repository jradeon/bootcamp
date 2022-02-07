package calculadora;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraTest {
	Calculadora calc;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		 calc = new Calculadora();
		 
	}

	@AfterEach
	void tearDown() throws Exception {
	}


	
	@Test
	public void sumar(){
		
		int resultado = calc.sumar(2, 2);
		int esperado = 4; // 2+2=4
		assertEquals(esperado, resultado);
		
		//@ParameterizedTest(name = "{index}: num1+num2 --> {2}+{2} = {4}");		
	}
	
	@Test
	public void restar(){
		int resultado = calc.restar(2, 2);
		int esperado = 0; 
		assertEquals(esperado, resultado);	
	}
	
	
	@Test
	public void dividir(){
		int resultado = calc.dividir(6, 2);
		int esperado = 3; 
		assertEquals(esperado, resultado);
}
	
	



}
