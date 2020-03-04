package LoopsExc;

import java.util.Scanner;

public class Average {
	static int sum;
	public static void main(String[] args) {
		// TODO Auto-generated method stub     
		    int i,num=0,sum=0;
			double average;
		       System.out.println("Enter the 10 numbers : ");    
			for (i=0;i<10;i++)
			{
				Scanner sc = new Scanner(System.in);
				num = sc.nextInt();
				sum += num;
			}
			average=sum/10;
			System.out.println("The sum of 10 numbers is : " +sum+"\nThe Average is : " +average);	
	}
}
