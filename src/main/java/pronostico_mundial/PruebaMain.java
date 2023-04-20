package pronostico_mundial;
import java.util.ArrayList;

public class PruebaMain {

		//Tenemos un SuperObjeto (Mega) que se encarga de hacer todo.
		public static MegaConstructor mega;
		public static boolean hayArgs= true;
		
		public static void main(String[] args) {
			String arg1;
			String arg2;
			 try{
				 arg1= args[0]; // "Pronosticos.csv"
				 arg2= args[1]; // "Resultados.csv"
			      }
			    catch(Exception e){
			  	hayArgs= false;
			  	arg1= "";
			  	arg2= "";
			 };

			System.out.println("Corriendo Prueba pronósticos_2"); //Cartel de arranque
			//(1) al Mega construye a partir de los pronósticos y los resultados de los partidos
			if (hayArgs) {
				mega = new MegaConstructor(arg1, arg2); 				
			} else
				mega = new MegaConstructor("Pronosticos.csv", "Resultados.csv"); 
			//(2) Para chequear si hubo coincidencias entre los Pronósticos y los Resultados de las Rondas: Correlation
			mega.Correlation();	
			//(3) Luego de lo anterior podemos recorrer el listado de participantes para mostrar sus aciertos
			mega.ShowResultadosDeParticipantes(); 
		}

		
}
