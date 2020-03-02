package javaPractice;

public class MethodsDemo {
	 
	final static int  num3 =30;

	public void addition() {
		System.out.println("In addidtion method");
		int num1 = 10;
		int num2 = 20;
//		static int num3 =30;
		int add = num1 + num2;
//		num3 = 100;
		System.out.println(add);
	}
	public static void multiplication() {
		System.out.println("In multiplication method");
//		static int num3 =30;
		int num1 = 10;
		int num2 = 20;
		int mult = num1 * num2;
		System.out.println(mult);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodsDemo obj = new MethodsDemo();
		obj.addition();
		System.out.println("number3 is:" + num3);
		//obj.multiplication();
		multiplication(); //as it is static method
		
	}

}
