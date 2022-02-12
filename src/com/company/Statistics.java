package com.company;

import java.util.*;


public class Statistics {
    private final TreeMap<String, Integer> sortedData;

    public Statistics(TreeMap<String, Integer> data) {
        Comparator<String> comparator = (k1, k2) -> {
            if (k1.equals(k2)) return 0;
            int comp = data.get(k1).compareTo(
                    data.get(k2));
            if (comp == 0)
                return 1;
            else
                return -comp;
        };
        sortedData = new TreeMap<>(comparator);
        sortedData.putAll(data);
    }

    public TreeMap<String, Integer> getData() {
        return sortedData;
    }
}
