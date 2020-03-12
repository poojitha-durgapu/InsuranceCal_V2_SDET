package practiceExc;

public class ConstructorExc {
	
	String College = "ABC University";
	String StudentName;
	String City;
	int Marks;
	
	public ConstructorExc() {
		System.out.println("default constructor");
	}
	public ConstructorExc(String name,String city,int marks) {
		StudentName = name;
		City = city;
		Marks = marks;
		
	}
	public ConstructorExc(String name,String city,int marks,String college) {
		StudentName = name;
		City = city;
		Marks = marks;
		College = college;
		
	}
	public void studentDetails() {
	System.out.println(StudentName+ " from "+ City+" is studying in "+ College);
		
	}
	public void studentResult() {
		if(Marks > 45) {
			System.out.println(StudentName+" studying in "+ College+ " had passed in exam");
			System.out.println("###################################");
		}
		else {
			System.out.println(StudentName+" studying in "+ College+ " had failed in exam");
			System.out.println("###################################");
		}
			
		}
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		ConstructorExc obj1 = new ConstructorExc("Poojitha","Hyd",89);
				obj1.studentDetails();
				obj1.studentResult();
//				obj1.getClass().
		ConstructorExc obj2 = new ConstructorExc("Nikhil","Pune",34); 
				obj2.studentDetails();
				obj2.studentResult();
		ConstructorExc obj3 = new ConstructorExc(); //Default Constructor
				obj3.studentDetails();
				obj3.studentResult();
		ConstructorExc obj4 = new ConstructorExc("Sandeep","Bangalore",78,"XY University"); //Method Overloading based on parameters it invokes corresponding constructor
				obj4.studentDetails();
				obj4.studentResult();
	}

}
