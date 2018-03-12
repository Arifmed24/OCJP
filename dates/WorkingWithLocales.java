package dates;

import java.util.Locale;

public class WorkingWithLocales {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault(); //ru_RU
        System.out.println(locale);
        System.out.println(locale.getCountry());
    }
}
