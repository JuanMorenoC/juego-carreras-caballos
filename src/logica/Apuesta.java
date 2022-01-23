package logica;

import java.util.ArrayList;
/*
 * Clase de la parte logica donde opera el juego, este practicamente es la parte funcional del juego
 */
public class Apuesta {
	
	// Variables necesarias para la operaciones, desde listas hasta variables que se requiera.
	public ArrayList<Apostador> listaJugadores = new ArrayList<Apostador>();
	public ArrayList<Caballo> listacaballos = new ArrayList<Caballo>();
	public ArrayList<Caballo> listacaballosGanador = new ArrayList<Caballo>();
	public ArrayList<String> listaGanador = new ArrayList<String>();
	public int jugadoresActivos;
	public Apostador apostador;
	public Caballo caballo;
	
	// Metodo que identifica el codigo del caballo
	public int identificarCodigoCaballo(String nombreCaballo) {
		int codigoCaballo = 0;
		if(nombreCaballo.equalsIgnoreCase("Mostufa")) {
			codigoCaballo = 1;
		}
		if(nombreCaballo.equalsIgnoreCase("Omicron")) {
			codigoCaballo = 2;
		}
		if(nombreCaballo.equalsIgnoreCase("Paracron")) {
			codigoCaballo = 3;
		}
		if(nombreCaballo.equalsIgnoreCase("Trueno")) {
			codigoCaballo = 4;
		}
		return codigoCaballo;
	}
	
	// Metodo que identifica del jugador si es true es porque es activo de lo contrario esta inactivo
	public boolean estadoJugadorEnApuesta(String estado) {
		boolean estadoApuesta = false;
		if(estado.equalsIgnoreCase("Activo")) {
			estadoApuesta = true;
		}
		return estadoApuesta;
	}
	
	// Metodo que identifica el estado del juego dependiendo de los jugadores activos que haya
	public int estadoApuestaJuego() {
		int estado = 0;
		if(jugadoresActivos > 1) {
			estado = 1;
		}
		if(jugadoresActivos == 1) {
			estado = 2;
		}
		if(jugadoresActivos == 0) {
			estado = 3;
		}
		return estado;
	}
	
	// Metodo inicial del juego donde llama los metodos necesarios para el juego
	public void juego(int ganador) {
		listaGanador.clear();
		int numAleatorio = ganador;
		System.out.println("random " + numAleatorio);
		caballoGanador(numAleatorio);
		calcularSaldos(numAleatorio);
		cambiarEstado();
		jugadorActivo();
	}

	// Metodo que identifica cuantos jugadores activos hay en el juego
	public void jugadorActivo() {
		jugadoresActivos = 0;
		for(int i=0; i < listaJugadores.size() ;i++) {
			if(listaJugadores.get(i).saldo > 0.0) {
				jugadoresActivos++;
			}
		}
	}

	// Metodo que calcula el saldo de cada jugador
	public void calcularSaldos(int caballoGanador) {
		double apuestaGanadora = 0;
		double apuestaPerdida = 0;
		int cantidadGanador = 0; 
		int cantidadActivos = 0;
		for(int i=0; i < listaJugadores.size() ;i++) {
			if(listaJugadores.get(i).estado == true) {
				if(listaJugadores.get(i).codigoCaballo == caballoGanador) {
					listaGanador.add(listaJugadores.get(i).nombre);
					cantidadGanador++;
				}
				apuestaGanadora += listaJugadores.get(i).apuesta;
				cantidadActivos++;
			}
		}
		
		if(cantidadGanador > 1) {
			apuestaGanadora = apuestaGanadora / cantidadGanador;
		}
		for(int i=0; i < listaJugadores.size() ;i++) {
			if(listaJugadores.get(i).estado == true) {
				if(listaJugadores.get(i).codigoCaballo == caballoGanador) {
					apuestaGanadora = apuestaGanadora + (listaJugadores.get(i).saldo - listaJugadores.get(i).apuesta);
					apostador = new Apostador(listaJugadores.get(i).nombre, apuestaGanadora, listaJugadores.get(i).apuesta,
							listaJugadores.get(i).codigoCaballo, listaJugadores.get(i).estado);
					listaJugadores.set(i, apostador);
				} else {
					apuestaPerdida = listaJugadores.get(i).saldo - listaJugadores.get(i).apuesta;
					if(apuestaPerdida <= 0.0) {
						apuestaPerdida = 0.0;
					}
					apostador = new Apostador(listaJugadores.get(i).nombre, apuestaPerdida, listaJugadores.get(i).apuesta,
							listaJugadores.get(i).codigoCaballo, listaJugadores.get(i).estado);
					listaJugadores.set(i, apostador);
				}
			}
		}
	}
	
