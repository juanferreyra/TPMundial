package negocio;

//Representa un suconjunto que es una posile solucion a problema
public class Subconjunto 
{
	public int[] j;
	public Instancia instancia;
	
	public Subconjunto(int [] a, Instancia inst)
	{
		j = a.clone();
		instancia = inst;
	}
	
	public int cantidadDeJugadores()
	{
		int ret = 0;
		for(int i=0; i<instancia.getCantidad(); ++i)
		{
			if( j[i] == 1 )
				ret += 1;
		}
		
		return ret;
	}
	
	
	public double rendimiento()
	{
		double rendimientoTotal = 0;
		
		for (int i=0; i < instancia.getCantidad(); ++i) 
		{
			if(j[i] == 1) // Si el jugador de la posicion [i] esta en el equipo
				rendimientoTotal += rendimientoEnConjunto(i/*jugador en la pos [i] del arreglo jugadores*/, instancia.matrizDeRendimiento);		
		}
		
		return rendimientoTotal;
	}
	
	//Calcula el rendimiento de un jugador dependiendo de los compañeros de equipo que tenga
	public double rendimientoEnConjunto(int Jugadorelegido/*Indice del jugador en la lista de jugadores*/, int[][] rendimientos)
	{	
		double rendimiento = instancia.getRendimientoIndividual(Jugadorelegido);
		
		for (int i = 0; i < instancia.getCantidad(); i++) 
		{
			if(j[i] == 1)
			{
				int porcentajeDeVariacion = rendimientos[i][Jugadorelegido];
				
				rendimiento = variacionDeRendimiento(rendimiento, porcentajeDeVariacion);
			}
		}
		return rendimiento;
	}
	
	//Calcula como varia el rendimiento de un jugador al estar en el mismo equipo que otro
	public double variacionDeRendimiento(double rendimientoJugador, int porcentajeDeVariacion/*al jugar con otro jugador*/)
	{
		
		return rendimientoJugador + ( (double)(rendimientoJugador * (porcentajeDeVariacion) ) / 100 );
		
	}
	
	public void mostrar()
	{
		for(int i=0; i<instancia.getCantidad(); ++i)
		{
			if( j[i] == 1 )
				instancia.getJugador(i).mostrar();
		}
	} 
	
	//	 * AR = arquero
	//	 * DF = defensor
	//	 * MD = mediocampista
	//	 * DL = delantero
	private int[] formacionSubconjunto() 
	{
		int[] formacion = new int[4];
		
		for (int i = 0; i < instancia.getCantidad(); i++) 
		{	
			
			if(j[i]==1)
			{
				String posJugador = instancia.getJugador(i)._posicion;
				
				if(posJugador.equals("AR")) 
				{
					//si es arquero
					formacion[0]+=1;
				}
				else if(posJugador.equals("DF"))
				{
					//si es defensor
					formacion[1]+=1;
				}
				else if(posJugador.equals("MD"))
				{
					//si es mediocampista
					formacion[2]+=1;
				}
				else
				{
					//si es delantero
					formacion[3]+=1;
				}
			}
		}
		
		return formacion;
	}
	
	public boolean esFormacionValida()
	{
		//defino mis formaciones validas 4-4-2, 4-3-3, 4-5-1 o 5-4-1
		int[] formac1 = new int[]{1,4,4,2};
		int[] formac2 = new int[]{1,4,3,3};
		int[] formac3 = new int[]{1,4,5,1};
		int[] formac4 = new int[]{1,5,4,1};
		
		//formacion del subconjunto actual
		
		int[] formSubconjunto = formacionSubconjunto();
		
		if(formSubconjunto.equals(formac1) 
				|| formSubconjunto.equals(formac2) 
				|| formSubconjunto.equals(formac3) 
				|| formSubconjunto.equals(formac4))
			return true;
		else
			return false;
	}

}
