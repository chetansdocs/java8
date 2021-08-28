package com.practice.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionGroup {
    public static void main(String[] args) {
        List<String> lstInputStrings = Arrays.asList("chetan", "jyoti", "gaurav", "jyoti", "sushil");
        // Group the elements
        Map<String, List<String>> groupedMap = lstInputStrings.stream().collect(Collectors.groupingBy(Function.identity()));
        groupedMap.forEach((key, value) -> {
            System.out.println( key + ":" + String.join(",", value));
        });

        // Get minimum and maximum count
        Map<String, Long> aggregateCount = lstInputStrings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        aggregateCount.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });

        Optional<List<String>> lstOptional = getDataList();
        System.out.println(lstOptional.orElse(Collections.emptyList()));
    }

    public static Optional<List<String>> getDataList() {
        return Optional.of(Arrays.asList("chetan", "jyoti", "gaurav", "jyoti", "sushil"));
    }
}
