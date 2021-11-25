package com.hongpro.coding.datastrucures.sort;

/**
 * @author zhangzihong
 * @version 1.0.0.0
 * @description
 * @date 2021/11/14 21:36
 */
public class SortService {
    /**
     * 排序通用方法
     * @param sortType 排序类型
     * @param arr 排序数组
     */
    public void sort(int sortType, int[] arr) {
        if (sortType == Sort.BUBBLE) {
            //冒泡排序
            BubbleSort.bubbleSort(arr);
        } else if (sortType == Sort.HEEP) {
            //堆排序
            HeepSort.heepSort(arr);
        } else if (sortType == Sort.INSERT) {
            //插入排序
            InsertSort.insertSort(arr);
        } else if (sortType == Sort.MERGE) {
            //并归排序
            MergeSort.mergeSort(arr, 0, arr.length, new int[arr.length]);
        } else if (sortType == Sort.QUICK) {
            //快速排序
            QuickSort.quickSort(arr, 0, arr.length);
        }
    }

    static class Sort {
        public static final int BUBBLE = 1;

        public static final int HEEP = 2;

        public static final int INSERT = 3;

        public static final int MERGE = 4;

        public static final int QUICK = 5;
    }
}
