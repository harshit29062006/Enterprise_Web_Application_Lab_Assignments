package Lab_6;

import java.util.Optional;
import java.util.Objects;

class Utility {
    static <T> boolean isEqual(T a, T b) {
        return Objects.equals(a, b);
    }

    static <T> T getDefault(Optional<T> value, T defaultValue) {
        return value.orElse(defaultValue);
    }

    static <T extends Comparable<T>> T max(T a, T b) {
        return (a.compareTo(b) > 0) ? a : b;
    }

    static boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }
}

class Q5 {
    public static void main(String[] args) {
        System.out.println(Utility.isEqual("Hello", "Hello"));

        System.out.println(
                Utility.getDefault(Optional.empty(), "Default")
        );

        System.out.println(Utility.max(10, 20));

        System.out.println(Utility.max("Apple", "Banana"));

        System.out.println(Utility.isNull(null));
    }
}