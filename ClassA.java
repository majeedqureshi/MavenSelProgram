package JavaPrograms;

public class ClassA {
	String name = "Dudu";
	int rno = 106;
	double fee = 10500.00;
	
	void methodA() {
	System.out.println(name);

	}

	public static void main(String[] args) {
		ClassA obj = new ClassA();
		//obj.methodA();
		
		//variable also may be static
		//static variable can be access directly without creating an object
		// it can be access by providing its name.... CLassName.variable
		//for my understanding while recalling you can change variable name as well in other class 
		ClassB.x ="giddu"; 
		ClassB.methodB();
		
	}

}
