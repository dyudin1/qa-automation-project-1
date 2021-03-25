package ru.dyudin.homework.gym;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        final ArrayList<Boy> boys = new ArrayList<>() {{
            add(new Boy("DНиколай", 68));
            add(new Boy("EПётр", 53));
            add(new Boy("BВасилий", 25));
            add(new Boy("CМихаил", 19));
            add(new Boy("AАлексей", 6));
            add(new Boy("DНиколай", 86));
            add(new Boy("EПётр", 35));
            add(new Boy("CМихаил", 111));
            add(new Boy("AАлексей", 22));
            add(new Boy("CМихаил", 1));
            add(new Boy("FЯков", 30));
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

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    private static Integer countDuplicates(String input, Object[] arrayInput) {
        Integer duplicates = 0;
        for (Object o : arrayInput) {
            if (o.equals(input)) {
                duplicates++;
            }
        }
        return duplicates - 1;
    }
}
