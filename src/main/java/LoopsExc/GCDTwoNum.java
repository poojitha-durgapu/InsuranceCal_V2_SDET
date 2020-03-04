package LoopsExc;

import java.util.Scanner;

public class GCDTwoNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int num1, num2;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number:");
        num1 = (int)sc.nextInt();
        System.out.print("Enter second number:");
        num2 = (int)sc.nextInt();
        while (num1 != num2) {
        	if(num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
        }
        System.out.printf("GCD of given numbers is: %d", num2);
    }
}
