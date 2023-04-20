package pronostico_mundial;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ListaPronosticos {

	//En el archivo de pronósticos vienen dos cosas importantes: los Participantes y las Apuestas
	private ArrayList<Pronostico> listaDePronosticos= new ArrayList<Pronostico>();
	private ListaParticipantes listaParticipantes= new ListaParticipantes();
	private boolean fileOK; //Indicador de si se cargó bien el archivo o no.

	public ListaPronosticos(String fileName) { //se crea levantando los datos del archivo
		loadPronosticos(fileName);
	}
	
	/********************************************************************************/
	public ArrayList<Pronostico> getPronosticosEnlistados() {
		return listaDePronosticos;
	}
	
	/********************************************************************************/
	public ListaParticipantes getParticipantes() {
		return listaParticipantes;
	}
	
	/********************************************************************************/
	//este parámetro nos dice si se cargó bien el archivo de pronósticos o no.
	public boolean isFileOK() {
		return fileOK;
	}

	/********************************************************************************/
	//Carga del disco los pronósticos pero a su vez ve los participantes y los enlista
	public void loadPronosticos(String fileName) {
		Path path = Paths.get(fileName);
		boolean exists = Files.exists(path);
		List<String> pronosticos = null; 
		this.fileOK= exists; //arranca así pero puede modificarse abajo
		if (exists) {
		try {
			pronosticos = Files.readAllLines(path);
			for (int i=0; i<pronosticos.size(); i++) { 
		        //System.out.println(pronosticos.get(i));	
		        String[] datos = pronosticos.get(i).split(";");
// Es así: public Pronostico(String participante, int idPartido, int apuesta) 
		        String nombreParticipante = datos[0]; 		//El primer dato es el nombre del participante
		        int idPartido = Integer.parseInt(datos[1]); //El segundo es el id del partido al que se apuesta
		        int apuesta = Integer.parseInt(datos[2]); 	//El tercero es la apuesta: 0=Empate; 1=Gana Equipo 1; 2= Gana Equipo2
		        Pronostico pronostico= new Pronostico(nombreParticipante, idPartido, intToEnum(apuesta));
		        this.listaParticipantes.addParticipante(nombreParticipante);  	//También armamos la lista de participantes
		        if (pronostico!=null) this.listaDePronosticos.add(pronostico); 	//Por las dudas veo si es null
			}
		} catch(IOException e) {
			this.fileOK= false;
			System.out.println("El archivo de datos ["+fileName+"] es inválido o está corrompido.");
		}}
		else System.out.println("El archivo de datos ["+fileName+"] no existe o está en otra ubicación.");
				
	}//fin de loadPronosticos

	/********************************************************************************/
	//esta función traduce los números enteros que ofrece el archivo a ResultadoEnum
	public static ResultEnum intToEnum(int valor) {
		if (valor==0) {
			return ResultEnum.EMPATE;
		}
		else if (valor==1) {
			return ResultEnum.GANA_EQUIPO1;
		}
		else if (valor==2) {
			return ResultEnum.GANA_EQUIPO2;
		}
		else return ResultEnum.SIN_DEFINIR;
	}
	
}
