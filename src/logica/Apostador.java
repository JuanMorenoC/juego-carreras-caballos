package logica;

/*
 * Clase del apostador donde guarda los datos de los jugadores
 */
public class Apostador {
	public String nombre;
	public double saldo;
	public double apuesta;
	public int codigoCaballo;
	public boolean estado;
	
	public Apostador(String nombre, double saldo, double apuesta, int codigoCaballo, boolean estado) {
		super();
		this.nombre = nombre;
		this.saldo = saldo;
		this.apuesta = apuesta;
		this.codigoCaballo = codigoCaballo;
		this.estado = estado;
	}

	public Apostador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getApuesta() {
		return apuesta;
	}

	public void setApuesta(double apuesta) {
		this.apuesta = apuesta;
	}

	public int getCodigoCaballo() {
		return codigoCaballo;
	}

	public void setCodigoCaballo(int codigoCaballo) {
		this.codigoCaballo = codigoCaballo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
	
}
