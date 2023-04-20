package pronostico_mundial;

public class Participante {
	private String nombreParticipante;
	private String DNI;
	private String nroDeTel;
	private String correoEl;
	private int puntosAcumulados;
	
	public Participante(String nombreParticipante) {
		super();
		this.nombreParticipante = nombreParticipante;
		this.puntosAcumulados= 0;
	}
 
	public String getNombreParticipante() {
		return nombreParticipante;
	}

	public void setNombreParticipante(String nombreParticipante) {
		this.nombreParticipante = nombreParticipante;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNroDeTel() {
		return nroDeTel;
	}

	public void setNroDeTel(String nroDeTel) {
		this.nroDeTel = nroDeTel;
	}

	public String getCorreoEl() {
		return correoEl;
	}

	public void setCorreoEl(String correoEl) {
		this.correoEl = correoEl;
	}

	public int getPuntosAcumulados() {
		return puntosAcumulados;
	}

	public void setPuntosAcumulados(int puntosAcumulados) {
		this.puntosAcumulados = puntosAcumulados;
	}

	
}
