package IfElseExc;

import java.util.Scanner;

public class RectangleExc1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the length:");
		float length = input.nextFloat();
		System.out.println("Enter the breadth:");
		float breadth = input.nextFloat();
		if(length == breadth) {
			System.out.println("It is a square!!");
		}else {
			System.out.println("It is a Rectangle!!");
		}
		
	}

}
