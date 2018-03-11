import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {

    public static void main(String[] args) throws IOException {
        Collection<String> collection = Arrays.asList("monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

        //1 - from collection
        Stream<String> stream1 = collection.stream();

        //2 - from values
        Stream<String> stream2 = Stream.of("1", "2");

        //3 - from array
        String[] array = collection.toArray(new String[0]);
        Stream<String> stream3 = Arrays.stream(array);

        //4 - from file
//        Stream<String> stream4 = Files.lines(Paths.get("filename.txt"));

        //5 - from string
        IntStream stream5 = "123".chars();

        //6 - from stream builder
        Stream<String> stream6 = Stream.<String>builder().add("1").add("2").build();

        //7 - parallel
        Stream<String> stream7 = collection.parallelStream();

        //8 - iterate / бесконечный
//        Stream<Integer> stream8 = Stream.iterate(1, s -> s + 1);

        //9 - generate / бесконечный
//        Stream<Double> stream9 = Stream.generate(Math::random);
    }
}