	// Metodo que cambia el estado de los jugadores dependiendo del saldo que tenga
	public void cambiarEstado() {
		
		for(int i=0; i < listaJugadores.size() ;i++) {
			if(listaJugadores.get(i).saldo <= 0) {
				apostador = new Apostador(listaJugadores.get(i).nombre, listaJugadores.get(i).saldo, listaJugadores.get(i).apuesta,
						listaJugadores.get(i).codigoCaballo, false);
				listaJugadores.set(i, apostador);
			}
		}
	}
	
	// Metodo que identifica el cabalo ganador dependiendo del numero lanzado desde la clase JuegoApp
	public void caballoGanador(int numAleatorio) {
		if(listacaballosGanador.size() == 0) {
			if(numAleatorio == 1) {
				caballo = new Caballo(numAleatorio, "Mostufa");
				listacaballosGanador.add(caballo);
			}
			if(numAleatorio == 2) {
				caballo = new Caballo(numAleatorio, "Omicron");
				listacaballosGanador.add(caballo);
			}
			if(numAleatorio == 3) {
				caballo = new Caballo(numAleatorio, "Paracron");
				listacaballosGanador.add(caballo);
			}
			if(numAleatorio == 4) {
				caballo = new Caballo(numAleatorio, "Trueno");
				listacaballosGanador.add(caballo);
			}
		} else {
			if(numAleatorio == 1) {
				caballo = new Caballo(numAleatorio, "Mostufa");
				listacaballosGanador.set(0, caballo);
			}
			if(numAleatorio == 2) {
				caballo = new Caballo(numAleatorio, "Omicron");
				listacaballosGanador.set(0, caballo);
			}
			if(numAleatorio == 3) {
				caballo = new Caballo(numAleatorio, "Paracron");
				listacaballosGanador.set(0, caballo);
			}
			if(numAleatorio == 4) {
				caballo = new Caballo(numAleatorio, "Trueno");
				listacaballosGanador.set(0, caballo);
			}
		}
	}

	// Metodo que imprime el caballo ganador mas el jugador ganador de cada partida
	public String imprime() {
		String mensaje = "";
		if(listaGanador.size() == 1) {
			mensaje = "El caballo ganador es: " + listacaballosGanador.get(0).nombre + "\n";
			mensaje += "El apostador ganador es: " + listaGanador.get(0);
		} else {
			mensaje = "El caballo ganador es: " + listacaballosGanador.get(0).nombre + "\n";
			mensaje += "Los apostadores ganadores son: \n";
			for(int i=0; i < listaGanador.size() ;i++) {
				mensaje += listaGanador.get(i) + "\n";
			}
		}
		return mensaje;
	}
	
	// Metodo que imprime el ganador final con el saldo
	public String imprimeGanadorFinal() {
		String mensaje = "";
		for(int i=0; i < 4 ;i++) {
			if(listaJugadores.get(i).estado == true) {
				mensaje += listaJugadores.get(i).nombre + " con un saldo total de: " + listaJugadores.get(i).saldo;
			}
		}
		return mensaje;
	}
}
