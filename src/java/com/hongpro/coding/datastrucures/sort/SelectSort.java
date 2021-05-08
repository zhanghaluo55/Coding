package com.hongpro.coding.datastrucures.sort;

/**
 * TODO 查找排序
 *
 * @author zhangzihong
 * @data 2021/3/27 14:28
 */
public class SelectSort {
    public static void main(String[] args) {

    }

    public static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }
}
