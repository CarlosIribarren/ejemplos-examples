
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer number1 = 0;
		Integer result1;
		
		//Example “if - else”
		if ( number1==0 ) 
		{
			result1 = number1+1;
		}
		else 
		{
			result1=0;
		} 
		
		Integer number2 = 0;
		Integer result2;
		
		
		//Example ?
		result2 = (number2==0)? number2+10 : number2;
		
		System.out.println("result1 = " + result1 );
		System.out.println("result2 = " + result2 );
		
		//Example Switch
		switch (result2) {
		case 10:
			System.out.println("Result2 es 10");
			break;

		default:
			System.out.println("Result2 es diferente de 10");
			break;
		}
		
	}

}
