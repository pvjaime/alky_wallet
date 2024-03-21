package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import clases.CuentaBancariaBasica;

class CuentaBancariaBasicaTest {


	static CuentaBancariaBasica cuenta;
	
	@BeforeAll
	public static void setUpBeforeClass() {
	  cuenta = new CuentaBancariaBasica();
	  cuenta.depositar(399);
	}
	
	@Ignore ("Se ignora")
	@Test
	void test1() {
		int expected = 1;
		int actual = 1;
		assertEquals(expected, actual);
	}
	
	
	@Test
	void testNoRetiro() {
		System.out.println("testNoRetiro");
		//Caso donde el usuario no puede retirar
		boolean resultado = false;
		assertEquals(resultado, cuenta.retirar(200));		
	}
	
	@Test
	void testSiRetiro() {
		System.out.println("testSiRetiro");
		//Caso donde el usuario SI puede retirar
		boolean resultado = true;
		assertEquals(resultado, cuenta.retirar(200));
		
	}

}
