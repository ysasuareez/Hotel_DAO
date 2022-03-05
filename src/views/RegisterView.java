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
import java.awt.Color;

public class RegisterView {

	private JFrame frame;
	private JTextField tfDNI;
	private JTextField tfNombre;
	private JTextField tfEdad;
	private JTextField tfUser;
	private JPasswordField passwordRegister;
	private JLabel lblDNI;
	private JLabel lblApellido;
	private JLabel lblRegistro;
	private JLabel lblNewLabel_4;
	private JLabel lblEdad;
	private JLabel lblUser;
	private JLabel lblContraseña;
	public JButton btnRegistrar;
	

	/**
	 * Create the application.
	 */
	public RegisterView() {
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
		
		lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setFont(new Font("SimSun-ExtB", Font.BOLD, 22));
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setBounds(100, 0, 223, 34);
		frame.getContentPane().add(lblRegistro);
		
		tfDNI = new JTextField();
		tfDNI.setBounds(119, 70, 86, 20);
		frame.getContentPane().add(tfDNI);
		tfDNI.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(119, 116, 86, 20);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		lblDNI = new JLabel("DNI");
		lblDNI.setForeground(new Color(0, 0, 255));
		lblDNI.setBackground(new Color(0, 0, 255));
		lblDNI.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDNI.setBounds(40, 73, 69, 14);
		frame.getContentPane().add(lblDNI);
		
		lblApellido = new JLabel("Nombre y");
		lblApellido.setForeground(new Color(0, 0, 255));
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setBounds(12, 116, 97, 20);
		frame.getContentPane().add(lblApellido);
		
		lblNewLabel_4 = new JLabel("apellidos");
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(12, 132, 97, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		tfEdad = new JTextField();
		tfEdad.setBounds(311, 70, 86, 20);
		frame.getContentPane().add(tfEdad);
		tfEdad.setColumns(10);
		
		tfUser = new JTextField();
		tfUser.setBounds(311, 116, 86, 20);
		frame.getContentPane().add(tfUser);
		tfUser.setColumns(10);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setForeground(new Color(0, 0, 255));
		lblEdad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEdad.setBounds(215, 73, 86, 14);
		frame.getContentPane().add(lblEdad);
		
		lblUser = new JLabel("Usuario");
		lblUser.setForeground(new Color(0, 0, 255));
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setBounds(208, 119, 93, 14);
		frame.getContentPane().add(lblUser);
		
		passwordRegister = new JPasswordField();
		passwordRegister.setBounds(119, 165, 86, 20);
		frame.getContentPane().add(passwordRegister);
		
		lblContraseña = new JLabel("Contrase\u00F1a");
		lblContraseña.setForeground(new Color(0, 0, 255));
		lblContraseña.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContraseña.setBounds(16, 168, 93, 14);
		frame.getContentPane().add(lblContraseña);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(0, 0, 139));
		btnRegistrar.setForeground(new Color(224, 255, 255));
		btnRegistrar.setFont(new Font("DejaVu Serif", Font.BOLD, 12));
		btnRegistrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int edad = 0;
				String username = tfUser.getText();
				String password = new String(passwordRegister.getPassword());
				String nombre = tfNombre.getText();
				edad = Integer.parseInt(tfEdad.getText());
				String dni = tfDNI.getText();
				
				
																															@SuppressWarnings("unused")
				boolean mayorEdad = edadError(edad);
				if(mayorEdad = true) {
																															@SuppressWarnings("unused")
					boolean dniErrorFound = dniError(dni);
					if(dniErrorFound = false) {
					Usuario u1 = new Usuario(username, password, nombre, edad, dni);
					Usuario.users.add(u1);
					JOptionPane.showMessageDialog(btnRegistrar, "Registrado correctamente");
					
					new LoginView();
					frame.dispose();
					} else {
						JOptionPane.showMessageDialog(btnRegistrar, "Introduzca un DNI válido");
					}
				} else if(mayorEdad = false) {
					JOptionPane.showMessageDialog(btnRegistrar, "Introduce una edad válida (debes ser mayor de 18)");
				}
			}	
			
				// / / / / / / / / / MÉTODO PARA CONTROL DE ERRORES EN LA EDAD / / / / / / / / 
				public boolean edadError(int edad) {
					boolean mayorEdad = false;
					if(edad < 18 && edad > 0) {
						mayorEdad = false;
					} else {
						mayorEdad = true;
					}
				return mayorEdad;
			}
				
				// / / / / / / / / / MÉTODO PARA CONTROL DE ERRORES EN EL DNI / / / / / / / / / /
				public boolean dniError(String dni) {
					boolean dniError = true;
					if(dni.length() == 9) {
						dniError = false;
					} else {
						dniError = true;
					}
					return dniError;
				}
			
			
		});
		btnRegistrar.setBounds(297, 165, 115, 34);
		frame.getContentPane().add(btnRegistrar);
	}
}
