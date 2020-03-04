package IfElseExc;

import java.util.Scanner;

public class OldestExc6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the first person's age:");
		int age1 = input.nextInt();
		System.out.println("Enter the second person's age:");
		int age2 = input.nextInt();
		System.out.println("Enter the third person's age:");
		int age3 = input.nextInt();
		if(age1>age2 && age1>age3) {
			if(age2>age3) {
				System.out.println("Person1 is oldest and Person3 is youngest!");
			}else {
				System.out.println("Person1 is oldest and Person2 is youngest!");
			}
		}else if(age2>age1 && age2>age3) {
			if(age1>age3) {
				System.out.println("Person2 is oldest and Person3 is youngest!");
			}else {
				System.out.println("Person2 is oldest and Person1 is youngest!");
			}
		}else if(age3>age1 && age3>age2) {
			if(age2>age1) {
				System.out.println("Person3 is oldest and Person1 is youngest!");
			}else {
				System.out.println("Person3 is oldest and Person2 is youngest!");
			}
		}
	}

}
