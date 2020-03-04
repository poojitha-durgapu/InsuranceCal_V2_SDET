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
	      int size = 5,odd = 1, nos = size/2; // nos =number of spaces
	        for (int i = 1; i <= size; i++) { // for number of rows i.e n rows
	            for (int k = nos; k >= 1; k--) { // for number of spaces i.e
	                                                // 3,2,1,0,1,2,3 and so on
	                System.out.print(" ");
	            }
	            for (int j = 1; j <= odd; j++) { // for number of columns i.e
	                                                // 1,3,5,7,5,3,1
	                System.out.print("*");
	            }
	            System.out.println();
	            if (i < size/2+1) {
	                odd += 2; // columns increasing till center row 
	                nos -= 1; // spaces decreasing till center row 
	            } else {
	                odd -= 2; // columns decreasing
	                nos += 1; // spaces increasing

	            }
	        }
	        System.out.println("##########################3");
	        
	        //patteren 3
	}
	
	
}
