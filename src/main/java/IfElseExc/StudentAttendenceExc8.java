package IfElseExc;

import java.util.Scanner;

public class StudentAttendenceExc8 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of classes held:");
		float totClasses = input.nextFloat();
		System.out.println("Enter the number of classes attended:");
		float attendedClasses = input.nextFloat();
		
		float percentage = ((attendedClasses/totClasses)*100);
		System.out.println("Percentage is "+percentage);
        if(percentage < 75 ) {
        	System.out.println("Student has a medical cause, Y or N ");
        	String confirmation = input.next();
			if(confirmation.equalsIgnoreCase("Y")) {
				System.out.println("Student is allowed to sit in class");
			}else {
				System.out.println("Student is not allowed to sit in class");
			}
		}else {
			System.out.println("Student is allowed to sit in class");
		}	
		
	}

}
