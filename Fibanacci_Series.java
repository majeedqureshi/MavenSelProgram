package JavaPrograms;

public class Fibanacci_Series {

	public static void main(String[] args) {
		// fibanacci sries are
		//0 1 1 2 3 5 8 13.............till 20 times
		int x=0;
			System.out.println(x);
		int y=1;
			System.out.println(y);
		int z=0;	
			
	//	for(int i=0; i<=20; i++) {// we assume i values to carryout fabanaci 
		//	z=x+y;
			//System.out.println(z);
			//for fibanacci x will replce wih y and y with z and list goes on
			//x=y; // we use this to change valuse of x al lthe times
			//y=z; //same as above
		// }
		
		int i = 0;
		while (i<=20) {
			z=x+y;
			System.out.println(z);
			i++;
			x=y;
			y=z;
			
		}

	}

}
