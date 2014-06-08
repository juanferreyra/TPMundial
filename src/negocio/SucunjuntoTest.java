package negocio;

import static org.junit.Assert.*;
import org.junit.Test;

public class SucunjuntoTest {

	@Test
	public void variacionDeRendimientoTest() 
	{
		Instancia inst = new Instancia();
		inst.jugadores = new Jugador[4];
		
		inst.jugadores[0] = new Jugador("Juan", "arquero", 	10);
		inst.jugadores[1] = new Jugador("Pedro", "delantero", 	8);
		inst.jugadores[2] = new Jugador("Sergio", "mediocampo", 	6);
		inst.jugadores[3] = new Jugador("Leo", "defensor", 	7);
		
		inst.matrizDeRendimiento = new int[4][4];
		
		inst.matrizDeRendimiento[0][0] = 0;
		inst.matrizDeRendimiento[0][1] = -5;
		inst.matrizDeRendimiento[0][2] = -10;
		inst.matrizDeRendimiento[0][3] = -50;
		inst.matrizDeRendimiento[1][0] = -5;
		inst.matrizDeRendimiento[1][1] = 0;
		inst.matrizDeRendimiento[1][2] = -1;
		inst.matrizDeRendimiento[1][3] = -25;
		inst.matrizDeRendimiento[2][0] = -10;
		inst.matrizDeRendimiento[2][1] = -1;
		inst.matrizDeRendimiento[2][2] = 0;
		inst.matrizDeRendimiento[2][3] = 15;
		inst.matrizDeRendimiento[3][0] = -50;
		inst.matrizDeRendimiento[3][1] = -25;
		inst.matrizDeRendimiento[3][2] = 15;
		inst.matrizDeRendimiento[3][3] = 0;
		
		int [] jugadoresElegidos = {1,1,1,0,0};
		
		Subconjunto s = new Subconjunto(jugadoresElegidos, inst);
		
		
		assertEquals(9.5, s.variacionDeRendimiento(inst.getRendimientoIndividual(0)/*Rendimiento de Juan*/ , 
				inst.matrizDeRendimiento[0][1]),0.1);
		
	} 
	
	
	
	
	@Test
	public void rendimientoEnConjuntoTest()
	{
		Instancia inst = new Instancia();
		inst.jugadores = new Jugador[4];
		
		inst.jugadores[0] = new Jugador("Juan", "arquero", 	10);
		inst.jugadores[1] = new Jugador("Pedro", "delantero", 	8);
		inst.jugadores[2] = new Jugador("Sergio", "mediocampo", 	6);
		inst.jugadores[3] = new Jugador("Leo", "defensor", 	7);
		
		inst.matrizDeRendimiento = new int[4][4];
		
		inst.matrizDeRendimiento[0][0] = 0;
		inst.matrizDeRendimiento[0][1] = -5;
		inst.matrizDeRendimiento[0][2] = -10;
		inst.matrizDeRendimiento[0][3] = -50;
		inst.matrizDeRendimiento[1][0] = -5;
		inst.matrizDeRendimiento[1][1] = 0;
		inst.matrizDeRendimiento[1][2] = -1;
		inst.matrizDeRendimiento[1][3] = -25;
		inst.matrizDeRendimiento[2][0] = -10;
		inst.matrizDeRendimiento[2][1] = -1;
		inst.matrizDeRendimiento[2][2] = 0;
		inst.matrizDeRendimiento[2][3] = 15;
		inst.matrizDeRendimiento[3][0] = -50;
		inst.matrizDeRendimiento[3][1] = -25;
		inst.matrizDeRendimiento[3][2] = 15;
		inst.matrizDeRendimiento[3][3] = 0;
				
		int [] jugadoresElegidos = {1,1,1,0};
		
		Subconjunto s = new Subconjunto(jugadoresElegidos, inst);
		
		assertEquals(8.55, s.rendimientoEnConjunto(0, inst.matrizDeRendimiento),0.1);
							
	}
	
	
	@Test
	public void rendimientoTotalTest()
	{
		Instancia inst = new Instancia();
		inst.jugadores = new Jugador[4];
		
		inst.jugadores[0] = new Jugador("Juan", "arquero", 	10);
		inst.jugadores[1] = new Jugador("Pedro", "delantero", 	8);
		inst.jugadores[2] = new Jugador("Sergio", "mediocampo", 	6);
		inst.jugadores[3] = new Jugador("Leo", "defensor", 	7);
		
		inst.matrizDeRendimiento = new int[4][4];
		
		inst.matrizDeRendimiento[0][0] = 0;
		inst.matrizDeRendimiento[0][1] = -5;
		inst.matrizDeRendimiento[0][2] = -10;
		inst.matrizDeRendimiento[0][3] = -50;
		inst.matrizDeRendimiento[1][0] = -5;
		inst.matrizDeRendimiento[1][1] = 0;
		inst.matrizDeRendimiento[1][2] = -1;
		inst.matrizDeRendimiento[1][3] = -25;
		inst.matrizDeRendimiento[2][0] = -10;
		inst.matrizDeRendimiento[2][1] = -1;
		inst.matrizDeRendimiento[2][2] = 0;
		inst.matrizDeRendimiento[2][3] = 15;
		inst.matrizDeRendimiento[3][0] = -50;
		inst.matrizDeRendimiento[3][1] = -25;
		inst.matrizDeRendimiento[3][2] = 15;
		inst.matrizDeRendimiento[3][3] = 0;
				
		int [] jugadoresElegidos = {1,1,1,0};
		
		Subconjunto s = new Subconjunto(jugadoresElegidos, inst);
		
		assertEquals(21.41, s.rendimiento(),0.1);
		
	}

}
