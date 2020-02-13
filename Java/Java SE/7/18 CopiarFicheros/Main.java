
public class Main {

	public static void main(String[] args) {
		if(args.length == 2)
			new FileCopy(args[0], args[1]);
		else
			System.out.println("Debe ingresar dos parametros");
	}

}
