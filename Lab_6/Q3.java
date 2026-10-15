package Lab_6;

import java.util.Optional;
import java.util.Objects;

class Result<T extends Number> {
    T marks;

    Result(T marks) {
        this.marks = Objects.requireNonNull(marks);
    }

    double percentage() {
        return marks.doubleValue();
    }

    void display() {
        Optional.ofNullable(marks).ifPresent(m -> {
            System.out.println("Marks: " + m);
            System.out.println("Percentage: " + percentage() + "%");

            if (percentage() >= 40) {
                System.out.println("Result: Pass");
            } else {
                System.out.println("Result: Fail");
            }
        });
    }
}

class Q3 {
    public static void main(String[] args) {
        Result<Integer> r = new Result<>(75);
        r.display();
    }
}