package mainapp;

import models.Usuario;
import views.LoginView;

public class MainApp {

	public static void main(String[] args) {
		new LoginView();
		Usuario usuario = new Usuario("r", "r", "a", 20, "2456345");
		Usuario.users.add(usuario);
	}
}
