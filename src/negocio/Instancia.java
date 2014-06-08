package negocio;

//Modela una instancia del prolema
public class Instancia 
{
	public Jugador[] jugadores;
	public int[][] matrizDeRendimiento;
	
	public int  getCantidad()
	{
		return jugadores.length;
	}
	
	public int getRendimientoIndividual(int i)
	{
		return jugadores[i]._rendimiento;
	}
	
	public Jugador getJugador(int i)
	{
		return jugadores[i];
	}

}
