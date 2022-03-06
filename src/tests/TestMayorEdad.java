package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import views.RegisterView;

class TestMayorEdad {

	@Test
	void MayorEdad() {
		
		System.out.println("************ Inicio Prueba Mayor�a de Edad ************");
		int edad1 = 15;
		int edad2 = -15;
		int edad3 = 18;
		int edad4 = 19;
		
		RegisterView register = new RegisterView();
		System.out.println("1� EDAD: " + edad1);
		System.out.println("2� EDAD: " + edad2);
		System.out.println("3� EDAD: " + edad3);
		System.out.println("4� EDAD: " + edad4);
		assertEquals(false, register.edadError(edad1));
		System.out.println("...");
		assertEquals(false, register.edadError(edad2));
		System.out.println("...");
		assertEquals(true, register.edadError(edad3));
		System.out.println("...");
		assertEquals(true, register.edadError(edad4));
		
		System.out.println("************ Fin Prueba Mayor�a de Edad ************");
	
	}

}
