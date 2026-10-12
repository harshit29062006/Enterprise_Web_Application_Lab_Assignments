public class Ques1 {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e);
        }

        try {
            String text = null;
            text.length();
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        try {
            int[] numbers = {1, 2, 3};
            int invalidNumber = numbers[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }

        try {
            int value = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
}

