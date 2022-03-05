package models;

import java.util.ArrayList;

public class Usuario {
	// / / / / / / / / ATRIBUTOS
	public String username;
	public String password;
	public String nombre;
	public int edad;
	public String DNI;
	
				// / / / / / / / / CONSTRUCTOR		
	public Usuario(String username, String password, String nombre, int edad, String DNI) {
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.edad = edad;
		this.DNI = DNI;
	}

	
				// / / / / / GETTERS Y SETTERS	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}
	
	public static ArrayList<Usuario> users = new ArrayList<Usuario>();
	
}


