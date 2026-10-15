package Lab_6;

class Q1 {
    static <T extends Number> double sum(T[] arr) {
        double total = 0;

        for (T num : arr) {
            total += num.doubleValue();
        }

        return total;
    }

    public static void main(String[] args) {
        Integer[] a = {10, 20, 30};
        Float[] b = {1.5f, 2.5f, 3.5f};
        Double[] c = {2.5, 3.5, 4.5};

        System.out.println("Integer Sum: " + sum(a));
        System.out.println("Float Sum: " + sum(b));
        System.out.println("Double Sum: " + sum(c));
    }
}