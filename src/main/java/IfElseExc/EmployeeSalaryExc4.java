package IfElseExc;

import java.util.Scanner;

public class EmployeeSalaryExc4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Years of Service  of Employee:");
		int yearsOfService = input.nextInt(); 
		System.out.println("Enter the Salary of Employee:");
		double salry = input.nextDouble();
		if(yearsOfService > 5) {
			double bonus =  (0.05*salry);
			System.out.println("Bonus is: "+bonus);
			salry = salry + bonus;
			System.out.println(salry);
			System.out.println("Total salry is "+ salry);
		}
		
	}

}
