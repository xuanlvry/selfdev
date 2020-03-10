package com.sun.dev;

import org.apache.commons.collections.CollectionUtils;

import java.util.*;

/**
 * Created by sunchengfei on 2020/3/10.
 */
public class FundsRank {
    public void printRank(List<String>... ranks) {
        Map<String, Integer> countMap = new HashMap<>();
        for (List<String> item : ranks) {
            count(item, countMap);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(countMap.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        System.out.println("---------------------------");
        for (Map.Entry<String, Integer> item : list) {
            System.out.println(item.getKey() + ":" + item.getValue());
        }
        System.out.println("---------------------------");
    }

    private void count(List<String> rank, Map<String, Integer> countMap) {
        if (CollectionUtils.isEmpty(rank)) {
            return;
        }
        for (String item : rank) {
            int count = 1;
            if (countMap.containsKey(item)) {
                int currentCount = countMap.get(item);
                count = 1 + currentCount;
            }
            countMap.put(item, count);
        }
    }

    public static void main(String[] args) {

    }
}
