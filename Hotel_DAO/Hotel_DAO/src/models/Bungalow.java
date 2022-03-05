package models;

public class Bungalow {
	// / / / / / / / / ATRIBUTOS
	public static enum Estado {
		Disponible, Ocupado
	}
	private Estado disponible;
	private String nombre;
	private int personas;
	private int habitaciones;
	private int baños;
	private double precio;
	
	// / / / / / / / / / / / / CONSTRUCTOR
	public Bungalow(Estado disponible, String nombre, int personas, int habitaciones, int baños, double precio) {
		this.disponible = Estado.Disponible;
		this.nombre = nombre;
		this.personas = personas;
		this.habitaciones = habitaciones;
		this.baños = baños;
		this.precio = precio;
	}

	// / / / / / / / / / / / / / / GETTERS Y SETTERS
	public Estado getDisponible() {
		return disponible;
	}

	public void setDisponible(Estado disponible) {
		this.disponible = disponible;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPersonas() {
		return personas;
	}

	public void setPersonas(int personas) {
		this.personas = personas;
	}

	public int getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	public int getBaños() {
		return baños;
	}

	public void setBaños(int baños) {
		this.baños = baños;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
