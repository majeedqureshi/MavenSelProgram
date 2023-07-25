package JavaPrograms;

public class ChildClass extends ParentClass{
	//when child class extends he parent class all the parent class method are variable can access by child class object
	//extends is a key to connect both ChildClass and ParentClass
	String name = "Giddu";
	int rno = 2708;
	
	// if there is name conflict in between child class and parent class variables by default child class variables will be representing..
	// super key word need use when there is name conflict in between the child  class and parent class
	// super represents always immediate parent class
	
	public void methodB(){
	System.out.println(super.name+"   " + super.rno);
	
}		

	public static void main(String[] args) {
		
		ChildClass obj = new ChildClass();
 		obj.methodB();
 		

	}

}
