package streamAPI;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class IntermediateOperations {
    public static void main(String[] args) {


        Collection<String> collection = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

        //фильтрует по условию
        collection.stream().filter("Wednesday"::equals).count();

        //skip - пропускает N первых элементов
        //distinct - убирает дубликаты
        int n = 2;
        collection.stream().skip(n).distinct();

        //map - преобразует каждый элемент
        collection.stream().map(s -> s + "_2018").collect(Collectors.toList());

        //peek - принимает Consumer (Возвращает тот же стрим, но применяет функцию к каждому элементу стрима)
        collection.stream().peek(System.out::println);

        //limit - ограничивает выборку первыми N эдементами
        collection.stream().limit(n);

        //sorted - либо по-умолчанию / либо по заданному Comparator'у
        collection.stream().sorted();

        //mapToInt - возвращает числовые стримы
        //mapToDouble
        //mapToLong
        collection.stream().mapToInt(String::length);

        //flatMap,
        //flatMapToInt,
        //flatMapToDouble,
        //flatMapToLong
        //// TODO: 11.03.2018 What does this mean?
        String[] days = collection.stream().flatMap(s -> Arrays.asList(s.split("day")).stream()).toArray(String[]::new);
    }
}
