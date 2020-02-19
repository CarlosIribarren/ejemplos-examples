import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

//Specifying runtime retention policy
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation
{
 String author();    // Annotation member
 String date();      // Annotation member
}

//Applying annotation to the class
@MyAnnotation(author="Azim",date="22/10/2011,23/10/2011")
public class Main {
	
	// Applying annotation to the method
	@MyAnnotation(author="Azim",date="22/10/2011")
	public static void testMethod()
	{
		System.out.println("Welcome to Java");
		System.out.println("This is an example of Annotations");
	}
	
	 public static void main(String args[])
	 {
	     System.out.println("\n----------------------------------------------------");
		 System.out.println("------------ Anotaciones de los Metodos -------------\n");
	     //testMethod();
	   
	     System.out.println("\n----------------------------------------------------");
	     System.out.println("------------ Anotaciones de las Clases -------------\n");
	     showAnnotations();
	     
	     System.out.println("\n----------------------------------------------------");
	     System.out.println("------------ Mostrar contructores de una clase --------\n");
	     showClase();
	 }
 
	 public static void showAnnotations() {
		 //Function to show annotation information
		 Main test=new Main(); // Instantiating Test class
		 try{
			 Class c=test.getClass(); // Getting Class reference
			 Method m=c.getMethod("testMethod"); // Getting Method reference
			 // Getting Class annotation
			 MyAnnotation annotation1=
					 (MyAnnotation)c.getAnnotation(MyAnnotation.class);
			 // Getting Method annotation
			 MyAnnotation annotation2=m.getAnnotation(MyAnnotation.class);
			 // Displaying annotation information
			 System.out.println("Author of the class: "+annotation1.author());
			 // Displaying annotation information
			 System.out.println("Date of Writing the class: "+annotation1.date());
			 // Displaying annotation information
			 System.out.println("Author of the method: "+annotation2.author());
			 // Displaying annotation information
			 System.out.println("Date of Writing the method: "+annotation2.date());
		 } catch(NoSuchMethodException ex) {
			 System.out.println("Invalid Method..."+ex.getMessage());
		 }
	 }
	 
	 public static void showClase()
	 {
		 System.out.println("Regresion para la clase Coche");
		 
		 Coche c1 = new Coche();
		 Class c=c1.getClass(); 
		 
		 //obtener contructores
		 Constructor[]  arrayContructores = c.getConstructors();
		 
		 System.out.println("\nImprimir los contructores con los tipos de datos\n");
		 for (int a =0 ; a<arrayContructores.length;a++)
		 {
			 System.out.println( "\n"+a+" - Contructor : " + arrayContructores[a].getName());
			 Class[] parametros =  arrayContructores[a].getParameterTypes();

			 	System.out.print("\tParametros : ");
			 
				 for ( Class p : parametros)
				 {
					 System.out.print(p.getName());
				 }
			 
			 
		 }
		 //obtener metodos
		 Method[] metodos = c.getMethods();
		 
		 System.out.println("Metodos de la clase :");
		 for (Method m : metodos)
		 {
			 System.out.println("\t-Metodo " + m.getName() + "()");
		 }
		 
		 
	 }
}