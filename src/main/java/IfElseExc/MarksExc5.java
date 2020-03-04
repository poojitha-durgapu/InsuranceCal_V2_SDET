package IfElseExc;

import java.util.Scanner;

public class MarksExc5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the MARKS:");
		int marks = input.nextInt(); 
		if(marks<25) {
			System.out.println("grade is F");
		}else if(marks>=25 && marks<45) {
			System.out.println("grade is E");
		}else if(marks>=45 && marks<50) {
			System.out.println("grade is D");
		}else if(marks>=50 && marks<60) {
			System.out.println("grade is C");
		}else if(marks>=60 && marks<80) {
			System.out.println("grade is B");
		}else if(marks>=80) {
			System.out.println("grade is A");
		}
	}

}
