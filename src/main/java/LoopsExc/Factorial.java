package LoopsExc;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the number:");
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		int fact = 1;
		for(int i = 1; i<=n; i++) {
			fact = fact * i;
         }
		System.out.println("Factorial of "+n+" is "+fact);
	}
}
