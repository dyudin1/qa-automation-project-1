package ru.dyudin.homework.gym;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        final ArrayList<Boy> boys = new ArrayList<>() {{
            add(new Boy("Николай", 68));
            add(new Boy("Пётр", 53));
            add(new Boy("Василий", 25));
            add(new Boy("Михаил", 19));
            add(new Boy("Алексей", 6));
            add(new Boy("Николай", 86));
            add(new Boy("Пётр", 35));
            add(new Boy("Михаил", 111));
            add(new Boy("Алексей", 22));
            add(new Boy("Михаил", 1));
            add(new Boy("Яков", 30));
        }};

        ArrayList<String> namesList = new ArrayList<>() {{
            boys.forEach(x -> add(x.getName()));
        }};

        Map<String, Integer> result = new HashMap<>() { };
        boys.stream()
                .sorted(Comparator.comparing(Boy::getName))
                .filter(x -> x.getAge() >= 18)
                .filter(distinctByKey(Boy::getName))
                .limit(4)
                .forEach(x -> result.put(x.getName(), countDuplicates(x.getName(), namesList.toArray())));
        System.out.println(result.toString());
    }

    public static <T> Predicate<T> distinctByKey(final Function<? super T, ?> keyExtractor) {
        final Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    private static Integer countDuplicates(final String input, final Object[] arrayInput) {
        return (int) Arrays.stream(arrayInput)
                .filter(x -> x.equals(input))
                .count() - 1;
    }
}
