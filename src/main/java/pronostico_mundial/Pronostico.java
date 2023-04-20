package pronostico_mundial;

public class Pronostico {

	private int idDelPronostico; //Esto aún no tiene utilidad
	private int idDelPartido; //¿para qué guardar en Pronóstico todo el objeto Partido? basta el id
	private String participante; //Nombre de la persona que hace la apuesta... vamos a suponer que no se repiten nombres por simplicidad
	private ResultEnum apuesta; 	//guarda la apuesta como una posición de ResultadoEnum. -1 es que aún no se hizo apuesta
								// apuesta = 0 es "Empate"; apuesta = 1 es "Gana Equipo 1; apuesta = 2 es "Gana Equipo 2 
	
	public Pronostico(String participante, int idPartido, ResultEnum apuesta) {
		this.participante = participante;
		this.idDelPartido = idPartido;
		this.apuesta = apuesta;			
	}

	/********************************************************************************/	
	public String getParticipante() {
		return participante;
	}

	/********************************************************************************/
	public void setParticipante(String participante) {
		this.participante = participante;
	}

	/********************************************************************************/
	public int getIdDelPronostico() {
		return idDelPronostico;
	}

	/********************************************************************************/
	public void setIdDelPronostico(int idDelPronostico) {
		this.idDelPronostico = idDelPronostico;
	}

	/********************************************************************************/
	public int getIdDelPartido() {
		return idDelPartido;
	}

	/********************************************************************************/
	public void setIdDelPartido(int idDelPartido) {
		this.idDelPartido = idDelPartido;
	}
	
	/********************************************************************************/
	public ResultEnum getApuesta() {
		return apuesta;
	}

	/********************************************************************************/
	public void setApuesta(ResultEnum apuesta) {
		this.apuesta= apuesta; //lo mismo que decir que no hay apuesta
	}

}
