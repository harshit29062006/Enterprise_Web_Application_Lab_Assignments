import java.util.InputMismatchException;
import java.util.Scanner;

public class Ques3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            double num1 = sc.nextDouble();
            char op = sc.next().charAt(0);
            double num2 = sc.nextDouble();
            
            if (op != '+' && op != '-' && op != '*' && op != '/') {
                throw new IllegalArgumentException("Invalid operator");
            }
            
            if (op == '/' && num2 == 0) {
                throw new ArithmeticException("Division by zero");
            }
            
            double result = 0;
            switch (op) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }
            System.out.println(result);
            
        } catch (InputMismatchException e) {
            System.out.println("Invalid numeric input");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
} 


