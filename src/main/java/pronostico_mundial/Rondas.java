package pronostico_mundial;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Rondas {
	private boolean fileOK;    //Todo bien con el archivo
	private ArrayList<Partido> partidos= new ArrayList<Partido>();
	
	public Rondas (String fileName) {
		this.loadRonda(fileName);
	}

	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	//Cada vez que se carga un archivo de Ronda la cosa puede terminar bien o mal. Se puede consultar:
	public boolean allOK() {
		return fileOK;
	}

	public void loadRonda(String fileName) {
		Path path = Paths.get(fileName);
		boolean exists = Files.exists(path);
		List<String> partidosDeLaRonda = null; 
		this.fileOK= exists; //Arrancamos así pero puede cambiar abajo
		if (exists) {
		try {
			partidosDeLaRonda = Files.readAllLines(path);
			for (int i=0; i<partidosDeLaRonda.size(); i++) { 
		        //System.out.println(partidosDeLaRonda.get(i));	
		        String[] datos = partidosDeLaRonda.get(i).split(";");
//El constructor es así: public Partido(int id, Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2)
//El id de cada partido no está definido, así que queda el orden de lectura, tal como aparece en el archivo
		        int nroRondaPartido = Integer.parseInt(datos[0]); //el primer campo es el nro de ronda + nro partido
		        Equipo equipo1 = new Equipo(datos[1], 0); //El ID es cero porque no viene en el archivo
		        Equipo equipo2 = new Equipo(datos[4], 0); //El ID es cero porque no viene en el archivo
		        Partido partido= new Partido(nroRondaPartido, equipo1, equipo2, Integer.parseInt(datos[2]), Integer.parseInt(datos[3]));
		        if (partido!=null) {
		        	this.partidos.add(partido); //Por las dudas
					//System.out.println(nroRondaPartido+" >>>>>>>>>>>>> "+partido.getResultadoAsString());
		        }
			}
		} catch(IOException e) {
			this.fileOK= false;
			System.out.println("El archivo de datos es inválido o corrompido.");
		}}
		else System.out.println("El archivo de datos no existe o está en otra ubicación.");
	}//fin de loadRonda
	
	
}
