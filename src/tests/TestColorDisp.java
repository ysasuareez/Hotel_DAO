package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.Bungalow;
import models.Bungalow.Estado;
import views.ReservaView;

class TestColorDisp {

	@Test
	void Color() {
		
		/*Iniciamos las pruebas del metodo que cambia el color de la disponibilidad en el JPanel
		 * de la view dependiendo de si está disponible o no. Creamos un bungalow y cambiamos sus 
		 * estados a ver si cambia para comprobar si cambia también  el color del texto que se imprime.
		 */
		System.out.println("************ Inicio Prueba Estado ************");
		Bungalow b = new Bungalow(Estado.Disponible, "Zeus", 4, 5, 3, 200);
		Estado check = b.getDisponible();
		ReservaView r = new ReservaView(1);
		
		
		assertEquals("Verde", r.colorCheck(b, check));
		System.out.println("...");
		b.setDisponible(Estado.Ocupado);
		check = b.getDisponible();
		assertEquals("Rojo", r.colorCheck(b, check));
		System.out.println("...");

				
		System.out.println("************ Fin Prueba Estado ************");
	
	}

}
