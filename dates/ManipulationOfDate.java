package dates;

import java.time.LocalDate;
import java.time.LocalTime;

public class ManipulationOfDate {
    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        System.out.println("before " + date);
        date = date.plusDays(1); //minusDays
        date = date.plusMonths(1); //minusMonths
        date = date.plusWeeks(1); //minusWeeks
        date = date.plusYears(1); //minusYears
        System.out.println("after " + date);

        //DATE is IMMUTABLE

        LocalTime time = LocalTime.now();
        System.out.println("before " + time);
        time = time.plusHours(1); //minusHours
        time = time.plusMinutes(1); //minusMinutes
        time = time.plusSeconds(1); //minusSeconds
        time = time.plusNanos(1); //minusNanos
        System.out.println("after " + time);

    }
}
