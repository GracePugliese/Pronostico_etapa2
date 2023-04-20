package pronostico_mundial;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class TestPronosticos {

	
	@Test
	void testPartidos() {
		MegaConstructor mega;
		mega = new MegaConstructor("Pronosticos.csv", "Resultados.csv"); 
		mega.Correlation();	//Lanzamos la correlación entre Resultados de Partidos y Apuestas de Participantes
		assertEquals(mega.getCantidadDePartidos(), 14);
	}

	@Test
	void testParticipantes() {
		MegaConstructor mega;
		mega = new MegaConstructor("Pronosticos.csv", "Resultados.csv"); 
		mega.Correlation();	//Lanzamos la correlación entre Resultados de Partidos y Apuestas de Participantes
		assertEquals(mega.getCantidadDeParticipantes() , 2);
	}

}
