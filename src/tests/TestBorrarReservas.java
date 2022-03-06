package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import models.Bungalow;
import models.Bungalow.Estado;
import views.ReservaView;

class TestBorrarReservas {

	@Test
	void borrarReservas() {
		
		/*
		 * Iniciamos el método que devolverá true o false dependiendo de si existen bungalows ocupados
		 * o no y así poder informar al usuario de que tiene o no reservas para cancelar.
		 */
		ReservaView r = new ReservaView(0);

		ArrayList<Bungalow> bungalows = new ArrayList<Bungalow>();
		bungalows.add(new Bungalow(Estado.Disponible, "Zeus", 4, 5, 3, 200));
		bungalows.add(new Bungalow(Estado.Ocupado, "Poseidon", 4, 4, 3, 180));
		bungalows.add(new Bungalow(Estado.Disponible, "Hades", 4, 3, 3, 165));
		bungalows.add(new Bungalow(Estado.Ocupado, "Ares", 4, 5, 4, 225));
		bungalows.add(new Bungalow(Estado.Disponible, "Cronos", 4, 4, 2, 170));
		
		assertTrue(r.limpiarReservas(bungalows));
		
		
		ArrayList<Bungalow> bungalows2 = new ArrayList<Bungalow>();
		bungalows2.add(new Bungalow(Estado.Disponible, "Zeus", 4, 5, 3, 200));
		bungalows2.add(new Bungalow(Estado.Disponible, "Poseidon", 4, 4, 3, 180));
		bungalows2.add(new Bungalow(Estado.Disponible, "Hades", 4, 3, 3, 165));
		bungalows2.add(new Bungalow(Estado.Ocupado, "Ares", 4, 5, 4, 225));
		bungalows2.add(new Bungalow(Estado.Disponible, "Cronos", 4, 4, 2, 170));
		
		assertTrue(r.limpiarReservas(bungalows2));
		
		
		ArrayList<Bungalow> bungalows3 = new ArrayList<Bungalow>();
		bungalows3.add(new Bungalow(Estado.Disponible, "Zeus", 4, 5, 3, 200));
		bungalows3.add(new Bungalow(Estado.Disponible, "Poseidon", 4, 4, 3, 180));
		bungalows3.add(new Bungalow(Estado.Disponible, "Hades", 4, 3, 3, 165));
		bungalows3.add(new Bungalow(Estado.Disponible, "Ares", 4, 5, 4, 225));
		bungalows3.add(new Bungalow(Estado.Disponible, "Cronos", 4, 4, 2, 170));
		
		assertFalse(r.limpiarReservas(bungalows3));
		
	}

}
