package dates;

import java.time.Period;

public class WorkingWithPeriods {
    public static void main(String[] args) {
        Period period = Period.ofDays(1);
        Period period1 = Period.ofWeeks(1);
        Period period2 = Period.ofMonths(1);
        Period period3 = Period.ofYears(1);
        Period period4 = Period.of(1999, 11, 23);

        System.out.println(Period.of(1, 2, 3)); //P1Y2M3D
        System.out.println(Period.of(0, 20, 31)); //P20M31D
        System.out.println(Period.ofMonths(3)); //P3Mß
        System.out.println(Period.ofWeeks(3)); //P21D
    }
}
