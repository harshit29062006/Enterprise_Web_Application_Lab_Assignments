// Write Java Program to Find LCM of two Numbers 

import java.util.Scanner;

public class LCM{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        int lcm = (a * b) / findGCD(a, b);
        System.out.println("LCM = " + lcm);
        sc.close();
    }

    static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

