package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import logica.Apostador;
import logica.Apuesta;
import logica.Caballo;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
/*
 * Clase de la interfaz grafica del juego, donde se ejecuta todo el proyecto e inicia el juego hasta el final.
 */
public class JuegoApp {

	// Variables propias de la interfaz grafica
	private JFrame frame;
	private JTextArea taresultados;
	private JTextField tfjugador1;
	private JTextField tfjugador2;
	private JTextField tfjugador3;
	private JTextField tfjugador4;
	private JLabel lblsaldo1;
	private JLabel lblsaldo2;
	private JLabel lblsaldo3;
	private JLabel lblsaldo4;
	private JTextField tfapuesta1;
	private JTextField tfapuesta2;
	private JTextField tfapuesta3;
	private JTextField tfapuesta4;
	private JLabel lblestado1;
	private JLabel lblestado2;
	private JLabel lblestado3;
	private JLabel lblestado4;
	private JComboBox cbcaballo1;
	private JComboBox cbcaballo2;
	private JComboBox cbcaballo3;
	private JComboBox cbcaballo4;
	private JSeparator separator_1;
	private JLabel lblNewLabel_6;
	private JProgressBar pb1;
	private JLabel lblNewLabel_7;
	private JProgressBar pb2;
	private JLabel lblNewLabel_8;
	private JProgressBar pb3;
	private JLabel lblNewLabel_9;
	private JProgressBar pb4;
	private JButton btniniciarjuego;
	private JButton btnsiguientejuego;
	private JButton btnfindejuego;
	
	// Variables label a setear
	public String saldo1 = "20000.0";
	public String saldo2 = "20000.0";
	public String saldo3 = "20000.0";
	public String saldo4 = "20000.0";
	public String estado1 = "Activo";
	public String estado2 = "Activo";
	public String estado3 = "Activo";
	public String estado4 = "Activo";
	public String nombreBoton = "Iniciar Juego";
	
	// Variables de instancias
	public Apuesta apuesta;
	public Caballo caballo;
	public Apostador apostador;
	
	// Otras variables
	public int ganador = 0;
	public Thread tiempo;
	

	/**
	 * Aqui es donde se ejecuta el codigo.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuegoApp window = new JuegoApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la aplicacion.
	 */
	public JuegoApp() {
		initialize();
	}

