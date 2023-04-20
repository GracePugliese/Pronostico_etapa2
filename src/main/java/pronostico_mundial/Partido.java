package pronostico_mundial;

public class Partido {

	private int id; //las centenas indican a que ronda corresponde, las decenas al orden de partido dentro de la ronda
	private Equipo equipo1;
	private Equipo equipo2;
	private int golesEquipo1;
	private int golesEquipo2;
	private ResultEnum resultado;
	
	public Partido(int id, Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
		this.id = id;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.golesEquipo1 = golesEquipo1;
		this.golesEquipo2 = golesEquipo2;
		this.resultado= Resultado(); //En función de los goles será Empate; Gana Equipo 1; Gana Equipo 2
	}
	
	private ResultEnum Resultado() {
		ResultEnum resul= ResultEnum.SIN_DEFINIR;
		if (this.golesEquipo1==this.golesEquipo2) {
			resul= ResultEnum.EMPATE;
		}
		else 
			if (this.golesEquipo1>this.golesEquipo2) {
				resul= ResultEnum.GANA_EQUIPO1;
			}
			else 
				if (this.golesEquipo1<this.golesEquipo2) 
					resul= ResultEnum.GANA_EQUIPO2;
		return resul;
	}


	public Equipo getEquipo1() {
		return equipo1;
	}


	public Equipo getEquipo2() {
		return equipo2;
	}


	public int getGolesEquipo1() {
		return golesEquipo1;
	}

	public void setGolesEquipo1(int golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
		this.resultado= Resultado(); //Si cambian los goles cambia el resultado
	}

	public int getGolesEquipo2() {
		return golesEquipo2;
	}

	public void setGolesEquipo2(int golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
		this.resultado= Resultado(); //Si cambian los goles cambia el resultado
	}

	public int getId() {
		return id;
	}

	public ResultEnum getResultado() {
		return resultado;
	}
	
	public String getResultadoAsString() {
		String auxStr= "";
		if (this.resultado==ResultEnum.EMPATE) {
			auxStr= "Empate entre "+this.equipo1.getNombre()+" y "+this.equipo2.getNombre() ;
		}
		else 
			if (this.resultado==ResultEnum.GANA_EQUIPO1) {
				auxStr= "Gana Equipo 1 "+this.equipo1.getNombre() ;
			}
			else 
				if (this.resultado==ResultEnum.GANA_EQUIPO2) {
					auxStr= "Gana Equipo 2 "+this.equipo2.getNombre() ;
				}
	
		return auxStr;
	}

}
