package IfElseExc;

import java.util.Scanner;

public class UpperOrLowerCaseExc11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the alphabet:");
		char charac = input.next().charAt(0); 
		if(Character.isUpperCase(charac)){
			System.out.println("Given Character is Uppercase");
		}else {
			System.out.println("Given Charcter is Lowercase");
		}
	}

}
