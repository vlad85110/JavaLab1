package com.company;

import java.util.*;


public class Statistics {
    private final ArrayList<HashMap.Entry<String, Integer>> sortedData;
    int size;


    public Statistics(HashMap<String, Integer> data) {
        var set = data.entrySet();
        sortedData = new ArrayList<>(set);
        size = sortedData.size();
        sort();
    }

    private void sort() {
        sortedData.sort(Comparator.comparingInt((HashMap.Entry<String, Integer> a) -> a.getValue()).reversed());
    }

    public ArrayList<HashMap.Entry<String, Integer>> getSortedData() {
        return sortedData;
    }

    public int getSize() {
        return size;
    }
}
