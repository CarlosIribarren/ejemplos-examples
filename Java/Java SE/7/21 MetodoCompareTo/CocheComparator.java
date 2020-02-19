import java.util.Comparator;


public class CocheComparator implements Comparator<Coche>{

	@Override
	public int compare(Coche c1, Coche c2) {
		//ordenamos los coche de modo descendente
		
		// return 0 si son iguales
		// return -1  si es mayor
		// return 1  si es menor
		int respuesta=0;
		
		if ( c1.getPotencia() < c2.getPotencia() )
		{
			respuesta= 1;
		}
		else if(c1.getPotencia() > c2.getPotencia())
		{
			respuesta= -1;
		}
		else if(c1.getPotencia() == c2.getPotencia())
		{
			respuesta= 0;
		}
		return respuesta;
	}

}
