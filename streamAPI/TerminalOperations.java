package streamAPI;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TerminalOperations {
    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

        //первый элемент из стрима
        collection.stream().findFirst();

        //любой подходящий элемент из стрима
        collection.stream().findAny();

        //
        collection.stream().collect(Collectors.toList());

        //количество элементов в стриме
        collection.stream().count();

        // true, если условие выполняется хотя бы для одного элемента
        collection.stream().anyMatch("Friday"::equals);

        //true, если условие выполняется для всех элементов
        collection.stream().allMatch("Friday"::equals);

        //true, если условие не выполняется ни для одного элемента
        collection.stream().noneMatch("Friday"::equals);

        //min / max с параметром в качестве Comparator'a
        collection.stream().min(Comparator.comparingInt(String::length));

        //порядок при параллельном выполнении не гарантируется
        collection.stream().forEach(System.out::println);

        //сохранение порядка элементов гарантирует
        collection.stream().forEachOrdered(System.out::println);

        collection.stream().toArray();

        //агрегатные функции на всей коллекцией и возвращать один результат
        System.out.println(collection.stream().reduce((s1, s2) -> s1.concat(s2)).get());

    }
}
