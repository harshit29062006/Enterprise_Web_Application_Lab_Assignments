package Lab_6;

import java.util.Optional;

class Q2 {
    public static void main(String[] args) {
        Optional<String> email =
                Optional.of("student@gmail.com");

        Optional<String> empty = Optional.empty();

        email.ifPresent(e -> System.out.println("Email: " + e));

        System.out.println(
                "Default Email: " +
                empty.orElse("default@gmail.com")
        );

        try {
            System.out.println(
                    empty.orElseThrow(
                            () -> new RuntimeException("Email missing")
                    )
            );
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}