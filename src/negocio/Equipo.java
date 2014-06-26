package negocio;
//Esta clase contiene el metodo resolver(), el cual encuentra 
//el mejor equipo segun las condiciones dadas
public class Equipo 
{
    
	public static void resolver(Instancia instancia)
	{
		Generador generador = new Generador (instancia);
		Subconjunto elMejor = null;
		
		//Mientras halla otro subconjunto por generar
		while(generador.hasNext())
		{
			//Genera un subconjunto nuevo
			Subconjunto actual = generador.next();
			
			if(actual.cantidadDeJugadores()==11 && actual.esFormacionValida())
			{
				if(elMejor==null || elMejor.variacionRendimientoTotal() < actual.variacionRendimientoTotal())
					elMejor = actual;
			}
		}
		
		elMejor.mostrar();
	}
	
}