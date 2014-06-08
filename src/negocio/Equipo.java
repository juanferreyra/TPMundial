package negocio;

public class Equipo 
{
	
	public static void resolver(Instancia instanciamochi)
	{
		Generador generador = new Generador (instanciamochi);
		Subconjunto elMejor = null;
		
		while(generador.hasNext())
		{
			Subconjunto actual = generador.next();
			
			if(actual.cantidadDeJugadores()==11 && actual.esFormacionValida())
			{
				if(elMejor==null || elMejor.rendimiento()<actual.rendimiento())
					elMejor = actual;
			}
		}
		
		elMejor.mostrar();
		
	}
	
	public static void main(String[] args) 
	{
		//el main para testear 
	}
	
}
