package IfElseExc;

import java.util.Scanner;

public class ShopDiscount3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the quantity");
		int units = input.nextInt();
		double cost= units*100;
		System.out.println("cost is "+ cost);
		if(cost > 1000) {
			double discount = 0.1 * cost;
			cost= cost-discount;
			System.out.println("Total cost after discount :"+ cost);
		}else {
			System.out.println("No discount!");
		}	
	}

}
