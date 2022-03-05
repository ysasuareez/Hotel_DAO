package views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import models.Usuario;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;

public class LoginView {

	private JFrame frame;
	private JTextField tfUserLogin;
	private JPasswordField passwordLogin;
	private JLabel lblContraseñaLogin;
	private JLabel lblLogin;
	private JLabel lblUserLogin;
	private JButton btnLogin;
	private JButton btnRegister;
	

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblLogin = new JLabel("LOGIN");
		lblLogin.setBackground(UIManager.getColor("FileChooser.listViewBackground"));
		lblLogin.setFont(new Font("SimSun-ExtB", Font.BOLD, 22));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(0, 0, 434, 44);
		frame.getContentPane().add(lblLogin);
		
		tfUserLogin = new JTextField();
		tfUserLogin.setBounds(181, 94, 186, 25);
		frame.getContentPane().add(tfUserLogin);
		tfUserLogin.setColumns(10);
		
		lblUserLogin = new JLabel("Usuario:");
		lblUserLogin.setForeground(new Color(0, 0, 255));
		lblUserLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUserLogin.setBounds(113, 94, 58, 25);
		frame.getContentPane().add(lblUserLogin);
		
		passwordLogin = new JPasswordField();
		passwordLogin.setBounds(181, 147, 186, 25);
		frame.getContentPane().add(passwordLogin);
		
		lblContraseñaLogin = new JLabel("Contrase\u00F1a:");
		lblContraseñaLogin.setForeground(new Color(0, 0, 255));
		lblContraseñaLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContraseñaLogin.setBounds(89, 146, 75, 25);
		frame.getContentPane().add(lblContraseñaLogin);
		
		btnLogin = new JButton("Entrar");
		btnLogin.setForeground(new Color(224, 255, 255));
		btnLogin.setFont(new Font("DejaVu Serif", Font.BOLD, 11));
		btnLogin.setBackground(new Color(0, 0, 139));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String entradaUser = tfUserLogin.getText();
				String entradaPassword = String.valueOf(passwordLogin.getPassword());
				boolean encontrado = false;
				for (int i = 0; i < Usuario.users.size(); i++) {
					Usuario u = Usuario.users.get(i);
				  if(u.getUsername().equals(entradaUser) && u.getPassword().equals(entradaPassword)) {
					  encontrado = true;
					  break;
				  }
				} if(encontrado) {
					JOptionPane.showMessageDialog(btnLogin, "Login correcto");
					new ReservaView(0);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(btnLogin, "Usuario y/o contraseña incorrecto");
				}
			}
			
		});
		
		btnLogin.setBounds(244, 211, 99, 23);
		frame.getContentPane().add(btnLogin);
		
		btnRegister = new JButton("Registrarse");
		btnRegister.setForeground(new Color(224, 255, 255));
		btnRegister.setFont(new Font("DejaVu Serif", Font.BOLD, 11));
		btnRegister.setBackground(new Color(0, 0, 139));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterView();
				frame.dispose();
			}
		});
		btnRegister.setBounds(72, 211, 132, 23);
		frame.getContentPane().add(btnRegister);
	}
}
