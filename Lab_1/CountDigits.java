// Write Java Program to Count Number of Digits in an Integer 

import java.util.Scanner;

public class CountDigits{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int n = sc.nextInt();

        int count = 0;

        while (n != 0) {
            n = n / 10;
            count++;
        }

        System.out.println("Number of digits = "+count);
        sc.close();
    }
}


