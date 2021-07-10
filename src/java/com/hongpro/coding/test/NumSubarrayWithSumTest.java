package com.hongpro.coding.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: zhangzihong
 * @CreateTime: 2021/7/9
 * @Version:
 */
public class NumSubarrayWithSumTest {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));

    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int ret = 0;
        for (int num : nums) {
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            sum += num;
            ret += cnt.getOrDefault(sum - goal, 0);
        }
        return ret;
    }
}
