package LoopsExc;

public class PatternsLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Pattern1 
		System.out.println("Pattern 1");
		int n1= 5;
		for (int i=0; i<=n1; i++)
		{
			for (int j=1; j<i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		System.out.println("##########################3");
	      //pattern2
		
	     
	        
	        //patteren 3
//	        1010101
//	        10101 
//	         101  
//	          1   
	        for(int i= 1; i<=5; i++) {
	        	for (int j=1; j<i; j++) {
					System.out.print("1");
				}
				System.out.print("\n");
	        }

	}
	
	
}
