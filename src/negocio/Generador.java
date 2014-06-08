package negocio;

//Genera todos los subconjuntos posibles
public class Generador
{
	private Instancia instancia;
	private int cantJugadores;
	private int[] a;
	
	public Generador(Instancia inst)
	{
		instancia = inst;
		cantJugadores = inst.getCantidad();
		a = new int [cantJugadores + 1]; //Se suma 1 para calcular el nº max de permutaciones
	}
	
	public boolean hasNext()
	{
		//Cuando el ultimo valor es uno ya no hay 
		//mas permutaciones posibles
		return a[cantJugadores] == 0; 
	}
	
	public Subconjunto next()
	{
		sumarUno();
		return new Subconjunto(a, instancia);
	}
	
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
