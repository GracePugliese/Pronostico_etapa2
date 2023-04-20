package pronostico_mundial;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Ronda {
	private int numeroDeRonda; //multiplos de 100
	private boolean fileOK;    //Todo bien con el archivo
	private ArrayList<Partido> partidos= new ArrayList<Partido>();
	
	public Ronda (int rondaNro, String fileName) {
		this.numeroDeRonda= rondaNro;
		this.loadRonda(fileName);
	}

	public int getNumeroDeRonda() {
		return numeroDeRonda;
	}

	public void setNumeroDeRonda(int numeroDeRonda) {
		this.numeroDeRonda = numeroDeRonda; //Por las dudas, por si alguien quiere cambiar el nro de ronda
	}

	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	//Cada vez que se carga un archivo de Ronda la cosa puede terminar bien o mal. Se puede consultar:
	public boolean isFileOK() {
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
		        Equipo equipo1 = new Equipo(datos[0], 0); //El ID es cero porque no viene en el archivo
		        Equipo equipo2 = new Equipo(datos[3], 0); //El ID es cero porque no viene en el archivo
		        Partido partido= new Partido(this.numeroDeRonda+i+1, equipo1, equipo2, Integer.parseInt(datos[1]), Integer.parseInt(datos[2]));
		        if (partido!=null) this.partidos.add(partido); //Por las dudas
			}
		} catch(IOException e) {
			this.fileOK= false;
			System.out.println("El archivo de datos es inválido o corrompido.");
		}}
		else System.out.println("El archivo de datos no existe o está en otra ubicación.");
	}//fin de loadRonda
	
	
}
