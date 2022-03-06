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
		 * de la view. Creamos un bungalow y cambiamos sus estados a ver si cambia 
		 * tambi�n el texto que se imprime.
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

				
		System.out.println("************ Fin Prueba Estado ************");
	
	}

}
