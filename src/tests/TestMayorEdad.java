package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import views.RegisterView;

class TestMayorEdad {

	@Test
	void MayorEdad() {
		
		/*
		 * Iniciamos las pruebas del método que comprueba si la edad del
		 * nuevo usuario es valida, para ello debe ser mayor de edad.
		 * Creamos cuatro edades distintas y comprobamos el resultado.
		 */
		
		System.out.println("************ Inicio Prueba Mayoría de Edad ************");
		int edad1 = 15;
		int edad2 = -15;
		int edad3 = 18;
		int edad4 = 19;
		
		RegisterView register = new RegisterView();
		System.out.println("1ª EDAD: " + edad1);
		System.out.println("2ª EDAD: " + edad2);
		System.out.println("3ª EDAD: " + edad3);
		System.out.println("4ª EDAD: " + edad4);
		assertEquals(false, register.edadError(edad1));
		System.out.println("...");
		assertEquals(false, register.edadError(edad2));
		System.out.println("...");
		assertEquals(true, register.edadError(edad3));
		System.out.println("...");
		assertEquals(true, register.edadError(edad4));
		
		System.out.println("************ Fin Prueba Mayoría de Edad ************");
	
	}

}
