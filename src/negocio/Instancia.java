package negocio;

//Modela una instancia del prolema
public class Instancia 
{
	private Jugador[] _jugadores;
	//Almacena la variacion de rendimiento entre 2 jugadores
	//si llegaran a formar parte del mismo equipo
	private int[][] _variacionDeRendimiento;
	private int _agregados;
	
	//Constructor
	public Instancia(int cantJugadores)
	{
		_jugadores = new Jugador[cantJugadores];
		_variacionDeRendimiento = new int[cantJugadores][cantJugadores];
		_agregados = 0;
	}
	
	public int[][] getMatrizDeRendimiento() 
	{
		return _variacionDeRendimiento;
	}
	
	public int  cantidadJugadores()
	{
		return _jugadores.length;
	}
	
	public void agregarJugador(String nombre, String posicion, int rendimiento)
	{
		if(_agregados != _jugadores.length)
		{
			_jugadores[_agregados] = new Jugador(nombre, posicion, rendimiento);
			_agregados ++;
		}
		else
		{
			System.out.println("error en indice");
			throw new IndexOutOfBoundsException();
		}
	}
	
	public void agregarVariacionRendimiento(int x, int y, int variacion)
	{
		_variacionDeRendimiento[x][y] = variacion;
		_variacionDeRendimiento[y][x] = variacion;
	}
	
	//Toma el indice de un jugador en el arreglo de jugadores
	//y devuelve su rendimiento individual
	public int rendimientoDeJugador(int i)
	{
		return _jugadores[i].getRendimiento();
	}
	
	//Toma el indice de un jugador en el arreglo de jugadores
	// y devuelve dicho jugador
	public Jugador getJugador(int i)
	{
		return _jugadores[i];
	}


}
