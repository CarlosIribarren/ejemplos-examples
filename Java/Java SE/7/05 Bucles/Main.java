
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Example “while”
		Integer data[] ={1,2,3,4,5};
		Integer counter=0;
		Integer result=0;
		while (counter<data.length) {
			result=result+data[counter];
			counter=counter+1;
		}
		
		System.out.println("Result for while : " + result );
		
		

		//Example “do - while”
		Integer data2[] ={1,2,3,4,5};
		Integer counter2=0;
		Integer result2=0;
		do {
			result2=result2+data2[counter2];
			counter2=counter2+1;
		} while (counter2<data2.length);
		
		
		System.out.println("Result for do while : " + result2 );
		
		
		//Example for
		Integer data3[] ={1,2,3,4,5};
		Integer result3=0;
		for (int counter3 = 0; counter3 < data3.length; counter3++) {
			result3=result3+data3[counter3];
		}
		
		System.out.println("Result for for : " + result3 );
	}

}
