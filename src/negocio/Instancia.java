package negocio;

//Modela una instancia del prolema
public class Instancia 
{
	private Jugador[] jugadores;
	//Almacena la variacion de rendimiento entre 2 jugadores
	//si llegaran a formar parte del mismo equipo
	private int[][] matrizDeRendimiento;
	
	
	public Jugador[] getJugadores() 
	{
		return jugadores;
	}

	public void setJugadores(Jugador[] jugadores) 
	{
		this.jugadores = jugadores;
	}

	public int[][] getMatrizDeRendimiento() 
	{
		return matrizDeRendimiento;
	}

	public void setMatrizDeRendimiento(int[][] matrizDeRendimiento) 
	{
		this.matrizDeRendimiento = matrizDeRendimiento;
	}
	
	//Constructor
	public Instancia(int cantJugadores)
	{
		setJugadores(new Jugador[cantJugadores]);
		setMatrizDeRendimiento(new int[cantJugadores][cantJugadores]);
	}
	
	//Retorna la cantidad de jugadores que tiene la instancia
	public int  getCantidad()
	{
		return getJugadores().length;
	}
	
	//Toma el indice de un jugador en el arreglo de jugadores
	//y devuelve su rendimiento individual
	public int getRendimientoIndividual(int i)
	{
		return getJugadores()[i].get_rendimiento();
	}
	
	//Toma el indice de un jugador en el arreglo de jugadores
	// y devuelve dicho jugador
	public Jugador getJugador(int i)
	{
		return getJugadores()[i];
	}


}
