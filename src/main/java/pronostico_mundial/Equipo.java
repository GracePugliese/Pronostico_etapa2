package pronostico_mundial;

//esto es una prueba git
// esto es una segunda prueba git
public class Equipo {

	private int id;
	private String nombre;
	private String descripcion;
	
	public Equipo( String nombre, int id) {
	    this.id=id;
		this.nombre = nombre;	
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}

