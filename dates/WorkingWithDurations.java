package dates;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class WorkingWithDurations {
    public static void main(String[] args) {
        Duration duration = Duration.ofDays(1);
        System.out.println(duration); //PT24H
        Duration duration1 = Duration.ofHours(1);
        System.out.println(duration1); //PT1H
        Duration duration2 = Duration.ofMinutes(1);
        System.out.println(duration2); //PT1M
        Duration duration3 = Duration.ofSeconds(1);
        System.out.println(duration3); //PT1S
        Duration duration4 = Duration.ofMillis(1);
        System.out.println(duration4); //PT0.001S
        Duration duration5 = Duration.ofNanos(1);
        System.out.println(duration5); //PT0.000_000_001S


        Duration duration6 = Duration.of(1, ChronoUnit.DAYS);
        Duration duration7 = Duration.of(1, ChronoUnit.HALF_DAYS);
        Duration duration8 = Duration.of(1, ChronoUnit.MINUTES);
        Duration duration9 = Duration.of(1, ChronoUnit.SECONDS);
        Duration duration10 = Duration.of(1, ChronoUnit.MILLIS);
        Duration duration11 = Duration.of(1, ChronoUnit.NANOS);
    }
}
