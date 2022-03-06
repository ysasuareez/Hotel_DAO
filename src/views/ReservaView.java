package views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import models.Bungalow;
import models.Bungalow.Estado;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("unused")
public class ReservaView {

	private int indexVista;
	private JFrame frame;
	private JLabel lblTitulo;
	private JLabel lblNombre;
	private JLabel lblPersonas;
	private JLabel lblHabitaciones;
	private JLabel lblBaños;
	private JLabel lblPrecio;
	private JLabel lblDisponibilidad;
	private JButton btnReservar;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private Bungalow b = new Bungalow(null, null, indexVista, indexVista, indexVista, indexVista);
	private String textCheck = "DISPONIBLE";
	private JButton btnAnularReservas;

	/**
	 * Create the application.
	 */
	public ReservaView(int indexVista) {
		initialize();
		this.indexVista = indexVista;
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
		
	// / / / / / / / / / / / / ARRAYLIST DE BUNGALOWS Y ADICCIÓN DE ELLOS AL ARRAY / / / / / / / /
		ArrayList<Bungalow> bungalows = new ArrayList<Bungalow>();
		bungalows.add(new Bungalow(Estado.Disponible, "Zeus", 4, 5, 3, 200));
		bungalows.add(new Bungalow(Estado.Disponible, "Poseidon", 4, 4, 3, 180));
		bungalows.add(new Bungalow(Estado.Disponible, "Hades", 4, 3, 3, 165));
		bungalows.add(new Bungalow(Estado.Disponible, "Ares", 4, 5, 4, 225));
		bungalows.add(new Bungalow(Estado.Disponible, "Cronos", 4, 4, 2, 170));
		bungalows.add(new Bungalow(Estado.Disponible, "Afrodita", 2, 1, 1, 100));
		bungalows.add(new Bungalow(Estado.Disponible, "Apolo", 2, 1, 2, 110));
		bungalows.add(new Bungalow(Estado.Disponible, "Baco", 2, 2, 3, 150));
		bungalows.add(new Bungalow(Estado.Disponible, "Aquiles", 2, 2, 2, 135));
		bungalows.add(new Bungalow(Estado.Disponible, "Cupido", 2, 1, 1, 120));
		
		// / / / / / / / / / DATOS A MOSTRAR DE LOS BUNGALOWS / / / / / / / /
		Bungalow bungalowVista = bungalows.get(indexVista);
		lblTitulo = new JLabel("RESERVAR");
		lblTitulo.setFont(new Font("SimSun-ExtB", Font.BOLD, 22));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(120, 11, 170, 36);
		frame.getContentPane().add(lblTitulo);
		
		lblNombre = new JLabel("Casa " + bungalowVista.getNombre());
		lblNombre.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 18));
		lblNombre.setBounds(10, 53, 155, 24);
		frame.getContentPane().add(lblNombre);
		
		lblPersonas = new JLabel(bungalowVista.getPersonas() + " personas");
		lblPersonas.setFont(new Font("Georgia", Font.BOLD, 16));
		lblPersonas.setBounds(10, 99, 131, 24);
		frame.getContentPane().add(lblPersonas);
		
		lblHabitaciones = new JLabel(bungalowVista.getHabitaciones() + " habitaciones");
		lblHabitaciones.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblHabitaciones.setBounds(10, 134, 131, 24);
		frame.getContentPane().add(lblHabitaciones);
		
		lblBaños = new JLabel(bungalowVista.getBaños() + " baños");
		lblBaños.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblBaños.setBounds(10, 169, 131, 24);
		frame.getContentPane().add(lblBaños);
		
		lblPrecio = new JLabel(bungalowVista.getPrecio() + " €");
		lblPrecio.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblPrecio.setBounds(10, 204, 131, 24);
		frame.getContentPane().add(lblPrecio);
		
		lblDisponibilidad = new JLabel("DISPONIBLE");
		lblDisponibilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisponibilidad.setFont(new Font("Sylfaen", Font.BOLD, 25));
		lblDisponibilidad.setForeground(Color.GREEN);
		lblDisponibilidad.setBounds(203, 53, 221, 46);
		lblDisponibilidad.setText("DISPONIBLE");
		lblDisponibilidad.setText(textCheck);
		frame.getContentPane().add(lblDisponibilidad);
		
		b = bungalows.get(indexVista);
		
		btnReservar = new JButton("Reservar");
		btnReservar.setForeground(new Color(224, 255, 255));
		btnReservar.setBackground(new Color(0, 0, 139));
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bungalow b = bungalows.get(indexVista);
				if(b.getDisponible().equals(Estado.Disponible)) {
					b.setDisponible(Estado.Ocupado);
					JOptionPane.showMessageDialog(btnReservar, "¡Reserva realizada! El horario de entrada del hotel es antes de las 18h, y de salida antes de las 13h.");
					Estado check = b.getDisponible();
					checkedReserva(b, check);
					
					// comprobación método color label disponibilidad
					String color = colorCheck(b, check);
					if(color.equals("Rojo")) {
						lblDisponibilidad.setForeground(Color.RED);
					} else if(color.equals("Verde")) {
						lblDisponibilidad.setForeground(Color.GREEN);
					}
					
					lblDisponibilidad.setText(textCheck);
				} else {
					JOptionPane.showMessageDialog(btnReservar, "Reserva no disponible: bungalow ocupado");
				}
			}
		});
		
		btnReservar.setFont(new Font("DejaVu Serif", Font.BOLD, 12));
		btnReservar.setBounds(287, 193, 125, 46);
		frame.getContentPane().add(btnReservar);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.setFont(new Font("DejaVu Serif", Font.BOLD, 12));
		btnAnterior.setForeground(new Color(224, 255, 255));
		btnAnterior.setBackground(new Color(0, 0, 139));
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(indexVista>0) {
					indexVista --;
					Bungalow b = bungalows.get(indexVista);
					lblNombre.setText("Casa " + b.getNombre());
					lblPersonas.setText(String.valueOf(b.getPersonas()) + " personas");
					lblHabitaciones.setText(String.valueOf(b.getHabitaciones()) + " habitaciones");
					lblBaños.setText(String.valueOf(b.getBaños()) + " baños");
					lblPrecio.setText(String.valueOf(b.getPrecio()) + " €");
					Estado check = b.getDisponible();
					checkedReserva(b, check);
					
					// comprobación método color label disponibilidad
					String color = colorCheck(b, check);
					if(color.equals("Rojo")) {
						lblDisponibilidad.setForeground(Color.RED);
					} else if(color.equals("Verde")) {
						lblDisponibilidad.setForeground(Color.GREEN);
					}
					
					lblDisponibilidad.setText(textCheck);
				}
			}
		});
		
		btnAnterior.setBounds(203, 110, 99, 23);
		frame.getContentPane().add(btnAnterior);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("DejaVu Serif", Font.BOLD, 12));
		btnSiguiente.setForeground(new Color(224, 255, 255));
		btnSiguiente.setBackground(new Color(0, 0, 139));
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(indexVista<9) {
					indexVista ++;
					Bungalow b = bungalows.get(indexVista);
					lblNombre.setText("Casa " + b.getNombre());
					lblPersonas.setText(String.valueOf(b.getPersonas()) + " personas");
					lblHabitaciones.setText(String.valueOf(b.getHabitaciones()) + " habitaciones");
					lblBaños.setText(String.valueOf(b.getBaños()) + " baños");
					lblPrecio.setText(String.valueOf(b.getPrecio()) + " €");
					Estado check = b.getDisponible();
					checkedReserva(b, check);
					
					// comprobación método color label disponibilidad
					String color = colorCheck(b, check);
					if(color.equals("Rojo")) {
						lblDisponibilidad.setForeground(Color.RED);
					} else if(color.equals("Verde")) {
						lblDisponibilidad.setForeground(Color.GREEN);
					}
					
					lblDisponibilidad.setText(textCheck);
				}
			}
		});
		btnSiguiente.setBounds(313, 110, 99, 23);
		frame.getContentPane().add(btnSiguiente);
		
		JButton btnCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnCerrarSesion, "Has cerrado sesión, volverás a la pantalla del login");
				new LoginView();
				frame.dispose();
			}
		});
		btnCerrarSesion.setBackground(new Color(51, 0, 153));
		btnCerrarSesion.setForeground(new Color(204, 255, 255));
		btnCerrarSesion.setFont(new Font("Dialog", Font.BOLD, 12));
		btnCerrarSesion.setBounds(120, 216, 125, 23);
		frame.getContentPane().add(btnCerrarSesion);
		
		btnAnularReservas = new JButton("Anular reservas");
		btnAnularReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean bungalowsOcupados = limpiarReservas(bungalows);
				if(bungalowsOcupados == true) {
					JOptionPane.showMessageDialog(btnCerrarSesion, "Has anulado todas las reservas realizadas en esta sesión");
					new ReservaView(0);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(btnCerrarSesion, "Error: no hay ninguna reserva realizada aún");
				}
			}
		});
		btnAnularReservas.setForeground(new Color(204, 255, 255));
		btnAnularReservas.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAnularReservas.setBackground(new Color(51, 0, 153));
		btnAnularReservas.setBounds(250, 145, 131, 23);
		frame.getContentPane().add(btnAnularReservas);
		
	}
	
	/* / / / / / / / / / / /   DEVUELVE EL VALOR DEL TEXTO DE DISPONIBILIDAD,
								DEPENDIENDO DEL ESTADO  */
	public String checkedReserva(Bungalow b, Estado check) {
		String textCheck = null;
		if(check.equals(Estado.Ocupado)) {
			lblDisponibilidad.setForeground(Color.RED);
			textCheck = "NO DISPONIBLE";
		} else if (check.equals(Estado.Disponible)){
			lblDisponibilidad.setForeground(Color.GREEN);
			textCheck = "DISPONIBLE";
		}
		return textCheck;
	}
	
	// / / / / / / / / CAMBIA EL COLOR DEL LABEL DE DISPONIBILIDAD
	public String colorCheck(Bungalow b, Estado check) {
		String colourCheck = null;
		if(check.equals(Estado.Ocupado)) {
			colourCheck = "Rojo";
		} else if (check.equals(Estado.Disponible)){
			colourCheck = "Verde";
		}
		
		return colourCheck;
		
	}
	
	
	/* RECORRE EL ARRAY DE BUNGALOWS: DEVUELVE "FALSE" SI NO HAY NINGÚN BUNGALOW OCUPADO
	 * PARA QUE ARRIBA, EL PROGRAMA IMPRIMA UN MENSAJE DE ERROR, YA QUE TODOS LOS
	 * BUNGALOWS ESTÁN DISPONIBLES. DEVUELVE "TRUE" SI HAY AL MENOS UN BUNGALOW OCUPADO, Y EL PROGRAMA RESETEA
	 * LA VISTA PARA LIMPIAR LAS RESERVAS.
	 */
	public boolean limpiarReservas(ArrayList<Bungalow> bungalows) {
		for (int i=0; i<bungalows.size(); i++) {
			Bungalow b = bungalows.get(i);
			if(b.getDisponible().equals(Estado.Ocupado)) {
				return true;
			}
		}
		
		return false;
		
	}
}