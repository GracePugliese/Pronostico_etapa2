package pronostico_mundial;

import java.util.ArrayList;

public class MegaConstructor {

	private int cantidadDeParticipantes;
	private int cantidadDePartidos;

	private ArrayList<Partido> todosLosPartidos = new ArrayList<Partido>();
	private ArrayList<Pronostico> pronosticos = new ArrayList<Pronostico>();
	private static ListaPronosticos pronoList;

	public MegaConstructor(String archivoDePronosticos, String archivoDeRondas) {
		// (1) se construye una listas de todos los partidos de todas las rondas
		LoadPartidos(archivoDeRondas); //LoadPartidos es una función que está abajo
		// (2) Por otro lado tenemos la lista de los pronósticos de lxs participantes
		pronoList = new ListaPronosticos(archivoDePronosticos);
		if (pronoList.isFileOK()) //Si el archivoDePronosticos se cargó correctamente...
		pronosticos.addAll(pronoList.getPronosticosEnlistados());
	}

	public int getCantidadDeParticipantes() {
		cantidadDeParticipantes= pronoList.getParticipantes().getCantidadParticipantes();
		return cantidadDeParticipantes;
	}

	public int getCantidadDePartidos() {
		cantidadDePartidos = this.todosLosPartidos.size();
		return cantidadDePartidos;
	}

	public ArrayList<Partido> getTodosLosPartidos() {
		return this.todosLosPartidos;
	}

	public void setPronosticos(ArrayList<Pronostico> pronosticos) {
		this.pronosticos = pronosticos;
	}


	
	//Este método recorre los pronósticos y busca la apuesta por Partido para darle puntaje a los Participantes
	public void Correlation() {
		// Se recorre la lista de pronósticos mirando partidos y participantes
		// si el resultado del partido coincide con la apuesta del participante se le suma 1 al puntaje de este último
		for (int i=0; i<pronosticos.size(); i++) {
			Pronostico prono = pronosticos.get(i);
	        String nombrePartic = prono.getParticipante();
	    	int idPartido= prono.getIdDelPartido();
			//System.out.println(idPartido+" >>>>>>>>>>>>> "+nombrePartic);
	    	if (!prono.getApuesta().equals(ResultEnum.SIN_DEFINIR)) { //Buscamos el partido dentro del listado de partidos (todosLosPartidos) 
	        	boolean encontrado = false;
	        	int j=0; //ahora buscamos en el listado de partidos el que corresponde a este pronóstico
	        	while (j<todosLosPartidos.size() && !encontrado) {
	        		encontrado = (todosLosPartidos.get(j).getId()==idPartido);
	        		if (!encontrado) j++;
	        	} //Habiendo encontrado el partido vemos si la apuesta del participante es igual al resultado del partido
	        	if (encontrado) {
	        		if (todosLosPartidos.get(j).getResultado().equals(prono.getApuesta())) {
	        			Participante partic = pronoList.getParticipantes().searchParticipante(nombrePartic);
	        			partic.setPuntosAcumulados(1+partic.getPuntosAcumulados()); //por cada acierto le agregamos un punto
	        			//System.out.println(partic.getNombreParticipante()+" ha anotado "+partic.getPuntosAcumulados()+" puntos");
	        		}
	        	}
	        }
		}
	}
	
	
	// Se construye una lista con todos los partidos de todas las rondas que se pasa como un ArrayList de Strings
	private void LoadPartidos(String archivoDeRondas ) {
			Rondas rondas= new Rondas(archivoDeRondas);	
			if (rondas.allOK())
			this.todosLosPartidos.addAll(rondas.getPartidos());
	System.out.println("Total de partidos jugados: "+todosLosPartidos.size());
	}
		
	
	// Este método muestra los datos relevantes de los participantes a partir de la lista generada por ListaParticipantes
	public void ShowResultadosDeParticipantes() {
		System.out.println(pronoList.getParticipantes().getCantidadParticipantes()+" participantes:");
		//Se recorren toda la lista de participantes para mostrar sus puntos acumulados
		for (int i=0; i<pronoList.getParticipantes().getCantidadParticipantes(); i++) {
			Participante partic = pronoList.getParticipantes().getParticipante(i);
			if (partic!=null)
		    System.out.println(i+1+") "+partic.getNombreParticipante()+" tiene "+partic.getPuntosAcumulados()+" puntos acumulados");
		}		
	}

}
