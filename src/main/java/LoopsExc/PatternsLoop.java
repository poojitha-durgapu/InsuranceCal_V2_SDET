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
		System.out.println("Pattern 2");
	      int size = 5,odd = 1, nos = size/2; 
	        for (int i = 1; i <= size; i++) { 
	            for (int k = nos; k >= 1; k--) { 
	                                                
	                System.out.print(" ");
	            }
	            for (int j = 1; j <= odd; j++) { 
	                                               
	                System.out.print("*");
	            }
	            System.out.println();
	            if (i < size/2+1) {
	                odd += 2;  
	                nos -= 1;
	            } else {
	                odd -= 2; 
	                nos += 1;

	            }
	        }
	        System.out.println("##########################3");
	        
	        //patteren 3
	}
	
	
}
