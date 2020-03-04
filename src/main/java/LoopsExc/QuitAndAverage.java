package LoopsExc;

import java.util.Scanner;

public class QuitAndAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start entering numbers");
		int sum=0;
		String enteredValue ="";
		int counter = 0;
		int product = 1;
		Scanner sc = new Scanner(System.in);
		while(!(enteredValue.equals("q"))) {
			System.out.println("To quit, press q");
			enteredValue = sc.next();
			if(!(enteredValue.equals("q"))) {
				int num = Integer.parseInt(enteredValue);
		        sum = sum+num;
		        product = product*num;
		        counter++;
			}
//		    int num=sc.nextInt();
//		    counter=counter+1;
//		    sum=sum+num;
//		    product = product*num;
//		    System.out.println(product);
//		    System.out.println("To quit, press 6");
//		    if(sc.next() == "q") {
//		    	break;
//		    }
//		    String quitConfirm = sc.next();
//		    if(quitConfirm.equalsIgnoreCase("q")) {
//		    	System.out.println("broke!");
//		    	 break;
//		    }
	}
		System.out.println("Average is "+sum/counter);
		System.out.println("Sum is "+sum);
		System.out.println("Product is "+product);
	}
	
}
