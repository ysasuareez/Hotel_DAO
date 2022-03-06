package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import views.RegisterView;

class TestsDNI {

	@Test
	void longitudDNI() {
		
		/*
		 * Iniciamos las pruebas del m�todo que comprueba si un DNI es correcto o no.
		 * Creamos tres DNI distintos y vemos como el m�todo, rechaza o aprueba dichos DNI.
		 */
		
		System.out.println("************ Inicio Prueba DNI ************");
		String dni1 = "4523A";
		String dni2 = "76452344A";
		String dni3 = "452222311313A";
		
		RegisterView register = new RegisterView();
		System.out.println("1� DNI: " + dni1);
		System.out.println("2� DNI: " + dni2);
		System.out.println("3� DNI: " + dni3);
		assertEquals(true, register.dniError(dni1));
		System.out.println("...");
		assertEquals(false, register.dniError(dni2));
		System.out.println("...");
		assertEquals(true, register.dniError(dni3));
		
		System.out.println("************ Fin Prueba DNI ************");
	
	}
	
}
