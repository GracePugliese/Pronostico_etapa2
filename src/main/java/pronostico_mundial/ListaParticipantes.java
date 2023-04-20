package pronostico_mundial;

import java.util.ArrayList;

public class ListaParticipantes {
	private ArrayList<Participante> lista = new ArrayList<Participante>();  
	
	public ListaParticipantes() {
		//Nada que Hacer acá
	}
	
	/************************************************************************/
	//Agrega un Participante si y sólo si es alguien nuevo y no está en la lista
	public void addParticipante(String nombre) { 
		boolean founded= false;
		int i=0;
		while (i<this.lista.size() && !founded) {
			founded = this.lista.get(i).getNombreParticipante().equals(nombre);
			i++;
		}
		if (!founded) {
			Participante parti = new Participante(nombre);
			this.lista.add(parti);
			//System.out.println("Agregamos a "+parti.getNombreParticipante());
		}
	}
	
	/************************************************************************/
	public Participante searchParticipante(String nombre) {
		boolean founded= false;
		int i=0;
		while (i<this.lista.size() && !founded) {
			founded = this.lista.get(i).getNombreParticipante().equals(nombre);
			if (!founded) i++;
		}
		if (founded) {
			return this.lista.get(i);
		}
		else return null;
	}

	/************************************************************************/
	public int getCantidadParticipantes() {
		return this.lista.size();
	}
	
	/************************************************************************/
	public Participante getParticipante(int posicion) {
		if (posicion>=0 && posicion<this.lista.size()) {
			return this.lista.get(posicion);
		}
		return null;
	}
	
	
}
