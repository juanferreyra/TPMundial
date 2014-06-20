package negocio;

import static org.junit.Assert.*;
import org.junit.Test;

public class SucunjuntoTest 
{

	@Test
	public void variacionDeRendimientoTest() 
	{
		Instancia inst = new Instancia(4);
		
		inst.agregarJugador("Juan","AR",10);
		inst.agregarJugador("Pedro","DER",8);
		inst.agregarJugador("Sergio","MED",6);
		inst.agregarJugador("Leo","DEF",7);
		
		inst.agregarVariacionRendimiento(0, 0, 0);
		inst.agregarVariacionRendimiento(0, 1, -5);
		inst.agregarVariacionRendimiento(1, 1, 0);
		inst.agregarVariacionRendimiento(0, 2, -10);
		inst.agregarVariacionRendimiento(1, 2, -1);
		inst.agregarVariacionRendimiento(2, 2, 0);
		inst.agregarVariacionRendimiento(0, 3, -50);
		inst.agregarVariacionRendimiento(1, 3, -35);
		inst.agregarVariacionRendimiento(2, 3, 15);
		inst.agregarVariacionRendimiento(3, 3, 0);
		
		int [] jugadoresElegidos = {1,1,1,0,0};
		
		Subconjunto s = new Subconjunto(jugadoresElegidos, inst);
		
		assertEquals(9.5, s.variacionDeRendimiento(inst.rendimientoDeJugador(0)/*Rendimiento de Juan*/ , 
				inst.getVariacionDeRendimiento()[0][1]),0.1);
	} 
		
	@Test
	public void rendimientoEnConjuntoTest()
	{
		Instancia inst = new Instancia(4);
		
		inst.agregarJugador("Juan","AR",10);
		inst.agregarJugador("Pedro","DER",8);
		inst.agregarJugador("Sergio","MED",6);
		inst.agregarJugador("Leo","DEF",7);
		
		inst.agregarVariacionRendimiento(0, 0, 0);
		inst.agregarVariacionRendimiento(0, 1, -5);
		inst.agregarVariacionRendimiento(1, 1, 0);
		inst.agregarVariacionRendimiento(0, 2, -10);
		inst.agregarVariacionRendimiento(1, 2, -1);
		inst.agregarVariacionRendimiento(2, 2, 0);
		inst.agregarVariacionRendimiento(0, 3, -50);
		inst.agregarVariacionRendimiento(1, 3, -35);
		inst.agregarVariacionRendimiento(2, 3, 15);
		inst.agregarVariacionRendimiento(3, 3, 0);
				
		int [] jugadoresElegidos = {1,1,1,0};
		
		Subconjunto s = new Subconjunto(jugadoresElegidos, inst);
		
		assertEquals(8.55, s.rendimientoEnConjunto(0, inst.getVariacionDeRendimiento()),0.1);
	}
	
	@Test
	public void rendimientoTotalTest()
	{
		Instancia inst = new Instancia(4);
		
		inst.agregarJugador("Juan","AR",10);
		inst.agregarJugador("Pedro","DER",8);
		inst.agregarJugador("Sergio","MED",6);
		inst.agregarJugador("Leo","DEF",7);
		
		inst.agregarVariacionRendimiento(0, 0, 0);
		inst.agregarVariacionRendimiento(0, 1, -5);
		inst.agregarVariacionRendimiento(1, 1, 0);
		inst.agregarVariacionRendimiento(0, 2, -10);
		inst.agregarVariacionRendimiento(1, 2, -1);
		inst.agregarVariacionRendimiento(2, 2, 0);
		inst.agregarVariacionRendimiento(0, 3, -50);
		inst.agregarVariacionRendimiento(1, 3, -35);
		inst.agregarVariacionRendimiento(2, 3, 15);
		inst.agregarVariacionRendimiento(3, 3, 0);
				
		int [] jugadoresElegidos = {1,1,1,0};
		
		Subconjunto s = new Subconjunto(jugadoresElegidos, inst);
		
		assertEquals(21.41, s.rendimientoTotal(),0.1);
	}

}
