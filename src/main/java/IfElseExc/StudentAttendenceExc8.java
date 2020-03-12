package IfElseExc;

import java.util.Scanner;

public class StudentAttendenceExc8 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of classes held:");
		int totClasses = input.nextInt();
		System.out.println("Enter the number of classes attended:");
		int attendedClasses = input.nextInt();
//		float percentage = (attendedClasses/totClasses)*100;
//		Integer division results in real division(excludes decimal points)
		float percentage = (attendedClasses*100)/totClasses;
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
