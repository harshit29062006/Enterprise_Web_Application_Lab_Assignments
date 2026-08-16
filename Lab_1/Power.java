// Write Java Program to Calculate the Power of a Number 

import java.util.Scanner;

public class Power{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the base: ");
        int base = sc.nextInt();
        System.out.print("Enter the exponent: ");
        int exponent = sc.nextInt();

        int result = 1;

        for (int i = 1; i <= exponent; i++){
            result = result * base;
        }

        System.out.println(base + " raised to the power " + exponent + " = " + result);
        sc.close();
    }
}

