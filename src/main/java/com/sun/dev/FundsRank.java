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
        List<String> rank1 = Arrays.asList("鹏华新丝路指数", "嘉实农业产业", "国泰估值进取", "工银瑞信中证", "工银瑞信农业", "银华农业产业");
        List<String> rank2 = Arrays.asList("国泰智能汽车", "广发多元新兴", "汇丰晋信低碳先锋", "工银瑞信前沿医疗", "工银瑞信医药健康");
        List<String> rank3 = Arrays.asList("广发多元新兴", "广发医疗保健", "工银瑞信前沿医疗");
        List<String> rank4 = Arrays.asList("信达澳银新能源", "嘉实新兴产业", "工银瑞信前沿医疗", "中欧消费主题A");
        List<String> rank5 = Arrays.asList("兴全全球视野", "海富通精选", "广发聚福后端");
        List<String> rank6 = null;

        FundsRank fundsRank = new FundsRank();
        fundsRank.printRank(rank1, rank2, rank3, rank4, rank5, rank6);
    }
}
