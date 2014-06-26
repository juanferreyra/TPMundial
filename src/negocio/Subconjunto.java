package negocio;

//Representa un suconjunto que es una posile solucion a problema
public class Subconjunto 
{
	//Representa con 1 a los elementos (jugadores en este caso)
	// que forman parte del subconjunto y con 0 los que no
	private int[] _jugadoresSeleccionados;
	private Instancia _instancia;
    private int[] _formacSubconjunto;
	
	public Subconjunto(int [] a, Instancia inst)
	{
		_jugadoresSeleccionados = a.clone();
		_instancia = inst;
		_formacSubconjunto = new int[4];
	}
	
	public int cantidadDeJugadores()
	{
		int ret = 0;
		for(int i=0; i<_instancia.cantidadJugadores(); ++i)
		{
			if( _jugadoresSeleccionados[i] == 1 )
				ret += 1;
		}
		
		return ret;
	}
	
	//Retorna el rendimiento total de el equipo representado
	// por el subconjunto en cuestion
	public double variacionRendimientoTotal()
	{
		double rendimientoFinal = 0;
		
		for (int i=0; i < _instancia.cantidadJugadores(); ++i) 
		{
			if(_jugadoresSeleccionados[i] == 1) // Si el jugador de la posicion [i] esta en el equipo
				rendimientoFinal += variacionRendimientoJugador(i/*jugador en la pos [i] del arreglo jugadores*/, _instancia.getVariacionDeRendimiento());		
		}
		
		return rendimientoFinal;
	}
	
	//Calcula el rendimiento de un jugador dependiendo de los compañeros que tenga en el equipo
	//debimos ponerla con visibilidad protected para poder envaluarla en la clase test
	protected double variacionRendimientoJugador(int jugadorelegido/*Indice del jugador en la lista de jugadores*/, int[][] rendimientos)
	{	
		double rendimiento = _instancia.rendimientoDeJugador(jugadorelegido);
		
		for (int i = 0; i < _instancia.cantidadJugadores(); i++) 
		{
			if(_jugadoresSeleccionados[i] == 1)
			{
				int porcentajeDeVariacion = rendimientos[i][jugadorelegido];
				
				rendimiento = variacionDeRendimiento(rendimiento, porcentajeDeVariacion);
			}
		}
		return rendimiento;
	}
	
	//Calcula como varia el rendimiento de un jugador al estar en el mismo equipo que otro jugador
	//debimos ponerla con visibilidad protected para poder envaluarla en la clase test
	protected double variacionDeRendimiento(double rendimientoJugador, int porcentajeDeVariacion/*al jugar con otro jugador j */)
	{
		return rendimientoJugador + ((double)(rendimientoJugador * (porcentajeDeVariacion) ) / 100 );	
	}
	
	public void mostrar()
	{
		for(int i = 0; i <_instancia.cantidadJugadores(); i++)
		{
			if( _jugadoresSeleccionados[i] == 1 )
				_instancia.getJugador(i).mostrar();
		}
	} 
	
	/*Recordemos las leyendas de posicion!
	 * AR = arquero
	 * DF = defensor
	 * MD = mediocampista
	 * DL = delantero */
	
	public boolean esFormacionValida()
    {
	    //genero la formacion de mi subconjunto
	    generarformacion();
	    
        //Defino mis formaciones validas: 4-4-2, 4-3-3, 4-5-1 o 5-3-2
        int[] formac1 = new int[]{1,4,4,2};
        int[] formac2 = new int[]{1,4,3,3};
        int[] formac3 = new int[]{1,4,5,1};
        int[] formac4 = new int[]{1,5,3,2};
        
        //devuelve verdadero si la formacion de
        return(formarcionIgual(formac1)
            || formarcionIgual(formac2) 
            || formarcionIgual(formac3) 
            || formarcionIgual(formac4));
 
    }
	
	private boolean formarcionIgual(int[] otraFormacion)
    {
        return(_formacSubconjunto[0]==otraFormacion[0] &&
            _formacSubconjunto[1]==otraFormacion[1] &&
            _formacSubconjunto[2]==otraFormacion[2] &&
            _formacSubconjunto[3]==otraFormacion[3]);
    }
	
	//Genera la formacion que posee el subconjunto en cuestion seteando la variable _formacionSubconjunto
	private void generarformacion() 
	{
		//Arreglo que almacena la formacion del subconjunto
		//almacenando cada tipo de jugador en una posicion diferente
		for (int i = 0; i < _instancia.cantidadJugadores(); i++) 
		{	
			//Si el jugador [i] forma parte del equipo
			if(_jugadoresSeleccionados[i]==1)
			{
				String posJugador = _instancia.getJugador(i).getPosicion();
				
				//Si es arquero
				if(posJugador.equals("AR"))
					//Agrego un jugador en la pos. 0
				    _formacSubconjunto[0]+=1;
				//Si es defensor
				else if(posJugador.equals("DF"))
					//Agrego un jugador en la pos. 1
				    _formacSubconjunto[1]+=1;
				//Si es mediocampista
				else if(posJugador.equals("MD"))
					//Agrego un jugador en la pos. 2
				    _formacSubconjunto[2]+=1;
				//Si es delantero
				else
					//Agrego un jugador en la pos. 3
				    _formacSubconjunto[3]+=1;
			}
		}

	}
	
}
