package dates;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class WorkingWithInstants {
    public static void main(String[] args) {
        Instant instant = Instant.now();

        Instant instant1 = Instant.ofEpochMilli(9999);

        Instant instant2 = Instant.ofEpochSecond(9999);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        Instant instant3 = zonedDateTime.toInstant();

        LocalDateTime dateTime = LocalDateTime.now();
        Instant instant4 = dateTime.toInstant(ZoneOffset.UTC);

        Instant instant5 = instant1.plus(1, ChronoUnit.DAYS);
        System.out.println(instant5);
    }
}
