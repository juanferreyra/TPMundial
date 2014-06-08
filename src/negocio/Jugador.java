package negocio;

public class Jugador 
{
	public String _nombre;
	public String _posicion;
	public int _rendimiento;
	
	//	La posicion se ingresa como:	
	//  AR = arquero
	//	DF = defensor
	//	MD = mediocampista
	//	DL = delantero
	public Jugador(String nombre, String posicion, int rendimiento)
	{
		_nombre = nombre;
		_rendimiento = rendimiento;
		_posicion = posicion;
	}
	
	public void mostrar()
	{
		System.out.println("Nombre: " + _nombre + " - Posicion: " + _posicion);
	}

}
