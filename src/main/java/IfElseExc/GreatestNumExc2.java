package IfElseExc;

import java.util.Scanner;

public class GreatestNumExc2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the first Number:");
		int num1 = input.nextInt();
		System.out.println("Enter the second Number:");
		int num2 = input.nextInt();
		if(num1>num2) {
			System.out.println(num1 +" is the greatest number");
		}else {
			System.out.println(num2 +" is the greatest number");
		}
	}

}
