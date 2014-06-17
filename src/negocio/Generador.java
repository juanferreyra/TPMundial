package negocio;

//Genera todos los subconjuntos posibles permutando unos y ceros en un array
//cuya longitud depende de la cantidad de jugadores de la insstancia
public class Generador
{
	private Instancia _instancia;
	private int _cantJugadores;
	//Array utilizado para contener los subconjuntos
	//que se van generando
	private int[] _jugadoresSeleccionados;
	
	public Generador(Instancia inst)
	{
		_instancia = inst;
		_cantJugadores = inst.cantidadJugadores();
		//Se suma 1 para poder calcular cuando se llega al numero
		//maximo de permutaciones posibles con cierta cantidad de jugadores
		_jugadoresSeleccionados = new int [_cantJugadores + 1]; 
	}
	
	public int getCantJugadores() 
	{
		return _cantJugadores;
	}

	//Indica si existe un subconjunto que todavia no se genero
	public boolean hasNext()
	{
		//Cuando el ultimo valor es uno, ya no hay 
		//mas permutaciones posibles
		return _jugadoresSeleccionados[_cantJugadores] == 0; 
	}
	
	//Devuelve el subconjunto siguiente al actual
	public Subconjunto next()
	{
		sumarUno();
		return new Subconjunto(_jugadoresSeleccionados, _instancia);
	}
	
	//Toma el array "a" como un numero binario que se lee de
	//derecha a izquierda y le suma uno al valor de dicho numero
	private void sumarUno()
	{
		int i = 0;
		while( _jugadoresSeleccionados[i] == 1 )
		{
			_jugadoresSeleccionados[i] = 0;
			++i;
		}
		
		_jugadoresSeleccionados[i] = 1;
	}
	
	public void mostrar(int[] a) 
	{
		for (int i = a.length-1; i >= 0 ; --i) 
		{
			System.out.print(a[i]);
		}
		
		System.out.println("");
	}

}
