import java.util.Arrays;


public class Persona {
	
	private String nombre;
	private String amigos[];
	
	public Persona(Integer numeroAmigos){
		amigos=null;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String[] getAmigos() {
		return amigos;
	}
	public void setAmigos(String[] amigos) {
		this.amigos = amigos;
	}


	public void añadirAmigo(String persona)
	{
		if (amigos==null)
		{
			//primera vez
			//añadir un amigo en la ultima posicion
			amigos=new String[1];
			amigos[0] = persona;
		}
		else
		{
			Integer totalPosiciones = amigos.length;
			//crear un array mayor
			String cambio[] = new String[totalPosiciones+1];
			//recoger valores que tenemos guardados
			for (int a=0 ; a<amigos.length;a++)
			{
				cambio[a]=amigos[a];
			}
			//Crear un array de una posicion mas
			amigos = new String[totalPosiciones+1];
			//volcamos la info en el array nuevo
			amigos=cambio;
			//añadir un amigo en la ultima posicion
			amigos[totalPosiciones] = persona;
		}


	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", amigos="
				+ Arrays.toString(amigos) + "]";
	}
}