	/**
	 * Aqui inicializa el contenido del juego.
	 */
	private void initialize() {
		apuesta = new Apuesta();
		frame = new JFrame();
		frame.setBounds(100, 100, 959, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelapuestas = new JLabel("Apuestas de jugadores");
		labelapuestas.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelapuestas.setBounds(212, 11, 220, 14);
		frame.getContentPane().add(labelapuestas);
		
		JLabel lblNewLabel = new JLabel("Jugador");
		lblNewLabel.setBounds(10, 45, 64, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Saldo");
		lblNewLabel_1.setBounds(136, 45, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Valor apuesta");
		lblNewLabel_2.setBounds(212, 45, 98, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Estado en juego");
		lblNewLabel_3.setBounds(334, 45, 98, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Caballo");
		lblNewLabel_4.setBounds(456, 45, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		tfjugador1 = new JTextField();
		tfjugador1.setBounds(10, 75, 98, 20);
		frame.getContentPane().add(tfjugador1);
		tfjugador1.setColumns(10);
		
		tfjugador2 = new JTextField();
		tfjugador2.setBounds(10, 120, 98, 20);
		frame.getContentPane().add(tfjugador2);
		tfjugador2.setColumns(10);
		
		tfjugador3 = new JTextField();
		tfjugador3.setBounds(10, 167, 98, 20);
		frame.getContentPane().add(tfjugador3);
		tfjugador3.setColumns(10);
		
		tfjugador4 = new JTextField();
		tfjugador4.setBounds(10, 215, 98, 20);
		frame.getContentPane().add(tfjugador4);
		tfjugador4.setColumns(10);
		
		lblsaldo4 = new JLabel(this.saldo4);
		lblsaldo4.setBounds(136, 218, 64, 14);
		frame.getContentPane().add(lblsaldo4);
		
		lblsaldo3 = new JLabel(this.saldo3);
		lblsaldo3.setBounds(136, 170, 64, 14);
		frame.getContentPane().add(lblsaldo3);
		
		lblsaldo2 = new JLabel(this.saldo2);
		lblsaldo2.setBounds(136, 123, 64, 14);
		frame.getContentPane().add(lblsaldo2);
		
		lblsaldo1 = new JLabel(this.saldo1);
		lblsaldo1.setBounds(136, 78, 64, 14);
		frame.getContentPane().add(lblsaldo1);
		
		tfapuesta1 = new JTextField();
		tfapuesta1.setBounds(211, 75, 99, 20);
		frame.getContentPane().add(tfapuesta1);
		tfapuesta1.setColumns(10);
		
		tfapuesta2 = new JTextField();
		tfapuesta2.setBounds(212, 120, 98, 20);
		frame.getContentPane().add(tfapuesta2);
		tfapuesta2.setColumns(10);
		
		tfapuesta3 = new JTextField();
		tfapuesta3.setBounds(212, 167, 98, 20);
		frame.getContentPane().add(tfapuesta3);
		tfapuesta3.setColumns(10);
		
		tfapuesta4 = new JTextField();
		tfapuesta4.setBounds(212, 215, 98, 20);
		frame.getContentPane().add(tfapuesta4);
		tfapuesta4.setColumns(10);
		
		lblestado1 = new JLabel(this.estado1);
		lblestado1.setBounds(334, 78, 76, 14);
		frame.getContentPane().add(lblestado1);
		
		lblestado2 = new JLabel(this.estado2);
		lblestado2.setBounds(334, 123, 76, 14);
		frame.getContentPane().add(lblestado2);
		
		lblestado3 = new JLabel(this.estado3);
		lblestado3.setBounds(334, 170, 76, 14);
		frame.getContentPane().add(lblestado3);
		
		lblestado4 = new JLabel(this.estado4);
		lblestado4.setBounds(334, 218, 76, 14);
		frame.getContentPane().add(lblestado4);
		
		cbcaballo1 = new JComboBox();
		cbcaballo1.setBounds(456, 74, 108, 22);
		cbcaballo1.addItem("Mostufa");
		cbcaballo1.addItem("Omicron");
		cbcaballo1.addItem("Paracron");
		cbcaballo1.addItem("Trueno");
		frame.getContentPane().add(cbcaballo1);
		
		cbcaballo2 = new JComboBox();
		cbcaballo2.setBounds(456, 119, 108, 22);
		cbcaballo2.addItem("Mostufa");
		cbcaballo2.addItem("Omicron");
		cbcaballo2.addItem("Paracron");
		cbcaballo2.addItem("Trueno");
		frame.getContentPane().add(cbcaballo2);
		
		cbcaballo3 = new JComboBox();
		cbcaballo3.setBounds(456, 166, 108, 22);
		cbcaballo3.addItem("Mostufa");
		cbcaballo3.addItem("Omicron");
		cbcaballo3.addItem("Paracron");
		cbcaballo3.addItem("Trueno");
		frame.getContentPane().add(cbcaballo3);
		
		cbcaballo4 = new JComboBox();
		cbcaballo4.setBounds(456, 214, 108, 22);
		cbcaballo4.addItem("Mostufa");
		cbcaballo4.addItem("Omicron");
		cbcaballo4.addItem("Paracron");
		cbcaballo4.addItem("Trueno");
		frame.getContentPane().add(cbcaballo4);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(587, 11, 25, 272);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_5 = new JLabel("Juego");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(666, 12, 76, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		taresultados = new JTextArea();
		taresultados.setFont(new Font("Arial", Font.PLAIN, 13));
		taresultados.setEditable(false);
		taresultados.setBounds(622, 142, 292, 141);
		JScrollPane scrollPane = new JScrollPane(taresultados);
		scrollPane.setBounds(622, 142, 292, 141);
		frame.getContentPane().add(scrollPane);
		
		// Aqui es donde empieza el juego al darle click en inicio Juego
		// Este practicamente comienza con el progress bar para ver cual es el caballo ganador
		// luego de ello lanza los resultados.
		btniniciarjuego = new JButton(this.nombreBoton);
		btniniciarjuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// INICIO DE JUEGO
				tiempo = new Thread() {
					public void run() {
				try {
					int seg;
					int r1 = 0;
					int r2 = 0;
					int r3 = 0;
					int r4 = 0;
					int cw = (int)Math.floor(Math.random()*(4-1+1)+1);
					ganador = cw;
					if(cw == 1) {
						r1 = 10;
					}
					if(cw == 2) {
						r2 = 10;
					}
					if(cw == 3) {
						r3 = 10;
					}
					if(cw == 4) {
						r4 = 10;
					}
					int win = 0;
					while(win < 100){
						r1++;
						r2++;
						r3++;
						r4++;
						pb1.setValue(r1);
						pb2.setValue(r2);
						pb3.setValue(r3);
						pb4.setValue(r4);
						tiempo.sleep(10);
						if(r1 == 100) {
							win = 100;
							empezarjugar(cw);
						}
						if(r2 == 100) {
							win = 100;
							empezarjugar(cw);
						}
						if(r3 == 100) {
							win = 100;
							empezarjugar(cw);
						}
						if(r4 == 100) {
							win = 100;
							empezarjugar(cw);
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
					}
				};
				
				tiempo.start();
				//
				
				
			}
			// Metodo donde empieza el juego y obtiene los jugadores iniciales y empeza el primer juego
			public void empezarjugar(int ganador) {
				String nombrej1 = tfjugador1.getText();
				double saldoj1 = Double.parseDouble(lblsaldo1.getText());
				double apuestaj1 = Double.parseDouble(tfapuesta1.getText());
				int codigocaballoj1 = apuesta.identificarCodigoCaballo((String)cbcaballo1.getSelectedItem());
				boolean estadoj1 = apuesta.estadoJugadorEnApuesta(lblestado1.getText());
				apostador = new Apostador(nombrej1, saldoj1, apuestaj1, codigocaballoj1, estadoj1);
				apuesta.listaJugadores.add(apostador);
				caballo = new Caballo(codigocaballoj1, (String)cbcaballo1.getSelectedItem());
				apuesta.listacaballos.add(caballo);
				
				String nombrej2 = tfjugador2.getText();
				double saldoj2 = Double.parseDouble(lblsaldo2.getText());
				double apuestaj2 = Double.parseDouble(tfapuesta2.getText());
				int codigocaballoj2 = apuesta.identificarCodigoCaballo((String)cbcaballo2.getSelectedItem());
				boolean estadoj2 = apuesta.estadoJugadorEnApuesta(lblestado2.getText());
				apostador = new Apostador(nombrej2, saldoj2, apuestaj2, codigocaballoj2, estadoj2);
				apuesta.listaJugadores.add(apostador);
				caballo = new Caballo(codigocaballoj2, (String)cbcaballo2.getSelectedItem());
				apuesta.listacaballos.add(caballo);
				
				String nombrej3 = tfjugador3.getText();
				double saldoj3 = Double.parseDouble(lblsaldo3.getText());
				double apuestaj3 = Double.parseDouble(tfapuesta3.getText());
				int codigocaballoj3 = apuesta.identificarCodigoCaballo((String)cbcaballo3.getSelectedItem());
				boolean estadoj3 = apuesta.estadoJugadorEnApuesta(lblestado3.getText());
				apostador = new Apostador(nombrej3, saldoj3, apuestaj3, codigocaballoj3, estadoj3);
				apuesta.listaJugadores.add(apostador);
				caballo = new Caballo(codigocaballoj3, (String)cbcaballo3.getSelectedItem());
				apuesta.listacaballos.add(caballo);
				
				String nombrej4 = tfjugador4.getText();
				double saldoj4 = Double.parseDouble(lblsaldo4.getText());
				double apuestaj4 = Double.parseDouble(tfapuesta4.getText());
				int codigocaballoj4 = apuesta.identificarCodigoCaballo((String)cbcaballo4.getSelectedItem());
				boolean estadoj4 = apuesta.estadoJugadorEnApuesta(lblestado4.getText());
				apostador = new Apostador(nombrej4, saldoj4, apuestaj4, codigocaballoj4, estadoj4);
				apuesta.listaJugadores.add(apostador);
				caballo = new Caballo(codigocaballoj4, (String)cbcaballo4.getSelectedItem());
				apuesta.listacaballos.add(caballo);
				
				apuesta.juego(ganador);
				actualizarSaldoFrame();
				actualizarEstadoFrame();
				String resultado = apuesta.imprime();
				taresultados.setText(resultado);
				btniniciarjuego.setEnabled(false);
				btnsiguientejuego.setEnabled(true);
				System.out.println("Jugadores activos" + apuesta.jugadoresActivos);
			}
			// Metodo que actualiza el estado del saldo de los jugadores
			public void actualizarEstadoFrame() {
				lblsaldo1.setText(String.valueOf(apuesta.listaJugadores.get(0).saldo));
				lblsaldo2.setText(String.valueOf(apuesta.listaJugadores.get(1).saldo));
				lblsaldo3.setText(String.valueOf(apuesta.listaJugadores.get(2).saldo));
				lblsaldo4.setText(String.valueOf(apuesta.listaJugadores.get(3).saldo));
			}

			// Metodo que actualiza el estado de los jugadores en el juego, activo si sigue en juego e inactivo si queda eliminado
			public void actualizarSaldoFrame() {
				if(apuesta.listaJugadores.get(0).estado == true) {
					lblestado1.setText(String.valueOf("Activo"));
				} else {
					lblestado1.setText(String.valueOf("Inactivo"));
				}
				if(apuesta.listaJugadores.get(1).estado == true) {
					lblestado2.setText(String.valueOf("Activo"));
				} else {
					lblestado2.setText(String.valueOf("Inactivo"));
				}
				if(apuesta.listaJugadores.get(2).estado == true) {
					lblestado3.setText(String.valueOf("Activo"));
				} else {
					lblestado3.setText(String.valueOf("Inactivo"));
				}
				if(apuesta.listaJugadores.get(3).estado == true) {
					lblestado4.setText(String.valueOf("Activo"));
				} else {
					lblestado4.setText(String.valueOf("Inactivo"));
				}
			}
		});
		btniniciarjuego.setBounds(622, 41, 182, 23);
		frame.getContentPane().add(btniniciarjuego);
		
		// Aqui es donde sigue el juego al darle click en Siguiente Juego
		// Este practicamente empieza con el progress bar para ver cual es el caballo ganador
		// luego de ello lanza los resultados.
		btnsiguientejuego = new JButton("Siguiente Juego");
		btnsiguientejuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(apuesta.estadoApuestaJuego() == 1) {
					// continuo juego
					tiempo = new Thread() {
						public void run() {
					try {
						int seg;
						int r1 = 0;
						int r2 = 0;
						int r3 = 0;
						int r4 = 0;
						int cw = (int)Math.floor(Math.random()*(4-1+1)+1);
						ganador = cw;
						if(cw == 1) {
							r1 = 10;
						}
						if(cw == 2) {
							r2 = 10;
						}
						if(cw == 3) {
							r3 = 10;
						}
						if(cw == 4) {
							r4 = 10;
						}
						int win = 0;
						while(win < 100){
							r1++;
							r2++;
							r3++;
							r4++;
							pb1.setValue(r1);
							pb2.setValue(r2);
							pb3.setValue(r3);
							pb4.setValue(r4);
							tiempo.sleep(10);
							if(r1 == 100) {
								win = 100;
								seguirjugar(cw);
							}
							if(r2 == 100) {
								win = 100;
								seguirjugar(cw);
							}
							if(r3 == 100) {
								win = 100;
								seguirjugar(cw);
							}
							if(r4 == 100) {
								win = 100;
								seguirjugar(cw);
							}
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
						}
					};
					
					tiempo.start();
					//
				} else {
					btnsiguientejuego.setEnabled(false);
					btnfindejuego.setEnabled(true);
				}
			}
			// Metodo donde continua el juego y obtiene los datos actuales de los jugadores
			public void seguirjugar(int ganador) {
				String nombrej1 = apuesta.listaJugadores.get(0).nombre;
				double saldoj1 = apuesta.listaJugadores.get(0).saldo;
				double apuestaj1 = Double.parseDouble(tfapuesta1.getText());
				int codigocaballoj1 = apuesta.identificarCodigoCaballo((String)cbcaballo1.getSelectedItem());
				boolean estadoj1 = apuesta.estadoJugadorEnApuesta(lblestado1.getText());
				apostador = new Apostador(nombrej1, saldoj1, apuestaj1, codigocaballoj1, estadoj1);
				apuesta.listaJugadores.set(0, apostador);
				
				String nombrej2 = apuesta.listaJugadores.get(1).nombre;
				double saldoj2 = apuesta.listaJugadores.get(1).saldo;
				double apuestaj2 = Double.parseDouble(tfapuesta2.getText());
				int codigocaballoj2 = apuesta.identificarCodigoCaballo((String)cbcaballo2.getSelectedItem());
				boolean estadoj2 = apuesta.estadoJugadorEnApuesta(lblestado2.getText());
				apostador = new Apostador(nombrej2, saldoj2, apuestaj2, codigocaballoj2, estadoj2);
				apuesta.listaJugadores.set(1, apostador);
				
				String nombrej3 = apuesta.listaJugadores.get(2).nombre;
				double saldoj3 = apuesta.listaJugadores.get(2).saldo;
				double apuestaj3 = Double.parseDouble(tfapuesta3.getText());
				int codigocaballoj3 = apuesta.identificarCodigoCaballo((String)cbcaballo3.getSelectedItem());
				boolean estadoj3 = apuesta.estadoJugadorEnApuesta(lblestado3.getText());
				apostador = new Apostador(nombrej3, saldoj3, apuestaj3, codigocaballoj3, estadoj3);
				apuesta.listaJugadores.set(2, apostador);
				
				String nombrej4 = apuesta.listaJugadores.get(3).nombre;
				double saldoj4 = apuesta.listaJugadores.get(3).saldo;
				double apuestaj4 = Double.parseDouble(tfapuesta4.getText());
				int codigocaballoj4 = apuesta.identificarCodigoCaballo((String)cbcaballo4.getSelectedItem());
				boolean estadoj4 = apuesta.estadoJugadorEnApuesta(lblestado4.getText());
				apostador = new Apostador(nombrej4, saldoj4, apuestaj4, codigocaballoj4, estadoj4);
				apuesta.listaJugadores.set(3, apostador);
				
				apuesta.juego(ganador);
				actualizarSaldoFrame();
				actualizarEstadoFrame();
				String resultado = apuesta.imprime();
				taresultados.setText(resultado);
				System.out.println("Jugadores activos" + apuesta.jugadoresActivos);
			}
			// Metodo que actualiza el estado del saldo de los jugadores
			public void actualizarEstadoFrame() {
				lblsaldo1.setText(String.valueOf(apuesta.listaJugadores.get(0).saldo));
				lblsaldo2.setText(String.valueOf(apuesta.listaJugadores.get(1).saldo));
				lblsaldo3.setText(String.valueOf(apuesta.listaJugadores.get(2).saldo));
				lblsaldo4.setText(String.valueOf(apuesta.listaJugadores.get(3).saldo));
			}

			// Metodo que actualiza el estado de los jugadores en el juego, activo si sigue en juego e inactivo si queda eliminado
			public void actualizarSaldoFrame() {
				if(apuesta.listaJugadores.get(0).estado == true) {
					lblestado1.setText(String.valueOf("Activo"));
				} else {
					lblestado1.setText(String.valueOf("Inactivo"));
				}
				if(apuesta.listaJugadores.get(1).estado == true) {
					lblestado2.setText(String.valueOf("Activo"));
				} else {
					lblestado2.setText(String.valueOf("Inactivo"));
				}
				if(apuesta.listaJugadores.get(2).estado == true) {
					lblestado3.setText(String.valueOf("Activo"));
				} else {
					lblestado3.setText(String.valueOf("Inactivo"));
				}
				if(apuesta.listaJugadores.get(3).estado == true) {
					lblestado4.setText(String.valueOf("Activo"));
				} else {
					lblestado4.setText(String.valueOf("Inactivo"));
				}
			}
		});
		btnsiguientejuego.setEnabled(false);
		btnsiguientejuego.setBounds(622, 74, 182, 23);
		frame.getContentPane().add(btnsiguientejuego);
		
		// Aqui es donde finaliza el juego
		// Este practicamente lanza los resultados finales
		// Ya sea que haya un solo jugador ganador al final o no lo haya y lanze el juego se acabado.
		btnfindejuego = new JButton("Fin de Juego");
		btnfindejuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// fin juego
				
				if(apuesta.estadoApuestaJuego() == 2) {
					String resultado = "El apostador ganador final es: \n";
					resultado += apuesta.imprimeGanadorFinal();
					taresultados.setText(resultado);
					btnfindejuego.setEnabled(false);
					btniniciarjuego.setEnabled(true);
					System.out.println("Jugadores activos" + apuesta.jugadoresActivos);
				} else {
					String resultado = "El juego se acaba, ya que todos los jugadores se quedaron sin dinero: \n";
					resultado += apuesta.imprimeGanadorFinal();
					taresultados.setText(resultado);
					btnfindejuego.setEnabled(false);
					btniniciarjuego.setEnabled(true);
					System.out.println("Jugadores activos" + apuesta.jugadoresActivos);
				}
			}
		});
		btnfindejuego.setEnabled(false);
		btnfindejuego.setBounds(622, 108, 182, 23);
		frame.getContentPane().add(btnfindejuego);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(10, 294, 904, 14);
		frame.getContentPane().add(separator_1);
		
		lblNewLabel_6 = new JLabel("Caballo 1");
		lblNewLabel_6.setBounds(10, 332, 98, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		pb1 = new JProgressBar();
		pb1.setBounds(136, 332, 454, 14);
		frame.getContentPane().add(pb1);
		
		lblNewLabel_7 = new JLabel("Caballo 2");
		lblNewLabel_7.setBounds(10, 385, 98, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		pb2 = new JProgressBar();
		pb2.setBounds(136, 385, 454, 14);
		frame.getContentPane().add(pb2);
		
		lblNewLabel_8 = new JLabel("Caballo 3");
		lblNewLabel_8.setBounds(10, 444, 98, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		pb3 = new JProgressBar();
		pb3.setBounds(136, 444, 454, 14);
		frame.getContentPane().add(pb3);
		
		lblNewLabel_9 = new JLabel("Caballo 4");
		lblNewLabel_9.setBounds(10, 505, 98, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		pb4 = new JProgressBar();
		pb4.setBounds(136, 505, 454, 14);
		frame.getContentPane().add(pb4);
		
		
	}
}

