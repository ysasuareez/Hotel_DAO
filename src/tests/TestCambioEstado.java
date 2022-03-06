package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import javax.swing.JLabel;

import org.junit.jupiter.api.Test;

import models.Bungalow;
import models.Bungalow.Estado;
import views.RegisterView;
import views.ReservaView;

class TestCambioEstado {

	@Test
	void Estado() {
		
		/*Iniciamos las pruebas del metodo que cambia la disponibilidad en el JPanel
		 * de la view. Creamos dos bungalow y cambiamos sus estados para comprobar si 
		 * cambia también el texto que se imprime.
		 */
		System.out.println("************ Inicio Prueba Estado ************");
		Bungalow b = new Bungalow(Estado.Disponible, "Zeus", 4, 5, 3, 200);
		Estado check = b.getDisponible();
		ReservaView r = new ReservaView(1);
		
		
		assertEquals("DISPONIBLE", r.checkedReserva(b, check));
		System.out.println("...");
		b.setDisponible(Estado.Ocupado);
		check = b.getDisponible();
		assertEquals("NO DISPONIBLE", r.checkedReserva(b, check));
		System.out.println("...");
		
		
		Bungalow b2 = new Bungalow(Estado.Ocupado, "Zeus", 4, 5, 3, 200);
		Estado check2 = b.getDisponible();		
		
		assertEquals("NO DISPONIBLE", r.checkedReserva(b2, check2));
		System.out.println("...");
		b2.setDisponible(Estado.Disponible);
		check2 = b2.getDisponible();
		assertEquals("DISPONIBLE", r.checkedReserva(b2, check2));
		System.out.println("...");

				
		System.out.println("************ Fin Prueba Estado ************");
	
	}

}
