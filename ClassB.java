package JavaPrograms;

public class ClassB {
	
	///we can make varaiable methods as static
	//
	static String x = "Bubu";
	int rno = 107;
	double fee = 10900.00;
	
	//static method can access directly without creating an object by providing its ClassName
	//ClassName.methodname
	
	//in static method only static variable can access
	//if you access any method in static variable then the variable must be static
	static void methodB() {
	System.out.println(x);

	}

	public static void main(String[] args) {
		ClassB obj = new ClassB();
		//obj.methodB();
		ClassB.methodB();

	//adding object behalf of other class is called aggregation
	//combining multiple classes in a single unit is call data encaptulation	
	// the below method used to call ClassA	
		ClassA obj1 = new ClassA();
		obj1.methodA();
				
	}

}
