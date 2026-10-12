public class Ques2 {
    public static void main(String[] args) {
        try {
            try {
                int result = 10 / 0;
            } catch (NullPointerException e) {
                System.out.println(e);
            }
            int[] arr = {1};
            arr[5] = 10;
        } catch (ArithmeticException e) {
            System.out.println("Outer caught: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer caught: " + e);
        }
    }
}
