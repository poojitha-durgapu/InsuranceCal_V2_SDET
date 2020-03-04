package IfElseExc;

import java.util.Scanner;

public class AbsoluteExc7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number:");
		int num = input.nextInt();
		int absoluteValue = Math.abs(num) ;
		System.out.println("Absolute value of "+ num +" is "+ absoluteValue);
	}

}
