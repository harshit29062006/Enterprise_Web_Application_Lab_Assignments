package Lab_6;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

class Q4 {
    public static void main(String[] args) {
        String name = "College Fest";
        LocalDate date = LocalDate.of(2026, 12, 20);
        LocalTime time = LocalTime.of(10, 0);

        Optional<String> venue = Optional.empty();

        System.out.println("Event: " + name);
        System.out.println("Date: " + date);
        System.out.println("Start Time: " + time);
        System.out.println("End Time: " + time.plusHours(2));

        if (date.isAfter(LocalDate.now())) {
            System.out.println("Event is in the future");
        } else if (date.isEqual(LocalDate.now())) {
            System.out.println("Event is today");
        } else {
            System.out.println("Event is in the past");
        }

        long days = ChronoUnit.DAYS.between(LocalDate.now(), date);
        System.out.println("Days Remaining: " + days);

        System.out.println(
                "Venue: " + venue.orElse("Venue not specified")
        );
    }
}