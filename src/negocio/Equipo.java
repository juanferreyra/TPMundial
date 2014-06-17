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
				if(elMejor==null || elMejor.rendimientoTotal() < actual.rendimientoTotal())
					elMejor = actual;
			}
		}
		
		elMejor.mostrar();
		
	}
	
	public static void main(String[] args) 
	{
		Instancia inst = new Instancia(23);
		
		inst.agregarJugador("Sergio Romero","AR",9);
		inst.agregarJugador("Mariano Andujar","AR",7);
		inst.agregarJugador("Agustin Orion","AR",8);
		inst.agregarJugador("Martin Demichelis","DF",8);
		inst.agregarJugador("Ezequiel Garay","DF",6);
		inst.agregarJugador("Federico Fernandez","DF",6);
		inst.agregarJugador("Jose Maria Basanta","DF",7);
		inst.agregarJugador("Hugo Campagnaro","DF",6);
		inst.agregarJugador("Marcos Rojo","DF",8);
		inst.agregarJugador("Pablo Zabaleta","DF",7);
		inst.agregarJugador("Javier Mascherano","MD",9);
		inst.agregarJugador("Fernando Gago","MD",8);
		inst.agregarJugador("Lucas Biglia","MD",7);
		inst.agregarJugador("Enzo Perez","MD",5);
		inst.agregarJugador("Maxi Rodriguez","MD",8);
		inst.agregarJugador("Ricky Alvarez","MD",9);
		inst.agregarJugador("Angel Di Maria","MD",10);
		inst.agregarJugador("Leo Messi","DL",10);
		inst.agregarJugador("Sergio Agüero","DL",9);
		inst.agregarJugador("Ezequiel Lavezzi","DL",7);
		inst.agregarJugador("Gonzalo Higuain","DL",9);
		inst.agregarJugador("Rodrigo Palacio","DL",8);
		inst.agregarJugador("Carlos Tevez","DL",9);
		
		inst.agregarVariacionRendimiento(1,0,100);
		inst.agregarVariacionRendimiento(2,0,100);
		inst.agregarVariacionRendimiento(2,1,100);
		inst.agregarVariacionRendimiento(4,1,-10);
		inst.agregarVariacionRendimiento(4,3,-10);
		inst.agregarVariacionRendimiento(6,0,3);
		inst.agregarVariacionRendimiento(7,5,43);
		inst.agregarVariacionRendimiento(8,0,-43);
		inst.agregarVariacionRendimiento(8,1,-50);
		inst.agregarVariacionRendimiento(10,3,23);
		inst.agregarVariacionRendimiento(11,6,56);
		inst.agregarVariacionRendimiento(12,0,-25);
		inst.agregarVariacionRendimiento(12,7,20);
		inst.agregarVariacionRendimiento(13,9,34);
		inst.agregarVariacionRendimiento(13,11,-30);
		inst.agregarVariacionRendimiento(14,4,-24);
		inst.agregarVariacionRendimiento(15,5,70);
		inst.agregarVariacionRendimiento(15,13,34);
		inst.agregarVariacionRendimiento(16,2,20);
		inst.agregarVariacionRendimiento(16,8,40);
		inst.agregarVariacionRendimiento(17,13,-50);
		inst.agregarVariacionRendimiento(17,16,-7);
		inst.agregarVariacionRendimiento(18,10,45);
		inst.agregarVariacionRendimiento(19,4,-20);
		inst.agregarVariacionRendimiento(19,15,-10);
		inst.agregarVariacionRendimiento(20,1,-41);
		inst.agregarVariacionRendimiento(20,18,43);
		inst.agregarVariacionRendimiento(21,7,-4);
		inst.agregarVariacionRendimiento(21,11,-1);
		inst.agregarVariacionRendimiento(21,17,30);
		inst.agregarVariacionRendimiento(22,2,78);
		inst.agregarVariacionRendimiento(22,8,-3);
		inst.agregarVariacionRendimiento(22,14,33);
		inst.agregarVariacionRendimiento(22,17,-100);
		inst.agregarVariacionRendimiento(22,19,-10);
		inst.agregarVariacionRendimiento(22,21,-40);


		Equipo.resolver(inst);
	}
	
}
