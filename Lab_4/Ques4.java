import java.util.Scanner;

class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

public class Ques4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] marks = new int[3];
        int total = 0;

        try {
            for (int i = 0; i < marks.length; i++) {
                marks[i] = sc.nextInt();
                if (marks[i] < 0 || marks[i] > 100) {
                    throw new InvalidMarksException("Invalid marks entered");
                }
                total += marks[i];
            }
            double percentage = total / (double) marks.length;
            String grade = percentage >= 50 ? "Pass" : "Fail";
            System.out.println(total);
            System.out.println(percentage);
            System.out.println(grade);
        } catch (InvalidMarksException e) {
            System.out.println(e.getMessage());
        }
    }
}