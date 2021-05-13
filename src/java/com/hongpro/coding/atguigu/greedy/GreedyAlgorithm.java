package com.hongpro.coding.atguigu.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zhangzihong
 * @version 1.0.0.0
 * @description 贪心算法-交集覆盖
 * @date 2021/5/8 16:35
 */

public class GreedyAlgorithm {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("Beijing");
        hashSet1.add("Shanghai");
        hashSet1.add("Tianjin");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("Beijing");
        hashSet2.add("Guangzhou");
        hashSet2.add("Shenzhen");

        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);

        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("Beijing");

        ArrayList<String> selects = new ArrayList<>();

        HashSet<String> tempSet = new HashSet<>();
        String maxKey;
        while (allAreas.size() != 0) {
            maxKey = null;

            for (String key : broadcasts.keySet()) {
                tempSet.clear();
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                tempSet.retainAll(allAreas);
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }

            if (maxKey != null) {
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));

            }
        }

    }
}
