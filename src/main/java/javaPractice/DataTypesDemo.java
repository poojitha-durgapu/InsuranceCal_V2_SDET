package javaPractice;

public class DataTypesDemo {
	int a= 10;
	int b= 10;
	
	char str='b';
	long mb = 675484686;
	
	
	public static void main(String[] args) {
		
		//primitive --- actual value
		// TODO Auto-generated method stub
	int a1 = 10;
	int a2 = new Integer(10);
	if(a1 == a2) {
		System.out.println(true);
	}
	else {
		System.out.println(false);
	}
	
	
	//non- primitive --- reference to memory location
		String string1 = "hELLO";
		
	    String string2 = new String("hELLO");
		if(string1.equals(string2)) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}

	}

}
