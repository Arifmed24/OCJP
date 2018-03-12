package dates;

import java.time.*;

public class CreationOfDate {
    public static void main(String[] args) {

        LocalDate date1 = LocalDate.of(2018, Month.MARCH, 12);
        LocalDate date2 = LocalDate.of(2018, 3, 12);

        LocalTime time = LocalTime.of(18, 7);
        LocalTime time1 = LocalTime.of(18, 7, 58);
        LocalTime time2 = LocalTime.of(18, 7, 58, 999_999_999);

        LocalDateTime dateTime = LocalDateTime.of(date1, time1);
        LocalDateTime dateTime1 = LocalDateTime.of(2018, 3, 12, 18, 7);
        LocalDateTime dateTime2 = LocalDateTime.of(2018, 3, 12, 18, 7, 58);
        LocalDateTime dateTime3 = LocalDateTime.of(2018, 3, 12, 18, 7, 58, 999);
        LocalDateTime dateTime4 = LocalDateTime.of(2018, Month.MARCH, 12, 18, 7);
        LocalDateTime dateTime5 = LocalDateTime.of(2018, Month.MARCH, 12, 18, 7, 58);
        LocalDateTime dateTime6 = LocalDateTime.of(2018, Month.MARCH, 12, 18, 7, 58, 999);

        ZoneId zoneId = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, zoneId);
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(date1, time1, zoneId);
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(2018, 3, 12, 18, 7, 58, 999, zoneId);
    }
}
