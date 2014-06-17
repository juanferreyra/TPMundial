package negocio;

public class Jugador 
{
	private String _nombre;
	private String _posicion;
	private int _rendimiento;
	
	/*	La posicion se ingresa como:	
	*  	AR = arquero
	*	DF = defensor
	*	MD = mediocampista
	*	DL = delantero */
	
	public Jugador(String nombre, String posicion, int rendimiento)
	{
		_nombre = nombre;
		_rendimiento = rendimiento;
		_posicion = posicion;
	}
	
	public String getNombre() 
	{
		return _nombre;
	}

	public void setNombre(String nombre) 
	{
		_nombre = nombre;
	}

	public String getPosicion() 
	{
		return _posicion;
	}

	public void setPosicion(String posicion) 
	{
		_posicion = posicion;
	}

	public int getRendimiento() 
	{
		return _rendimiento;
	}

	public void setRendimiento(int rendimiento) 
	{
		_rendimiento = rendimiento;
	}
	
	public void mostrar()
	{
		System.out.println("Nombre: " + _nombre + " - Posicion: " + _posicion);
	}

}
