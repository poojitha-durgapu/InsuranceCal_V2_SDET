package practiceExc;

public class StudentConstructor {
	

	String StudentName;
	
	public StudentConstructor() {
		 StudentName = "Unknown";
//		 System.out.println("default Constructor");
	}
	public StudentConstructor(String name) {
		StudentName = name;
//		System.out.println("Parameterized Constructor");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentConstructor obj = new StudentConstructor("Poojitha");
		StudentConstructor obj1 = new StudentConstructor();
		System.out.println("Parameterized Constructor----->"+obj.StudentName);
		System.out.println("default Constructor ---->"+obj1.StudentName);
	}

}
