package negocio;

public class Jugador 
{
	private String _nombre;
	private String _posicion;
	private int _rendimiento;
	
	
	public String get_nombre() 
	{
		return _nombre;
	}

	public void set_nombre(String _nombre) 
	{
		this._nombre = _nombre;
	}

	public String get_posicion() 
	{
		return _posicion;
	}

	public void set_posicion(String _posicion) 
	{
		this._posicion = _posicion;
	}

	public int get_rendimiento() 
	{
		return _rendimiento;
	}

	public void set_rendimiento(int _rendimiento) 
	{
		this._rendimiento = _rendimiento;
	}
	
	
	//	La posicion se ingresa como:	
	//  AR = arquero
	//	DF = defensor
	//	MD = mediocampista
	//	DL = delantero
	
	//Constructor
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
