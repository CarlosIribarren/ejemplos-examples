
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Contents of the array :" );
		//Example array
		Integer data[][] ={{1,2},{3,4,5},{6,7}};

		for (int counterA = 0; counterA < data.length; counterA++) {
			System.out.println( "Fila : " + counterA  );
			for (int counterB = 0; counterB < data[counterA].length; counterB++) {
				System.out.print(data[counterA][counterB] + " ");
			}
			System.out.println(" ");
		}
		
		System.out.println("------------------------------------- ");
		
		
		//Example array2
		Integer data2[][] ={{1,2},{3,4,5},{6,7}};

		for (Integer row[]: data2) 
		{
			//el elemento row recibe toda la fila entera
			
			for (Integer item : row )
			{
				System.out.print(item + " ");
			}
			System.out.println(" ");
		}		
		
	}

}
