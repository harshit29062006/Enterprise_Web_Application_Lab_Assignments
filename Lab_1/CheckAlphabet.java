// Write Java Program to Check Whether a Character is Alphabet or Not

import java.util.Scanner;

public class CheckAlphabet{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a character: ");
        char c = sc.next().charAt(0);

        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')){
            System.out.println("It is an alphabet.");
        } 
        else{
            System.out.println("It is not an alphabet.");
        }
        sc.close();
    }
}

