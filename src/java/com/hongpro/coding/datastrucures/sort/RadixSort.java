package com.hongpro.coding.datastrucures.sort;

import java.util.Arrays;

/**
 * TODO 桶排序
 *
 * @author zhangzihong
 * @data 2021/3/30 17:44
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {58, 100, 50, 30, 100, 90, 300};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        int[][] bucket = new int[10][arr.length];
        //每个桶元素的个数
        int[] bucketCount = new int[10];
        int count = 1;
        for (int l = 0; l < maxLength; l++) {
            for (int i = 0; i < arr.length; i++) {
                int element = (arr[i] / count) % 10;
                bucket[element][bucketCount[element]] = arr[i];
                bucketCount[element]++;
            }

            int index = 0;
            for (int i = 0; i < bucketCount.length; i++) {
                if (bucketCount[i] != 0) {
                    for (int j = 0; j < bucketCount[i]; j++) {
                        arr[index++] = bucket[i][j];
                    }
                }
                bucketCount[i] = 0;
            }
            count *= 10;
        }

    }
}
