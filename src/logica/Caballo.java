package logica;

/*
 * Clase de los caballos donde guarda los datos de los caballos
 */
public class Caballo {
	public int codigoCaballo;
	public String nombre;
	
	public Caballo(int codigoCaballo, String nombre) {
		super();
		this.codigoCaballo = codigoCaballo;
		this.nombre = nombre;
	}
	public Caballo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCodigoCaballo() {
		return codigoCaballo;
	}
	public void setCodigoCaballo(int codigoCaballo) {
		this.codigoCaballo = codigoCaballo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
