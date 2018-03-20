package concurrency;

import java.util.Arrays;

/**
 * Created by Aif Balaev
 * on 19/03/2018.
 */
public class ReduceUnderstanding {
    public static void main(String[] args) {
        System.out.println(Arrays.asList("one", "two", "three", "four")
                .parallelStream()
                .reduce(0,
                        (c1, c2) -> {
                            System.out.println(c1 + " " + c2);
                            return c1 + c2.length();
                        },
                        (s1, s2) -> {
                            System.out.println("s1 " + s1 + ", s2 " + s2);
                            return s1 + s2;
                        }));

    }
}
