package javaPractice;

public class MethodsDemo1 {
	public void addition() {
		System.out.println("In addidtion method");
		int num1 = 10;
		int num2 = 20;
		int add = num1 + num2;
		System.out.println(add);
	}
	public int sub(int num1,int num2) {
		System.out.println("In substarction method");
		int subb = num1 - num2;
		
//		System.out.println(subb);
		return subb;
	}
	public void mul(int num1,int num2) {
		System.out.println("In multiplication method");
		int mult = num1 * num2;
		System.out.println(mult);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodsDemo1 obj = new MethodsDemo1();
		obj.addition();
		obj.mul(2,6);
		int result = obj.sub(10,9);
		System.out.println(result);
	}

}
