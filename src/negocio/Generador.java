package negocio;

//Genera todos los subconjuntos posibles permutando unos y ceros en un array
//cuya longitud depende de la cantidad de jugadores de la insstancia
public class Generador
{
	private Instancia instancia;
	private int cantJugadores;
	//Array utilizado para contener los subconjuntos
	//que se van generando
	private int[] a;
	
	
	public int getCantJugadores() 
	{
		return cantJugadores;
	}

	public void setCantJugadores(int cantJugadores) 
	{
		this.cantJugadores = cantJugadores;
	}

	public int[] getA()
	{
		return a;
	}

	public void setA(int[] a) 
	{
		this.a = a;
	}

	//Costructor
	public Generador(Instancia inst)
	{
		instancia = inst;
		cantJugadores = inst.getCantidad();
		//Se suma 1 para poder calcular cuando se llega al numero
		//maximo de permutaciones posibles con cierta cantidad de jugadores
		a = new int [cantJugadores + 1]; 
	}

	//Indica si existe un subconjunto que todavia no se genero
	public boolean hasNext()
	{
		//Cuando el ultimo valor es uno ya no hay 
		//mas permutaciones posibles
		return a[cantJugadores] == 0; 
	}
	
	//Devuelve el subconjunto siguiente al actual
	public Subconjunto next()
	{
		sumarUno();
		return new Subconjunto(a, instancia);
	}
	
	//Toma el array "a" como un numero binario que se lee de
	//derecha a izquierda y le suma uno al valor de dicho numero
	private void sumarUno()
	{
		int i = 0;
		while( a[i] == 1 )
		{
			a[i] = 0;
			++i;
		}
		
		a[i] = 1;
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
